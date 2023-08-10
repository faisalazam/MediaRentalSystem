package com.mediarentalsystem.menuoptions.main;

import com.mediarentalsystem.menuoptions.MenuOptionRunnable;

import static com.mediarentalsystem.utils.Const.LINE_FEED;

public class QuitMenuOption implements MenuOptionRunnable {
    public void run() {
        System.out.println(LINE_FEED + "Thank you for using the program. Goodbye!");
        System.out.println("Exiting...");
    }
}
