package com.mediarentalsystem.menuoptions.main;

import com.mediarentalsystem.menu.MenuHandler;
import com.mediarentalsystem.menuoptions.MenuOptionRunnable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.mediarentalsystem.menu.ParentMenu.RENT;

public class RentMediaObjectsMenuOption implements MenuOptionRunnable {
    private static final Logger log = LoggerFactory.getLogger(RentMediaObjectsMenuOption.class.getName());

    public void run() {
        MenuHandler.getInstance().createMainMenu(RENT);
    }
}
