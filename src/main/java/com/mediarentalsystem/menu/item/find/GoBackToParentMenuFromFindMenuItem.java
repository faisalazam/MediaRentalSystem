package com.mediarentalsystem.menu.item.find;

import com.mediarentalsystem.menu.item.AbstractMenuItem;
import com.mediarentalsystem.menu.runner.GoBackToParentRunner;

import static com.mediarentalsystem.menu.ParentMenu.FIND;

class GoBackToParentMenuFromFindMenuItem extends AbstractMenuItem {
    private GoBackToParentMenuFromFindMenuItem() {
        super(false, FIND, "9", "Go back to parent menu...", new GoBackToParentRunner());
    }
}
