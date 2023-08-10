package com.mediarentalsystem.menuoptions;

import com.mediarentalsystem.menu.MenuHandler;

public class GoBackToParentMenuOption implements MenuOptionRunnable {
    public void run() {
        MenuHandler.getInstance().goBackToParentMenu();
    }
}
