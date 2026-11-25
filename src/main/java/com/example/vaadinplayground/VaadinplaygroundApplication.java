package com.example.vaadinplayground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;

@SpringBootApplication
@Theme("vaadinplayground")
public class VaadinplaygroundApplication implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(VaadinplaygroundApplication.class, args);
    }

}