package com.gmail.brian.controller;

import com.gmail.brian.model.Circle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@Route("circular-duct")
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class CircularController extends VerticalLayout {
    Circle circle;

    TextField diameter = new TextField("Podaj długość średnicy D: [mm]");
    TextField thicnessIsolation = new TextField("Podaj grubość izolacji: [mm]");
    Button button = new Button("Oblicz");
    Checkbox isolationCirc = new Checkbox();
    Checkbox outdoorCirc = new Checkbox();
    Anchor returnToMenu = new Anchor("/", "Powrót do menu głównego");

    private TextField result;

    @Autowired
    public CircularController(Circle circle) {

        this.circle = circle;
        isolationCirc.setLabel("Czy przewód posiada izolację?");
        isolationCirc.setValue(false);
        isolationCirc.addValueChangeListener(click -> {
            if (isolationCirc.getValue() == true) {
                thicnessIsolation.setValue("0");
                add(thicnessIsolation);
                outdoorCirc.setEnabled(true);
            } else {
                remove(thicnessIsolation);
                outdoorCirc.setValue(false);
                outdoorCirc.setEnabled(false);
            }
        });

        outdoorCirc.setEnabled(false);
        outdoorCirc.setLabel("Czy przewód jest na zewnątrz?");
        outdoorCirc.setValue(false);

        result = new TextField("Ciężar przewodu okrągłego: [kg]");



        add(diameter, isolationCirc, outdoorCirc, button, result, returnToMenu);

        button.addClickListener(click -> {
            createCircular();
            result.setValue(String.valueOf(circle.CalculationWeigh()));
        });
    }

    private Circle createCircular() {
        circle.setDiameter(Integer.parseInt(diameter.getValue()));
        circle.setInsulation(isolationCirc.getValue());
        if (circle.isInsulation()) {
            circle.setInsulationThickness(Integer.parseInt(thicnessIsolation.getValue()));
        }
        circle.setOutdoor(outdoorCirc.getValue());
        return circle;
    }
}
