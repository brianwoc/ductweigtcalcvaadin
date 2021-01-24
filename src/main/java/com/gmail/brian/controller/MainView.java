package com.gmail.brian.controller;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;

//@PWA(name = "Duct Weight Calculator",
//		shortName = "DWC",
//		description = "An application that calculates the weight of ventilation ducts",
//		enableInstallPrompt = false)
@Route("")
@CssImport("./styles/shared-styles.css")
public class MainView extends VerticalLayout {

	public MainView() {
		// HEADER
		Icon drawer = VaadinIcon.MENU.create();
		Span title = new Span("Program do obliczania cieżaru przewodów wentylacyjnych okrągłych i prostokątnych");
		Icon help = VaadinIcon.QUESTION_CIRCLE.create();
		HorizontalLayout header = new HorizontalLayout(drawer, title, help);
		header.expand(title);
		header.setPadding(false);
		header.setWidth("100%");

		// WORKSPACE
		VerticalLayout workspace = new VerticalLayout(
				createCard("/rectangular-duct", "OBLICZENIE DLA PRZEWODÓW PROSTOKĄTNYCH"),
				createCard("/circular-duct", "OBLICZENIE DLA PRZEWODÓW OKRĄGŁYCH"),
				createCard("/rectangular-silencer", "OBLICZENIA DLA TŁUMIKÓW PROSTOKĄTNYCH"),
				createCard("/rectangular-wool-duct", "OBLICZENIE DLA PRZEWODÓW PROSTOKĄTNYCH Z WEŁNY MINERALNEJ"),
				createCard("/rectangular-promat-duct", "OBLICZENIE DLA PRZEWODÓW PROSTOKĄTNYCH Z PROMATU")

		);
		workspace.addClassName("workspace");
		workspace.setSizeFull();

		// FOOTER
		Tab actionButton1 = new Tab(VaadinIcon.HOME.create(), new Anchor("/","Home"));
		Tab actionButton2 = new Tab(VaadinIcon.SQUARE_SHADOW.create(), new Anchor("rectangular-duct", "Prostokątne"));
		Tab actionButton3 = new Tab(VaadinIcon.CIRCLE.create(), new Anchor("circular-duct","Okrągłe"));
		Tab actionButton4 = new Tab(VaadinIcon.SQUARE_SHADOW.create(), new Anchor("rectangular-wool-duct", "Wełna"));
		Tab actionButton5 = new Tab(VaadinIcon.SQUARE_SHADOW.create(), new Anchor("rectangular-silencer", "Tłumik"));
		Tab actionButton6 = new Tab(VaadinIcon.SQUARE_SHADOW.create(), new Anchor("rectangular-promat-duct", "Promat"));

		actionButton1.setClassName("tab");
		actionButton2.setClassName("tab");
		actionButton3.setClassName("tab");
		actionButton4.setClassName("tab");
		actionButton5.setClassName("tab");
		actionButton6.setClassName("tab");

		Tabs buttonBar = new Tabs(actionButton1, actionButton2, actionButton3, actionButton4, actionButton5, actionButton6);
		HorizontalLayout footer = new HorizontalLayout(buttonBar);
		footer.setJustifyContentMode(JustifyContentMode.CENTER);
		footer.setWidth("100%");

		// MENU
		VerticalLayout sideMenu = new VerticalLayout();
		sideMenu.addClassName("sideMenu");
		sideMenu.setHeight("100%");
		sideMenu.setWidth("auto");
		sideMenu.setSpacing(false);
		drawer.getElement().addEventListener("click", ev->sideMenu.getStyle().set("left", "0px"));
		Icon avatar = VaadinIcon.USER.create();
		avatar.setSize("4em");
		sideMenu.add(avatar, new Span("Brian"),createMenuOption("Autor"), createMenuOption("Program"), createMenuOption("Kontakt"));
		sideMenu.setAlignItems(Alignment.CENTER);


		// CONTAINER
		setSizeFull();
		setMargin(false);
		setSpacing(false);
		setPadding(false);
		add(sideMenu, header, workspace, footer);
	}

	private Button createMenuOption(String title) {
		Button m1 = new Button(title);
		m1.setWidth("100%");
		m1.addClickListener(ev -> m1.getElement().getParent().getStyle().set("left", "-1000px"));
		m1.addClickListener(ev -> Notification.show("Button " + title + " clicked."));
		m1.addClickListener(ev -> UI.getCurrent().navigate(title));
		return m1;
	}

	private Component createCard(String link, String text) {
		Span card1Label = new Span(new Anchor(link,text));
		FlexLayout card = new FlexLayout(card1Label);
		card.addClassName("card");
		card.setAlignItems(Alignment.CENTER);
		card.setJustifyContentMode(JustifyContentMode.CENTER);
		card.setWidth("100%");
		card.setHeight("200px");
		return card;
	}

}
