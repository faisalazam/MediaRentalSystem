package com.mediarentalsystem.menu.item.rent;

import com.mediarentalsystem.menu.item.AbstractMenuItem;
import com.mediarentalsystem.menu.runner.rent.ReturnRentedMediaObjectsRunner;

import static com.mediarentalsystem.menu.ParentMenu.RENT;

class ReturnMediaObjectsMenuItem extends AbstractMenuItem {
    private ReturnMediaObjectsMenuItem() {
        super(false,
                RENT,
                "2",
                "Return Rented Media objects...",
                new ReturnRentedMediaObjectsRunner()
        );
    }
}
