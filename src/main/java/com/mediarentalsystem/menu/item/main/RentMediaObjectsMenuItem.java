package com.mediarentalsystem.menu.item.main;

import com.mediarentalsystem.menu.item.AbstractMenuItem;
import com.mediarentalsystem.menu.runner.main.RentMediaObjectsRunner;

import static com.mediarentalsystem.menu.ParentMenu.MAIN;

class RentMediaObjectsMenuItem extends AbstractMenuItem {
    private RentMediaObjectsMenuItem() {
        super(true, MAIN, "3", "Rent Media objects...", new RentMediaObjectsRunner());
    }
}
