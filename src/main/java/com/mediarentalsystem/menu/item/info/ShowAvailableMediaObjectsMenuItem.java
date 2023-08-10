package com.mediarentalsystem.menu.item.info;

import com.mediarentalsystem.menu.item.AbstractMenuItem;
import com.mediarentalsystem.menu.runner.info.ShowAvailableMediaObjectsRunner;

import static com.mediarentalsystem.menu.ParentMenu.INFO;

class ShowAvailableMediaObjectsMenuItem extends AbstractMenuItem {
    private ShowAvailableMediaObjectsMenuItem() {
        super(false, INFO, "1", "Show Available Media objects...", new ShowAvailableMediaObjectsRunner());
    }
}
