package com.mediarentalsystem.menuoptions;

import static com.mediarentalsystem.utils.Const.LINE_FEED;

public class InvalidMenuOption implements MenuOptionRunnable {
    public void run() {
        System.out.println(LINE_FEED + "Invalid selection. Please try again.");
    }
}
