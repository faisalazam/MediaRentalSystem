package com.mediarentalsystem.menu.runner;

import static com.mediarentalsystem.menu.MenuHandler.getInstance;

public class GoBackToParentRunner implements MenuOptionRunnable {
    @Override
    public void run() {
        getInstance().goBackToParentMenu();
    }
}
