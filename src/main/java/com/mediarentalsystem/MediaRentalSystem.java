package com.mediarentalsystem;

import com.mediarentalsystem.menu.MenuHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MediaRentalSystem {
    public static final String MAIN_PACKAGE = "com.mediarentalsystem";

    private static final Logger log = LoggerFactory.getLogger(MediaRentalSystem.class.getName());

    public static void main(String[] args) {
        log.info("**************MediaRental Application started**************");
        new MenuHandler().createMainMenu();
    }
}