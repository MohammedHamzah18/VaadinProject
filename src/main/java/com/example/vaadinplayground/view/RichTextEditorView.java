
package com.example.vaadinplayground.view;

import com.example.vaadinplayground.layout.MainLayout;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.richtexteditor.RichTextEditor;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "rich-text-editor", layout = MainLayout.class)
@PageTitle("Rich Text Editor")
public class RichTextEditorView extends VerticalLayout {

    public RichTextEditorView() {

        // Page heading
        H3 heading = new H3("Rich Text Editor Demo");

        // Create RichTextEditor
        RichTextEditor editor = new RichTextEditor();

        // Set initial content
        editor.setValue("<h3>Welcome to Vaadin</h3>"
                + "<p>Start writing your content here.</p>");

        // Save button
        Button saveButton = new Button("Save Content");

        saveButton.addClickListener(event -> {

            String content = editor.getValue();

            Notification.show("Content captured successfully!");

            System.out.println("Editor content: " + content);
        });

        // Clear button
        Button clearButton = new Button("Clear");

        clearButton.addClickListener(event -> {
            editor.clear();
            Notification.show("Editor cleared");
        });

        // Add components
        add(heading, editor, saveButton, clearButton);

        setPadding(true);
        setSpacing(true);
    }
}
