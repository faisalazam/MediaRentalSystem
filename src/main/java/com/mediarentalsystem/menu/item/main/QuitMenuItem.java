package com.mediarentalsystem.menu.item.main;

import com.mediarentalsystem.menu.item.AbstractMenuItem;
import com.mediarentalsystem.menu.runner.main.QuitRunner;

import static com.mediarentalsystem.menu.ParentMenu.MAIN;

public class QuitMenuItem extends AbstractMenuItem {
    private QuitMenuItem() {
        super(false, MAIN, "9", "Quit", new QuitRunner());
    }
}
