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
import javafx.scene.layout.AnchorPane;

public class InfoLayoutController implements Controller {
    private Model model;
    private MainApp mainApp;

    @FXML
    private Label infoLabel;

    /**
     * Initialization of controller class.
     * This method is called automatically after the fxml-file is loaded
     *
     */
    @FXML
    private void initialize() {
        // do nothing, under construction
    }

    /**
     * Handler of label mouse-click
     *
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
        // do nothing, under construction
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
}
