
package com.example.vaadinplayground.view;

import com.example.vaadinplayground.layout.MainLayout;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "register", layout = MainLayout.class)
@PageTitle("Register")
public class RegisterView extends VerticalLayout {

    public RegisterView() {

        // Name input
        TextField name = new TextField("Full Name");
        name.setPlaceholder("Enter your name");

        // Email input
        EmailField email = new EmailField("Email");
        email.setPlaceholder("Enter your email");

        // Password input
        PasswordField password = new PasswordField("Password");
        password.setPlaceholder("Enter your password");

        // Gender dropdown
        ComboBox<String> gender = new ComboBox<>("Gender");
        gender.setItems("Male", "Female", "Other");

        // Register button
        Button registerButton = new Button("Register");

        // Button click event
        registerButton.addClickListener(event -> {

            // Validate inputs
            if (name.isEmpty()
                    || email.isEmpty()
                    || password.isEmpty()
                    || gender.isEmpty()) {

                Notification.show("Please fill all fields");
                return;
            }

            // Check email format
            if (!email.isInvalid()) {

                Notification.show("Registration successful!");

                // Clear fields
                name.clear();
                email.clear();
                password.clear();
                gender.clear();

            } else {
                Notification.show("Please enter a valid email");
            }
        });

        // Add components to page
        add(name, email, password, gender, registerButton);

        setSpacing(true);
        setPadding(true);
        setMaxWidth("450px");
    }
}
