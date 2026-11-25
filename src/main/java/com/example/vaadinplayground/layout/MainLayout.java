
package com.example.vaadinplayground.layout;

import com.example.vaadinplayground.view.ContextMenuView;
import com.example.vaadinplayground.view.DashboardView;
import com.example.vaadinplayground.view.RegisterView;
import com.example.vaadinplayground.view.TabsView;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.example.vaadinplayground.view.RichTextEditorView;

public class MainLayout extends AppLayout {

    public MainLayout() {

        // Application title
        H2 title = new H2("Vaadin Playground");

        // Create MenuBar
        MenuBar menuBar = new MenuBar();

        // File menu
        var fileMenu = menuBar.addItem("File");

        fileMenu.getSubMenu().addItem("New", event ->
                Notification.show("New clicked"));

        fileMenu.getSubMenu().addItem("Save", event ->
                Notification.show("Save clicked"));

        // Help menu
        var helpMenu = menuBar.addItem("Help");

        helpMenu.getSubMenu().addItem("About", event ->
                Notification.show("Vaadin Playground Application"));

        // Add title and MenuBar to top navbar
        addToNavbar(title, menuBar);

        // Create SideNav
        SideNav sideNav = new SideNav();

        // Add navigation items
        sideNav.addItem(
                new SideNavItem("Dashboard", DashboardView.class));

        sideNav.addItem(
                new SideNavItem("Register", RegisterView.class));

        sideNav.addItem(
                new SideNavItem("Tabs Demo", TabsView.class));

        sideNav.addItem(
                new SideNavItem("Context Menu", ContextMenuView.class));

        sideNav.addItem(
                new SideNavItem("Rich Text Editor", RichTextEditorView.class));

        // Add SideNav to left drawer
        addToDrawer(sideNav);
    }
}
