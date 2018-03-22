package ru.lyskovets.model;

import ru.lyskovets.MainApp;

public class Model {
    private final int ACCOUNT_LENGTH = 4;
    private final int PIN_LENGTH = 4;
    public static final int WEST_SIDE_STATUS_INITIAL = 0;
    public static final int WEST_SIDE_STATUS_INPUT_ACCOUNT = 1;
    public static final int WEST_SIDE_STATUS_INPUT_PIN = 2;
    public static final int WEST_SIDE_STATUS_OPERATIONAL = 3;
    private MainApp mainApp;
    private int westSideState; // 0 - initial screen; 1 - input account number; 2 - input PIN;  3 - operational
    private String enteredString = "";
    private String account = "";
    private String pin = "";

    public Model(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void addDigit(int selectedDigit) {
        if (isInitial()) {
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
        if (isInitial()) {
            return;
        }
        int enteredStringLength = enteredString.length();
        if (enteredStringLength == 0) {
            return;
        }
        enteredString = enteredString.substring(0, enteredStringLength - 1);
    }

    public void deleteAllDigits() {
        if (isInitial()) {
            return;
        }
        enteredString = "";
    }

    public void handleInput() {
        if (isInitial()) {
            return;
        }
        int enteredStringLength = enteredString.length();
        if (westSideState == WEST_SIDE_STATUS_INPUT_ACCOUNT && enteredStringLength == ACCOUNT_LENGTH) {
            account = enteredString;
            enteredString = "";
            setWestSideState(WEST_SIDE_STATUS_INPUT_PIN);
            return;
        }
        if (westSideState == WEST_SIDE_STATUS_INPUT_PIN && enteredStringLength == PIN_LENGTH) {
            pin = enteredString;
            enteredString = "";
            setWestSideState(WEST_SIDE_STATUS_OPERATIONAL);
        }
        // todo send account & pin to DAO
    }

    private boolean isInitial() {
        if (westSideState == WEST_SIDE_STATUS_INITIAL) {
            return true;
        }
        return false;
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
