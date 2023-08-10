package com.mediarentalsystem.menu.item.find;

import com.mediarentalsystem.menu.item.AbstractMenuItem;
import com.mediarentalsystem.menu.runner.find.FindMediaObjectsByTitleRunner;

import static com.mediarentalsystem.menu.ParentMenu.FIND;

class FindMediaObjectsByYearRangeMenuItem extends AbstractMenuItem {
    private FindMediaObjectsByYearRangeMenuItem() {
        super(false, FIND, "4", "Find Media objects by year range...", new FindMediaObjectsByTitleRunner());
    }
}
