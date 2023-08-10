package com.mediarentalsystem.menu.runner;

import com.mediarentalsystem.menu.MenuHandler;

public class GoBackToParentRunner implements MenuOptionRunnable {
    public void run() {
        MenuHandler.getInstance().goBackToParentMenu();
    }
}
