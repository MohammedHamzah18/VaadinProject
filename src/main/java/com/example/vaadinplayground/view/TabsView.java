
package com.example.vaadinplayground.view;

import com.example.vaadinplayground.layout.MainLayout;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "tabs", layout = MainLayout.class)
@PageTitle("Tabs Demo")
public class TabsView extends VerticalLayout {

    public TabsView() {

        // Page heading
        H3 heading = new H3("Tabs Component Demo");

        // Create individual Tab components
        Tab personalTab = new Tab("Personal");
        Tab educationTab = new Tab("Education");
        Tab skillsTab = new Tab("Skills");

        // Group all tabs using Tabs component
        Tabs tabs = new Tabs(
                personalTab,
                educationTab,
                skillsTab
        );

        // Content area
        Div content = new Div();

        // Listen for tab selection
        tabs.addSelectedChangeListener(event -> {

            Tab selectedTab = event.getSelectedTab();

            // Clear previous content
            content.removeAll();

            if (selectedTab == personalTab) {

                content.add(
                        new H3("Personal Details"),
                        new Paragraph("Name: Mohammed"),
                        new Paragraph("Age: 22")
                );

            } else if (selectedTab == educationTab) {

                content.add(
                        new H3("Education Details"),
                        new Paragraph("Degree: B.Tech"),
                        new Paragraph("Department: Information Technology")
                );

            } else if (selectedTab == skillsTab) {

                content.add(
                        new H3("Technical Skills"),
                        new Paragraph("Java"),
                        new Paragraph("Spring Boot"),
                        new Paragraph("Vaadin")
                );
            }
        });

        // Set initial content
        content.add(
                new H3("Personal Details"),
                new Paragraph("Name: Mohammed"),
                new Paragraph("Age: 22")
        );

        // Add components to page
        add(heading, tabs, content);

        setPadding(true);
        setSpacing(true);
    }
}
