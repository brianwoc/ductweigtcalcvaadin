package com.gmail.brian.controller;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@Route("Autor")
public class AutorController extends VerticalLayout {

    H1 h1 = new H1("O autorze");
    String content = "<div>Student Politechniki Śląskiej. <br> Mam dwie pasje które probuje łączyć i rozwijać: programowanie i HVAC</div>";
    Html html = new Html(content);

    Anchor returnToMenu = new Anchor("/", "Powrót do menu głównego");

    @Autowired
    public AutorController() {
        add(h1, html, returnToMenu);
    }
}
