package com.mediarentalsystem.menu.runner.main;

import com.mediarentalsystem.menu.MenuHandler;
import com.mediarentalsystem.menu.runner.MenuOptionRunnable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.mediarentalsystem.menu.ParentMenu.RENT;

public class RentMediaObjectsRunner implements MenuOptionRunnable {
    private static final Logger log = LoggerFactory.getLogger(RentMediaObjectsRunner.class.getName());

    public void run() {
        MenuHandler.getInstance().createMainMenu(RENT);
    }
}
