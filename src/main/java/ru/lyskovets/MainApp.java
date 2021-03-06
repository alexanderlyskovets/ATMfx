/*
 * Copyright (c) 2018.
 * Written by Alexander Lyskovets
 *
 */

package ru.lyskovets;

import ru.lyskovets.controller.AuthLayoutController;
import ru.lyskovets.controller.ConsoleLayoutController;
import ru.lyskovets.controller.Controller;
import ru.lyskovets.controller.InfoLayoutController;
import ru.lyskovets.controller.RootLayoutController;
import ru.lyskovets.model.Model;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {
    private static final String INFO_TEXT_INITIAL = "WELCOME!\n\nto get started, tap the screen";
    public static final String INFO_TEXT_INPUT_ACCOUNT = "ENTER YOUR ACCOUNT NUMBER";
    public static final String INFO_TEXT_INPUT_PIN = "ENTER PIN";
    private static final String MAIN_TITLE = "ATM";
    private static final String MAIN_ICON = "/images/application_icon.png";
    private static final String ROOT_LAYOUT = "/rootLayout.fxml";
    private static final String CONSOLE_LAYOUT = "/consoleLayout.fxml";
    private static final String INFO_LAYOUT = "/infoLayout.fxml";
    private static final String AUTH_LAYOUT = "/authLayout.fxml";
    private Model model;
    private Stage primaryStage;
    private BorderPane rootLayout;
    private AnchorPane consoleLayout;
    private AnchorPane infoLayout;
    private AnchorPane authLayout;
    private InfoLayoutController infoController;
    private AuthLayoutController authController;
    private ConsoleLayoutController consoleLayoutController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        model = new Model(this);
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle(MAIN_TITLE);
        this.primaryStage.getIcons().add(new Image(MAIN_ICON));

        // initialize layouts
        initLayouts();

        // bind controllers
        bindControllers();

        // set scene
        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();

        // set consoleLayout on the east side
        rootLayout.setRight(consoleLayout);

        // set infoLayout on the west side
        setWestSide(infoLayout);
        model.setWestSideState(Model.WEST_SIDE_STATUS_INITIAL); // set initial screen

        // set info text
        infoController.setText(INFO_TEXT_INITIAL);
    }

    private void bindControllers() {
        consoleLayoutController.setInfoLayoutController(infoController);
        consoleLayoutController.setAuthLayoutController(authController);
    }

    /**
     * Layouts initialization
     */
    private void initLayouts() {
        initRootLayout();
        consoleLayout = initLayout(CONSOLE_LAYOUT);
        infoLayout = initLayout(INFO_LAYOUT);
        authLayout = initLayout(AUTH_LAYOUT);
    }

    private AnchorPane initLayout(String location) {
        AnchorPane layout = new AnchorPane();
        try {
            // load FXML
            FXMLLoader loader = loadFxml(location);
            layout = loader.load();
            // set controller
            Controller controller = loader.getController();
            initController(controller, location);
            controller.setMainApp(this);
            controller.setModel(model);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return layout;
    }

    private void initController(Controller controller, String location) {
        if (location.equals(CONSOLE_LAYOUT)) {
            consoleLayoutController = (ConsoleLayoutController) controller;
            consoleLayoutController.setMainApp(this);
            consoleLayoutController.setModel(model);
        }
        if (location.equals(INFO_LAYOUT)) {
            infoController = (InfoLayoutController) controller;
            infoController.setMainApp(this);
            infoController.setModel(model);
        }
        if (location.equals(AUTH_LAYOUT)) {
            authController = (AuthLayoutController) controller;
            authController.setMainApp(this);
            authController.setModel(model);
        }
    }

    /**
     * Root Layout initialization. Layout is always visible
     *
     */
    private void initRootLayout() {
        try {
            // load FXML
            FXMLLoader loader = loadFxml(ROOT_LAYOUT);
            rootLayout = loader.load();
            // set controller
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);
            controller.setModel(model);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private FXMLLoader loadFxml(String layout) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource(layout));
        return loader;
    }

    public void setWestSide(AnchorPane layout) {
        rootLayout.setLeft(layout);
    }

    public AnchorPane getInfoLayout() {
        return infoLayout;
    }

    public AnchorPane getAuthLayout() {
        return authLayout;
    }

}
