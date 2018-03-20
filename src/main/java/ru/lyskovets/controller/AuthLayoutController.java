package ru.lyskovets.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import ru.lyskovets.MainApp;
import ru.lyskovets.model.Model;

public class AuthLayoutController implements Controller {
    private Model model;
    private MainApp mainApp;
    private String accountView;
    private String pinView;

    @FXML
    private Label northLabel;

    @FXML
    private Label southLabel;

    /**
     * Инициализация класса-контроллера. Этот метод вызывается автоматически
     * после того, как fxml-файл будет загружен.
     */
    @FXML
    private void initialize() {
        northLabel.setText(MainApp.INFO_TEXT_ACCOUNT_INPUT);
        System.out.println("ok auth layout controller");
    }

    /**
     * Handler of label mouse-click
     */
    @FXML
    private void handleAllLabels() {
        System.out.println("before clicked AUTH, westSideState = " + model.getWestSideState());
        AnchorPane layout = mainApp.getInfoLayout();
        mainApp.setWestSide(layout);
        model.setWestSideState(0);
        System.out.println("after clicked AUTH, westSideState = " + model.getWestSideState());
    }

    private String hideText(String text) {
        return text.replaceAll("[0-9]", "*");
    }

    public void setView() {
        southLabel.setText(hideText(model.getEnteredString()));
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

    public Label getNorthLabel() {
        return northLabel;
    }

    public Label getSouthLabel() {
        return southLabel;
    }

    public String getAccountView() {
        return accountView;
    }

    public void setAccountView(String accountView) {
        this.accountView = accountView;
    }

    public String getPinView() {
        return pinView;
    }

    public void setPinView(String pinView) {
        this.pinView = pinView;
    }
}
