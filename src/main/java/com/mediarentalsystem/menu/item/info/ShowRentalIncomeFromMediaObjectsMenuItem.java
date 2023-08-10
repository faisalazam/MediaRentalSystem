package com.mediarentalsystem.menu.item.info;

import com.mediarentalsystem.menu.item.AbstractMenuItem;
import com.mediarentalsystem.menu.runner.info.ShowRentalIncomeFromMediaObjectsRunner;

import static com.mediarentalsystem.menu.ParentMenu.INFO;

class ShowRentalIncomeFromMediaObjectsMenuItem extends AbstractMenuItem {
    private ShowRentalIncomeFromMediaObjectsMenuItem() {
        super(false,
                INFO,
                "3",
                "Show Rental Income From Media objects...",
                new ShowRentalIncomeFromMediaObjectsRunner()
        );
    }
}
