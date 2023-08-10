package com.mediarentalsystem.menu.runner.main;

import com.mediarentalsystem.menu.runner.MenuOptionRunnable;

import static com.mediarentalsystem.menu.MenuHandler.getInstance;
import static com.mediarentalsystem.menu.ParentMenu.INFO;

public class SystemInfoRunner implements MenuOptionRunnable {
    @Override
    public void run() {
        getInstance().createMainMenu(INFO);
    }
}
