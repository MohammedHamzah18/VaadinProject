package com.example.vaadinplayground;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.server.streams.UploadHandler;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.component.combobox.MultiSelectComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;

@Route("login")
public class LoginView extends VerticalLayout {

    public LoginView() {

        // Title
        H1 title = new H1("Login Page");

        // Email
        EmailField email = new EmailField("Email");

        // Password
        PasswordField password = new PasswordField("Password");

        // Select Component
        Select<String> role = new Select<>();
        role.setLabel("Select Role");
        role.setItems("Admin", "User", "Manager");
        role.setPlaceholder("Choose your role");

        // Checkbox Component
        Checkbox rememberMe = new Checkbox("Remember Me");

        // RadioButtonGroup Component
        RadioButtonGroup<String> gender = new RadioButtonGroup<>();
        gender.setLabel("Gender");
        gender.setItems("Male", "Female", "Other");

        // ListBox Component
        ListBox<String> department = new ListBox<>();
        department.setItems(
                "IT",
                "HR",
                "Finance",
                "Marketing"
        );

        // Grid Component
        Grid<String> employeeGrid = new Grid<>();

        employeeGrid.addColumn(employee -> employee)
                .setHeader("Employee Name");

        employeeGrid.setItems(
                "Hamzah",
                "Rahman",
                "Ahmed",
                "Sanjay"
        );

        employeeGrid.setWidth("300px");

        // Upload Component
        Upload upload = new Upload(
                UploadHandler.inMemory((metadata, data) -> {
                    // Uploaded file is received here
                })
        );

        upload.setAcceptedFileExtensions(".jpg", ".png", ".pdf");
        upload.setMaxFiles(1);
        upload.setMaxFileSize(5 * 1024 * 1024);
        upload.setWidth("300px");

        // Dialog Component
        Dialog dialog = new Dialog();

        H1 dialogTitle = new H1("Login Successful!");

        Button closeButton = new Button("Close");
        closeButton.addClickListener(event -> dialog.close());

        dialog.add(dialogTitle, closeButton);

        // Icon Component
        Icon userIcon = VaadinIcon.USER.create();

        // Login Button
        Button loginButton = new Button(
                "Login",
                VaadinIcon.SIGN_IN.create()
        );

        loginButton.addClickListener(event -> dialog.open());

        // DatePicker Component
        DatePicker datePicker = new DatePicker("Date of Birth");
        datePicker.setPlaceholder("Select your date");
        datePicker.setMax(LocalDate.now());

        // TimePicker Component
        TimePicker timePicker = new TimePicker("Select Time");
        timePicker.setPlaceholder("Choose a time");

        // ConfirmDialog Component
        ConfirmDialog confirmDialog = new ConfirmDialog();

        confirmDialog.setHeader("Confirmation");
        confirmDialog.setText("Are you sure you want to continue?");
        confirmDialog.setCancelable(true);
        confirmDialog.setConfirmText("Yes");
        confirmDialog.setCancelText("No");

        confirmDialog.addConfirmListener(event ->
                Notification.show("You confirmed!")
        );

        confirmDialog.addCancelListener(event ->
                Notification.show("You cancelled!")
        );

        Button confirmButton = new Button(
                "Open Confirm Dialog",
                event -> confirmDialog.open()
        );

        // Tabs Component
        Tab profileTab = new Tab("Profile");
        Tab settingsTab = new Tab("Settings");
        Tab helpTab = new Tab("Help");

        Tabs tabs = new Tabs(
                profileTab,
                settingsTab,
                helpTab
        );

        // MenuBar Component
        MenuBar menuBar = new MenuBar();

        menuBar.addItem("Home", event ->
                Notification.show("Home clicked")
        );

        MenuItem moreMenu = menuBar.addItem("More");

        moreMenu.getSubMenu().addItem("About", event ->
                Notification.show("About clicked")
        );

        moreMenu.getSubMenu().addItem("Help", event ->
                Notification.show("Help clicked")
        );

        // SideNav Component
        SideNav sideNav = new SideNav();

        sideNav.addItem(
                new SideNavItem("Home", "/")
        );

        sideNav.addItem(
                new SideNavItem("Login", "/login")
        );

        // Image Component
        Image image = new Image(
                "https://vaadin.com/images/vaadin-logo.svg",
                "Vaadin Logo"
        );

        image.setWidth("200px");

        // MultiSelectComboBox Component
        MultiSelectComboBox<String> skills = new MultiSelectComboBox<>();

        skills.setLabel("Select Skills");
        skills.setItems(
                "Java",
                "Spring Boot",
                "Vaadin",
                "SQL",
                "JavaScript"
        );

        skills.setPlaceholder("Choose multiple skills");

        // FormLayout Component
        TextField formName = new TextField("Name");
        EmailField formEmail = new EmailField("Email");
        TextField formCity = new TextField("City");

        FormLayout formLayout = new FormLayout();

        formLayout.add(
                formName,
                formEmail,
                formCity
        );

        // HorizontalLayout Component
        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");

        HorizontalLayout horizontalLayout = new HorizontalLayout(
                button1,
                button2,
                button3
        );

        // Scroller Component
        VerticalLayout scrollContent = new VerticalLayout();

        scrollContent.add(
                new H1("Scrollable Content"),
                new TextArea("Description"),
                new TextArea("Comments"),
                new TextArea("Additional Information")
        );

        Scroller scroller = new Scroller(scrollContent);

        scroller.setWidth("350px");
        scroller.setHeight("200px");

        // FlexLayout Component
        Button flexButton1 = new Button("Flex 1");
        Button flexButton2 = new Button("Flex 2");
        Button flexButton3 = new Button("Flex 3");

        FlexLayout flexLayout = new FlexLayout(
                flexButton1,
                flexButton2,
                flexButton3
        );

        flexLayout.setFlexDirection(FlexLayout.FlexDirection.ROW);
        flexLayout.setWidth("400px");

        flexLayout.getStyle()
                .set("border", "1px solid gray")
                .set("padding", "10px");

        // Main Layout
        add(
                title,
                userIcon,
                email,
                password,
                role,
                rememberMe,
                gender,
                department,
                employeeGrid,
                upload,
                loginButton,
                datePicker,
                timePicker,
                confirmButton,
                tabs,
                menuBar,
                sideNav,
                image,
                skills,
                formLayout,
                horizontalLayout,
                scroller,
                flexLayout
        );

        setSpacing(true);
        setPadding(true);
    }
}