package com.gmail.brian.controller;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("Program")

public class ProgramController extends VerticalLayout {


    H1 h1 = new H1("O programie");
    String content = "<div>Program oblicza ciężar przewodów wentylacyjnych wykonanych z blachy ocynkowanej. <br>" +
            "Obliczenia są możliwe do przewodów okrągłych typu spiro oraz przewodów prostokątnych. <br>"+
            "Główne zalety programu:"+
            "<ul><li>Automatycznie wylicznie grubości blachy na podstawie wymiarów przewodu</li>" +
            "<li>Możliwość zamodelowania każdego wymiaru przewodu</li>" +
            "<li>Możliwość zamodelowania każdej grubości izolacji przewodu</li>" +
            "<li>W przypadku montażu na zewnątrz przewodu, program automatycznie uwzględnia płaszcz z blachy ocynkowanej</li>" +
            "</ul>"+
            "</div>";
    Html html = new Html(content);

    Image rectangularNoIso = new Image("https://i.ibb.co/Ld80tXZ/prost-bez-izo.jpg", "Wzorcowe obciążenia dla przewodów prostokątnych bez izolacji");
    Image rectangularIso = new Image("https://i.ibb.co/MCh7pF8/prost-izo.jpg", "Wzorcowe obciążenia dla przewodów prostokątnych bez izolacji");
    Image promatExample = new Image("https://i.ibb.co/c6f7Hj4/Promat-example.jpg", "Przykład obliczeniowy dla przewodów prostokątnych z promatu");


    Anchor returnToMenu = new Anchor("/", "Powrót do menu głównego");

    @Autowired
    public ProgramController() {
        add(h1, html, rectangularNoIso,rectangularIso, promatExample, returnToMenu);
    }
}



