package com.gmail.brian.controller;

import com.gmail.brian.model.Rectangular;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@Route("rectangular-wool-duct")
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class RectangularWoolController extends VerticalLayout {
    Rectangular rectangular;

    TextField sideA = new TextField("Podaj długość boku A: [mm]");
    TextField sideB = new TextField("Podaj długość boku B: [mm]");
    TextField thicnessIsolation = new TextField("Podaj grubość izolacji (grubość przewodu z wełny np. 25mm lub 40mm): [mm]");
    Button button = new Button("Oblicz");
    Checkbox isolationRect =new Checkbox();
    Anchor returnToMenu = new Anchor("/", "Powrót do menu głównego");
    private TextField result;

    @Autowired
    public RectangularWoolController(Rectangular rectangular) {

        this.rectangular = rectangular;

        isolationRect.setLabel("Czy przewód posiada izolację? (Przewód z wełny musi posiadać izolację)");
        isolationRect.setSizeFull();
        isolationRect.setValue(false);
        isolationRect.addValueChangeListener(click -> {
            if (isolationRect.getValue() == true) {
                thicnessIsolation.setValue("0");
                add(thicnessIsolation);
            }else {
                remove(thicnessIsolation);
            }
        });



        result = new TextField("Ciężar przewodu prostokątnego: [kg]");
        result.setWidth("250px");

        add(sideA, sideB, isolationRect, button, result, returnToMenu);

        button.addClickListener(click -> {
            createRectangular();
            result.setValue(String.valueOf(rectangular.CalculationWeigh()));
        });
    }

    private Rectangular createRectangular() {
        rectangular.setSteelThickness(0);
        rectangular.setSideA(Integer.parseInt(sideA.getValue()));
        rectangular.setSideB(Integer.parseInt(sideB.getValue()));
        rectangular.setInsulation(isolationRect.getValue());
        if (rectangular.isInsulation()) {
            rectangular.setInsulationThickness(Integer.parseInt(thicnessIsolation.getValue()));
        }
        return rectangular;
    }
}
