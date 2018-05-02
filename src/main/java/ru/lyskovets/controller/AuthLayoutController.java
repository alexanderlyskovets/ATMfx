/*
 * Copyright (c) 2018.
 * Written by Alexander Lyskovets
 *
 */

package ru.lyskovets.controller;

import ru.lyskovets.MainApp;
import ru.lyskovets.model.Model;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

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
        northLabel.setText(MainApp.INFO_TEXT_INPUT_ACCOUNT);
    }

    private String hideText(String text) {
        return text.replaceAll("[0-9]", "*");
    }

    public void setView() {
        int westSideState = model.getWestSideState();
        if (westSideState == Model.WEST_SIDE_STATUS_INPUT_ACCOUNT){
            northLabel.setText(MainApp.INFO_TEXT_INPUT_ACCOUNT);
        } else if (westSideState == Model.WEST_SIDE_STATUS_INPUT_PIN) {
            northLabel.setText(MainApp.INFO_TEXT_INPUT_PIN);
        }
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
