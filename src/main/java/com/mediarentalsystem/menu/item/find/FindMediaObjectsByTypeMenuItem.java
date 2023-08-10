package com.mediarentalsystem.menu.item.find;

import com.mediarentalsystem.menu.item.AbstractMenuItem;
import com.mediarentalsystem.menu.runner.find.FindMediaObjectsByTitleRunner;

import static com.mediarentalsystem.menu.ParentMenu.FIND;

class FindMediaObjectsByTypeMenuItem extends AbstractMenuItem {
    private FindMediaObjectsByTypeMenuItem() {
        super(false, FIND, "2", "Find Media objects by type...", new FindMediaObjectsByTitleRunner());
    }
}
