
package com.example.vaadinplayground.view;

import com.example.vaadinplayground.layout.MainLayout;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = MainLayout.class)
@PageTitle("Dashboard")
public class DashboardView extends VerticalLayout {

    public DashboardView() {

        // Dashboard heading
        H2 heading = new H2("Welcome to Vaadin Playground");

        // Description
        Paragraph message = new Paragraph(
                "Explore and learn different Vaadin components."
        );

        // Register button
        Button registerButton = new Button("Register");

        // Navigate to Register page when clicked
        registerButton.addClickListener(event -> {
            getUI().ifPresent(ui ->
                    ui.navigate("register"));
        });

        // Add components to the layout
        add(heading, message, registerButton);

        // Layout configuration
        setSpacing(true);
        setPadding(true);
    }
}
