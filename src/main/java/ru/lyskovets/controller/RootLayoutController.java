/*
 * Copyright (c) 2018.
 * Written by Alexander Lyskovets
 *
 */

package ru.lyskovets.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;

import ru.lyskovets.MainApp;
import ru.lyskovets.model.Model;

import java.io.File;

public class RootLayoutController implements Controller {
    private Model model;
    private MainApp mainApp;

    @FXML
    private void initialize() {
    }










    /**
     * Создаёт пустую адресную книгу.
     */
    @FXML
    private void handleNew() {
//        mainApp.getPersonData().clear();
//        mainApp.setPersonFilePath(null);
    }

    /**
     * Открывает FileChooser, чтобы пользователь имел возможность
     * выбрать адресную книгу для загрузки.
     */
    @FXML
    private void handleOpen() {
//        FileChooser fileChooser = new FileChooser();
//
//        // Задаём фильтр расширений
//        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
//                "XML files (*.xml)", "*.xml");
//        fileChooser.getExtensionFilters().add(extFilter);
//
//        // Показываем диалог загрузки файла
//        File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());
//
//        if (file != null) {
//            mainApp.loadPersonDataFromFile(file);
//        }
    }

    /**
     * Сохраняет файл в файл адресатов, который в настоящее время открыт.
     * Если файл не открыт, то отображается диалог "save as".
     */
    @FXML
    private void handleSave() {
//        File personFile = mainApp.getPersonFilePath();
//        if (personFile != null) {
//            mainApp.savePersonDataToFile(personFile);
//        } else {
//            handleSaveAs();
//        }
    }

    /**
     * Открывает FileChooser, чтобы пользователь имел возможность
     * выбрать файл, куда будут сохранены данные
     */
    @FXML
    private void handleSaveAs() {
//        FileChooser fileChooser = new FileChooser();
//
//        // Задаём фильтр расширений
//        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
//                "XML files (*.xml)", "*.xml");
//        fileChooser.getExtensionFilters().add(extFilter);
//
//        // Показываем диалог сохранения файла
//        File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());
//
//        if (file != null) {
//            // Make sure it has the correct extension
//            if (!file.getPath().endsWith(".xml")) {
//                file = new File(file.getPath() + ".xml");
//            }
//            mainApp.savePersonDataToFile(file);
//        }
    }

    /**
     * Открывает диалоговое окно about.
     */
    @FXML
    private void handleAbout() {
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("AddressApp");
//        alert.setHeaderText("About");
//        alert.setContentText("Author: Marco Jakob\nWebsite: http://code.makery.ch");
//
//        alert.showAndWait();
    }

    /**
     * Закрывает приложение.
     */
    @FXML
    private void handleExit() {
        System.exit(0);
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
