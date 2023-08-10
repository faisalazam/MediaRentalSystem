package com.mediarentalsystem.menu.runner.main;

import com.mediarentalsystem.menu.MenuHandler;
import com.mediarentalsystem.menu.runner.MenuOptionRunnable;

import static com.mediarentalsystem.menu.ParentMenu.INFO;

public class SystemInfoRunner implements MenuOptionRunnable {
    public void run() {
        MenuHandler.getInstance().createMainMenu(INFO);
    }
}