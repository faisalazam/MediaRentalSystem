package com.mediarentalsystem.menu.item.rent;

import com.mediarentalsystem.menu.item.AbstractMenuItem;
import com.mediarentalsystem.menu.runner.rent.RentMediaObjectsByIdRunner;

import static com.mediarentalsystem.menu.ParentMenu.RENT;

class RentMediaObjectsByIdMenuItem extends AbstractMenuItem {
    private RentMediaObjectsByIdMenuItem() {
        super(false, RENT, "1", "Rent Media objects by id...", new RentMediaObjectsByIdRunner());
    }
}
