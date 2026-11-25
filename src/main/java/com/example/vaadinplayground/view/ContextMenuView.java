
package com.example.vaadinplayground.view;

import com.example.vaadinplayground.layout.MainLayout;

import com.vaadin.flow.component.contextmenu.ContextMenu;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "context-menu", layout = MainLayout.class)
@PageTitle("Context Menu Demo")
public class ContextMenuView extends VerticalLayout {

    public ContextMenuView() {

        // Page heading
        H3 heading = new H3("Context Menu Demo");

        // Instructions
        Paragraph instructions = new Paragraph(
                "Right-click the product box to open the menu."
        );

        // Create product box
        Div productBox = new Div();
        productBox.setText("Product: Laptop");

        productBox.getStyle()
                .set("border", "2px solid gray")
                .set("padding", "40px")
                .set("width", "300px")
                .set("cursor", "pointer");

        // Create ContextMenu and attach it to productBox
        ContextMenu contextMenu = new ContextMenu(productBox);

        // View action
        contextMenu.addItem("View", event ->
                Notification.show("Viewing Laptop"));

        // Edit action
        contextMenu.addItem("Edit", event ->
                Notification.show("Editing Laptop"));

        // Delete action
        contextMenu.addItem("Delete", event ->
                Notification.show("Laptop deleted"));

        // Add components to page
        add(heading, instructions, productBox);

        setPadding(true);
        setSpacing(true);
    }
}
