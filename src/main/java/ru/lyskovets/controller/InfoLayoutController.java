package ru.lyskovets.controller;

import ru.lyskovets.MainApp;
import ru.lyskovets.model.Model;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class InfoLayoutController implements Controller {
    private Model model;
    private MainApp mainApp;

    @FXML
    private Label infoLabel;

    /**
     * Инициализация класса-контроллера. Этот метод вызывается автоматически
     * после того, как fxml-файл будет загружен.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Handler of label mouse-click
     */
    @FXML
    private void handleInfoLabel() {
        AnchorPane layout = mainApp.getAuthLayout();
        mainApp.setWestSide(layout);
        model.setWestSideState(1);
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
