package com.mediarentalsystem.menu.item.rent;

import com.mediarentalsystem.menu.item.AbstractMenuItem;
import com.mediarentalsystem.menu.runner.GoBackToParentRunner;

import static com.mediarentalsystem.menu.ParentMenu.RENT;

class GoBackToParentMenuFromRentMenuItem extends AbstractMenuItem {
    private GoBackToParentMenuFromRentMenuItem() {
        super(false,
                RENT,
                "9",
                "Go back to parent menu...",
                new GoBackToParentRunner()
        );
    }
}
