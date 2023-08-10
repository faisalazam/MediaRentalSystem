package com.mediarentalsystem;

import com.mediarentalsystem.menu.MenuHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.mediarentalsystem.menu.ParentMenu.MAIN;

public class MediaRentalSystem {
    public static final String MAIN_PACKAGE = "com.mediarentalsystem";

    private static final Logger LOGGER = LoggerFactory.getLogger(MediaRentalSystem.class);

    public static void main(String[] args) {
        LOGGER.info("**************MediaRental Application started**************");
        MenuHandler.getInstance().createMainMenu(MAIN);
    }
}