package com.gmail.brian.domain;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;


@Route
@PWA(name = "Vaadin Application",
        shortName = "Vaadin App",
        description = "This is an example Vaadin application.",
        enableInstallPrompt = false)
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends VerticalLayout {


    public MainView() {
        TextField sideA = new TextField("Podaj długość boku A");
        TextField sideB = new TextField("Podaj długość boku B");
        Checkbox isolationRect = new Checkbox();
        isolationRect.setLabel("Czy przewód posiada izolację?");
        isolationRect.setValue(true);

        Checkbox outdoorRect = new Checkbox();
        outdoorRect.setLabel("Czy przewód jest na zewnątrz?");
        outdoorRect.setValue(true);

        Button button = new Button("Oblicz");

        add(sideA,sideB, isolationRect, outdoorRect, button);
    }
}
