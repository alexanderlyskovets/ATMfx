package ru.lyskovets.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import ru.lyskovets.MainApp;
import ru.lyskovets.model.Model;

public class InfoLayoutController implements Controller {
    private Model model;
    private MainApp mainApp;

    @FXML
    private Label infoLabel;

    public InfoLayoutController() {
    }

    /**
     * Инициализация класса-контроллера. Этот метод вызывается автоматически
     * после того, как fxml-файл будет загружен.
     */
    @FXML
    private void initialize() {
        System.out.println("ok info layout controller");
    }

    /**
     * Handler of label mouse-click
     */
    @FXML
    private void handleInfoLabel() {
        System.out.println("before clicked INFO, westSideState = " + model.getWestSideState());
        AnchorPane layout = mainApp.getAuthLayout();
        mainApp.setWestSide(layout);
        model.setWestSideState(1);
        System.out.println("after clicked INFO, westSideState = " + model.getWestSideState());
    }

    public void setText(String text) {
        infoLabel.setText(text);
    }

    public void setView() {

    }

    /******************************************************
     * Getters & Setters
     */

    public void setModel(Model model) {
        this.model = model;
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
