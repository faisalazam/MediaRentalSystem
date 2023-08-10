package com.mediarentalsystem.menu.runner.main;

import com.mediarentalsystem.menu.runner.MenuOptionRunnable;

import static com.mediarentalsystem.menu.MenuHandler.getInstance;
import static com.mediarentalsystem.menu.ParentMenu.FIND;

public class FindMediaObjectsRunner implements MenuOptionRunnable {
    @Override
    public void run() {
        getInstance().createMainMenu(FIND);
    }
}
