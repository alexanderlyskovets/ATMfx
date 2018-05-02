/*
 * Copyright (c) 2018.
 * Written by Alexander Lyskovets
 *
 */

package ru.lyskovets.controller;

import ru.lyskovets.MainApp;
import ru.lyskovets.model.Model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ConsoleLayoutController implements Controller{
    private Model model;
    private MainApp mainApp;
    private InfoLayoutController infoLayoutController;
    private AuthLayoutController authLayoutController;

    /**
     * Handler of numeric button pressing
     * @param e
     */
    @FXML
    private void handleNumericButton(ActionEvent e) {
        IButtonAction ba = IButtonAction.valueOf(((Button) e.getSource()).idProperty().get());
        int selectedDigit = ba.doAction();
        model.addDigit(selectedDigit);
        authLayoutController.setView();
    }

    /**
     * Handler of dot button pressing
     *
     */
    @FXML
    private void handleDotButton() {
        // TODO: дописать обработку ввода ТОЧКА
    }

    /**
     * Handler of cancel button pressing
     *
     */
    @FXML
    private void handleCancelButton() {
        model.deleteDigit();
        authLayoutController.setView();
    }

    /**
     * Handler of reset button pressing
     *
     */
    @FXML
    private void handleResetButton() {
        model.deleteAllDigits();
        authLayoutController.setView();
    }

    /**
     * Handler of enter button pressing
     *
     */
    @FXML
    private void handleEnterButton() {
        model.handleInput();
        authLayoutController.setView();
    }

    public void setView() {
    }

    /******************************************************
     * Getters & Setters
     *
     */

    public void setModel(Model model) {
        this.model = model;
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setInfoLayoutController(InfoLayoutController infoLayoutController) {
        this.infoLayoutController = infoLayoutController;
    }

    public void setAuthLayoutController(AuthLayoutController authLayoutController) {
        this.authLayoutController = authLayoutController;
    }
}
