package ru.lyskovets;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import ru.lyskovets.controller.AuthLayoutController;
import ru.lyskovets.controller.ConsoleLayoutController;
import ru.lyskovets.controller.Controller;
import ru.lyskovets.controller.InfoLayoutController;
import ru.lyskovets.controller.RootLayoutController;
import ru.lyskovets.model.Model;

public class MainApp extends Application {
    public static final String INFO_TEXT_INITIAL = "Добро пожаловать!\n\nДля начала работы коснитесь экрана";
    public static final String INFO_TEXT_ACCOUNT_INPUT = "ВВЕДИТЕ № СЧЕТА";
    public static final String INFO_TEXT_PIN_INPUT = "ВВЕДИТЕ ПИН-КОД";
    private final String MAIN_TITLE = "ATM";
    private final String MAIN_ICON = "/images/application_icon.png";
    private final String ROOT_LAYOUT = "/rootLayout.fxml";
    private final String CONSOLE_LAYOUT = "/consoleLayout.fxml";
    private final String INFO_LAYOUT = "/infoLayout.fxml";
    private final String AUTH_LAYOUT = "/authLayout.fxml";
    private Model model;
    private Stage primaryStage;
    private BorderPane rootLayout;
    private AnchorPane consoleLayout;
    private AnchorPane infoLayout;
    private AnchorPane authLayout;
    private InfoLayoutController infoController;
    private AuthLayoutController authController;
    private ConsoleLayoutController consoleLayoutController;

    private Pane westSide; // pointer to the current Pane on the west side

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
        model.setWestSideState(model.WEST_SIDE_STATUS_INITIAL); // set initial screen

        // database connect
        

        // set info text
        infoController.setText(INFO_TEXT_INITIAL);

        String pointer = "stop";
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
     * Root Layout initialization
     * always visible
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
        westSide = layout;
    }

    public AnchorPane getInfoLayout() {
        return infoLayout;
    }

    public AnchorPane getAuthLayout() {
        return authLayout;
    }

    public Pane getWestSide() {
        return westSide;
    }
}
