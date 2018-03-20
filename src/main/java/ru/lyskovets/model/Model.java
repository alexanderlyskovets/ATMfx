package ru.lyskovets.model;

import ru.lyskovets.MainApp;

public class Model {
    private final int ACCOUNT_LENGTH = 4;
    private final int PIN_LENGTH = 4;
    public final int WEST_SIDE_STATUS_INITIAL = 0;
    public final int WEST_SIDE_STATUS_INPUT_ACCOUNT = 1;
    public final int WEST_SIDE_STATUS_INPUT_PIN = 2;
    private MainApp mainApp;
    private int westSideState; // 0 - initial screen; 1 - input account number; 2 - input PIN
    private String enteredString = "";
    private String account = "";
    private String pin = "";

    public Model(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void addDigit(int selectedDigit) {
        if (westSideState == WEST_SIDE_STATUS_INITIAL) {
            return;
        }
        int enteredStringLength = enteredString.length();
        if (westSideState == WEST_SIDE_STATUS_INPUT_ACCOUNT && enteredStringLength == ACCOUNT_LENGTH) {
            return;
        }
        if (westSideState == WEST_SIDE_STATUS_INPUT_PIN && enteredStringLength == PIN_LENGTH) {
            return;
        }
        enteredString = enteredString + selectedDigit;
    }

    public void deleteDigit() {
        int enteredStringLength = enteredString.length();
        if (enteredStringLength == 0) {
            return;
        }
        if (westSideState == WEST_SIDE_STATUS_INITIAL) {
            return;
        }
        enteredString = enteredString.substring(0, enteredStringLength - 1);
    }

    public void deleteAllDigits() {
        if (westSideState == WEST_SIDE_STATUS_INITIAL) {
            return;
        }
        enteredString = "";
    }

    /******************************************************
     * Getters & Setters
     */

    public int getWestSideState() {
        return westSideState;
    }

    public void setWestSideState(int westSideState) {
        this.westSideState = westSideState;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getEnteredString() {
        return enteredString;
    }

    public void setEnteredString(String enteredString) {
        this.enteredString = enteredString;
    }

}
