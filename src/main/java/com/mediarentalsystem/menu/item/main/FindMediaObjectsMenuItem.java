package com.mediarentalsystem.menu.item.main;

import com.mediarentalsystem.menu.item.AbstractMenuItem;
import com.mediarentalsystem.menu.runner.main.FindMediaObjectsRunner;

import static com.mediarentalsystem.menu.ParentMenu.MAIN;

class FindMediaObjectsMenuItem extends AbstractMenuItem {
    private FindMediaObjectsMenuItem() {
        super(true, MAIN, "2", "Find Media objects...", new FindMediaObjectsRunner());
    }
}
