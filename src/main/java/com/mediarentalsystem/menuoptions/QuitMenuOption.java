package com.mediarentalsystem.menuoptions;

import static com.mediarentalsystem.utils.Const.LINE_FEED;

public class QuitMenuOption implements com.mediarentalsystem.menuoptions.MenuOptionRunnable {
    public void run() {
        System.out.println(LINE_FEED + "Thank you for using the program. Goodbye!");
        System.out.println("Exiting...");
    }
}
