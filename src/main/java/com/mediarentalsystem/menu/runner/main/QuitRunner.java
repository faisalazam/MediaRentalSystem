package com.mediarentalsystem.menu.runner.main;

import com.mediarentalsystem.menu.runner.MenuOptionRunnable;

import static com.mediarentalsystem.utils.Const.LINE_FEED;

public class QuitRunner implements MenuOptionRunnable {
    @Override
    public void run() {
        System.out.println(LINE_FEED + "Thank you for using the program. Goodbye!");
        System.out.println("Exiting...");
    }
}
