package com.mediarentalsystem.menu.item.find;

import com.mediarentalsystem.menu.item.AbstractMenuItem;
import com.mediarentalsystem.menu.runner.find.FindMediaObjectsByTitleRunner;

import static com.mediarentalsystem.menu.ParentMenu.FIND;

class FindMediaObjectsByTitleMenuItem extends AbstractMenuItem {
    private FindMediaObjectsByTitleMenuItem() {
        super(false, FIND, "1", "Find Media objects by title...", new FindMediaObjectsByTitleRunner());
    }
}
