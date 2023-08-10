package com.mediarentalsystem.menu.item.info;

import com.mediarentalsystem.menu.item.AbstractMenuItem;
import com.mediarentalsystem.menu.runner.info.ShowRentedMediaObjectsRunner;

import static com.mediarentalsystem.menu.ParentMenu.INFO;

class ShowRentedMediaObjectsMenuItem extends AbstractMenuItem {
    private ShowRentedMediaObjectsMenuItem() {
        super(false, INFO, "2", "Show Rented Media objects...", new ShowRentedMediaObjectsRunner());
    }
}
