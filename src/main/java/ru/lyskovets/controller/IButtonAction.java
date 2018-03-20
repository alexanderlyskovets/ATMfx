package ru.lyskovets.controller;

public enum IButtonAction {

    button0 {
        @Override
        public int doAction() {
            return 0;
        }
    },
    button1 {
        @Override
        public int doAction() {
            return 1;
        }
    },
    button2 {
        @Override
        public int doAction() {
            return 2;
        }
    },
    button3 {
        @Override
        public int doAction() {
            return 3;
        }
    },
    button4 {
        @Override
        public int doAction() {
            return 4;
        }
    },
    button5 {
        @Override
        public int doAction() {
            return 5;
        }
    },
    button6 {
        @Override
        public int doAction() {
            return 6;
        }
    },
    button7 {
        @Override
        public int doAction() {
            return 7;
        }
    },
    button8 {
        @Override
        public int doAction() {
            return 8;
        }
    },
    button9 {
        @Override
        public int doAction() {
            return 9;
        }
    };
    public abstract int doAction();
}
