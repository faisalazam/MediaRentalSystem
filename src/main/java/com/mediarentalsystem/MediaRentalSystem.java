package com.mediarentalsystem;

import com.mediarentalsystem.menu.MenuHandler;

public class MediaRentalSystem {
    public static final String MAIN_PACKAGE = "com.mediarentalsystem";

    public static void main(String[] args) {
        new MenuHandler().createMainMenu();
    }
}