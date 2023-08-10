package com.mediarentalsystem.menu.runner.main;

import com.mediarentalsystem.menu.runner.MenuOptionRunnable;

import static com.mediarentalsystem.utils.Const.LINE_FEED;

public class InvalidRunner implements MenuOptionRunnable {
    public void run() {
        System.out.println(LINE_FEED + "Invalid selection. Please try again." + LINE_FEED);
    }
}
