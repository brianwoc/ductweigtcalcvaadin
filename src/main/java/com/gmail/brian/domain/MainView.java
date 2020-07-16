package com.gmail.brian.domain;

import com.gmail.brian.model.Rectangular;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.springframework.beans.factory.annotation.Autowired;


@Route
@PWA(name = "Duct Weigt Calculator",
        shortName = "DWC",
        description = "An application that calculates the weight of ventilation ducts",
        enableInstallPrompt = false)
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends VerticalLayout {
    Rectangular rectangular;

    TextField sideA = new TextField("Podaj długość boku A: [mm]");
    TextField sideB = new TextField("Podaj długość boku B: [mm]");
    TextField thicnessIsolation = new TextField("Podaj grubość izolacji: [mm]");
    Button button = new Button("Oblicz");
    private Checkbox isolationRect;
    private Checkbox outdoorRect;
    private TextField result;

    @Autowired
    public MainView(Rectangular rectangular) {

        this.rectangular = rectangular;
        isolationRect = new Checkbox();
        isolationRect.setLabel("Czy przewód posiada izolację?");
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

        outdoorRect = new Checkbox();
        outdoorRect.setEnabled(false);
        outdoorRect.setLabel("Czy przewód jest na zewnątrz?");
        outdoorRect.setValue(false);

        result = new TextField("Ciężar przewodu: [kg]");

        add(sideA, sideB, isolationRect, outdoorRect, button, result);

        button.addClickListener(click -> {
            createRectangular();
            result.setValue(String.valueOf(rectangular.CalculationWeigh()));
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
        return rectangular;
    }
}
