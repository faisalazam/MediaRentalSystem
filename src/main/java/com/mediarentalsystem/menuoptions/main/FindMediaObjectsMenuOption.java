package com.mediarentalsystem.menuoptions.main;

import com.mediarentalsystem.menu.MenuHandler;
import com.mediarentalsystem.menuoptions.MenuOptionRunnable;

import static com.mediarentalsystem.menu.ParentMenu.FIND;

public class FindMediaObjectsMenuOption implements MenuOptionRunnable {
    public void run() {
        MenuHandler.getInstance().createMainMenu(FIND);
    }
}
