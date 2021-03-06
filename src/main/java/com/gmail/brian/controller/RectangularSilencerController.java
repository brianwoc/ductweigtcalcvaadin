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


@Route("rectangular-silencer")
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class RectangularSilencerController extends VerticalLayout {
    Rectangular rectangular;

    TextField sideA = new TextField("Podaj długość boku A: [mm]");
    TextField sideB = new TextField("Podaj długość boku B: [mm]");
    TextField thicnessIsolation = new TextField("Podaj grubość izolacji: [mm]");
    TextField silencerWeight = new TextField("Podaj cieżar samego tłumika: [kg]");
    Button button = new Button("Oblicz");
    Checkbox isolationRect =new Checkbox();
    Checkbox outdoorRect = new Checkbox();
    Anchor returnToMenu = new Anchor("/", "Powrót do menu głównego");
    private TextField result;

    @Autowired
    public RectangularSilencerController(Rectangular rectangular) {

        this.rectangular = rectangular;

        isolationRect.setLabel("Czy przewód posiada izolację?");
        isolationRect.setSizeFull();
        isolationRect.setValue(false);
        isolationRect.addValueChangeListener(click -> {
            if (isolationRect.getValue() == true) {
                thicnessIsolation.setValue("0");
                add(thicnessIsolation);
                outdoorRect.setEnabled(true);
            }else {
                remove(thicnessIsolation);
                outdoorRect.setValue(false);
                outdoorRect.setEnabled(false);
            }
        });

        silencerWeight.setValue("0");
        silencerWeight.setWidth("250px");


        outdoorRect.setEnabled(false);
        outdoorRect.setLabel("Czy przewód jest na zewnątrz?");
        outdoorRect.setValue(false);

        result = new TextField("Ciężar przewodu prostokątnego: [kg]");
        result.setWidth("250px");

        add(sideA, sideB, silencerWeight, isolationRect, outdoorRect, button, result, returnToMenu);

        button.addClickListener(click -> {
            createRectangular();
            result.setValue(String.valueOf(rectangular.CalculationWeighSilencer(Double.parseDouble(silencerWeight.getValue()))));
        });
    }

    private Rectangular createRectangular() {
        rectangular.setSideA(Integer.parseInt(sideA.getValue()));
        rectangular.setSideB(Integer.parseInt(sideB.getValue()));
        rectangular.setInsulation(isolationRect.getValue());
        if (rectangular.isInsulation()) {
            rectangular.setInsulationThickness(Integer.parseInt(thicnessIsolation.getValue()));
        }
        rectangular.setOutdoor(outdoorRect.getValue());
        rectangular.Thickness();
        return rectangular;
    }
}
