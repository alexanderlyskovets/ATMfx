/*
 * Copyright (c) 2018.
 * Written by Alexander Lyskovets
 *
 */

package ru.lyskovets.controller;

import ru.lyskovets.MainApp;
import ru.lyskovets.model.Model;

public interface Controller {
    void setMainApp(MainApp mainApp);
    void setModel(Model model);
    void setView();
}
