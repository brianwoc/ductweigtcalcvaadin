package com.gmail.brian.controller;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("Kontakt")
public class ContactController extends VerticalLayout {

    H1 h1 = new H1("Kontakt");
    Text text = new Text("Uwagi proszę kierować pod następujący adres: br.skrzynka@gmail.com");

    Anchor returnToMenu = new Anchor("/", "Powrót do menu głównego");

    @Autowired
    public ContactController() {
        add(h1,text,returnToMenu);
    }
}
