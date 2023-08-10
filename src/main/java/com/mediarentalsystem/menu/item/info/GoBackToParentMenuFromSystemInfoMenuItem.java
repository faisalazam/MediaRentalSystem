package com.mediarentalsystem.menu.item.info;

import com.mediarentalsystem.menu.item.AbstractMenuItem;
import com.mediarentalsystem.menu.runner.GoBackToParentRunner;

import static com.mediarentalsystem.menu.ParentMenu.INFO;

class GoBackToParentMenuFromSystemInfoMenuItem extends AbstractMenuItem {
    private GoBackToParentMenuFromSystemInfoMenuItem() {
        super(false,
                INFO,
                "9",
                "Go back to parent menu...",
                new GoBackToParentRunner()
        );
    }
}
