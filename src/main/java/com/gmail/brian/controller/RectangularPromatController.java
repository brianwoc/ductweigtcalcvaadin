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


@Route("rectangular-promat-duct")
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class RectangularPromatController extends VerticalLayout {
    Rectangular rectangular;
//    MainView mainView;

    TextField sideA = new TextField("Podaj długość boku A: [mm]");
    TextField sideB = new TextField("Podaj długość boku B: [mm]");
    TextField thicnessIsolation = new TextField("Podaj grubość Promatu (grubość przewodu z Promatu 40mm to EIS60, 50mm to EIS120, 60mm to EIS240): [mm]");

    Button button = new Button("Oblicz");
    Checkbox isolationRect =new Checkbox();
    Anchor returnToMenu = new Anchor("/", "Powrót do menu głównego");
    private TextField result;



    @Autowired
    public RectangularPromatController(Rectangular rectangular) {


//        mainView = new MainView();

        this.rectangular = rectangular;

        isolationRect.setLabel("Przewód z Promatu odblokuj okienko grubości)");
        isolationRect.setSizeFull();
        isolationRect.setValue(false);
        isolationRect.addValueChangeListener(click -> {
            if (isolationRect.getValue() == true) {
                thicnessIsolation.setValue("0");
                thicnessIsolation.setSizeFull();
                add(thicnessIsolation);
            }else {
                remove(thicnessIsolation);
            }
        });



        result = new TextField("Ciężar przewodu prostokątnego: [kg/mb]");
        result.setWidth("250px");

        add(sideA, sideB, isolationRect, button, result, returnToMenu /*mainView*/);

        button.addClickListener(click -> {
            createRectangular();
            result.setValue(String.valueOf(rectangular.CalculationWeighPromat()));
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
