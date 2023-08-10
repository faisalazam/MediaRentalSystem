package com.mediarentalsystem.menu.item.find;

import com.mediarentalsystem.menu.item.AbstractMenuItem;
import com.mediarentalsystem.menu.runner.find.FindMediaObjectsByYearRunner;

import static com.mediarentalsystem.menu.ParentMenu.FIND;

class FindMediaObjectsByYearMenuItem extends AbstractMenuItem {
    private FindMediaObjectsByYearMenuItem() {
        super(false,
                FIND,
                "3",
                "Find Media objects by year...",
                new FindMediaObjectsByYearRunner()
        );
    }
}
