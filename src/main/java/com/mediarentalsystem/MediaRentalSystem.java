package com.mediarentalsystem;

import org.slf4j.Logger;

import static com.mediarentalsystem.menu.MenuHandler.getInstance;
import static com.mediarentalsystem.menu.ParentMenu.MAIN;
import static org.slf4j.LoggerFactory.getLogger;

public class MediaRentalSystem {
    public static final String MAIN_PACKAGE = "com.mediarentalsystem";

    private static final Logger LOGGER = getLogger(MediaRentalSystem.class);

    public static void main(String[] args) {
        LOGGER.info("**************MediaRental Application started**************");
        getInstance().createMainMenu(MAIN);
    }
}