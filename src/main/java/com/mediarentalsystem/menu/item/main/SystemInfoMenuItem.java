package com.mediarentalsystem.menu.item.main;

import com.mediarentalsystem.menu.item.AbstractMenuItem;
import com.mediarentalsystem.menu.runner.main.SystemInfoRunner;

import static com.mediarentalsystem.menu.ParentMenu.MAIN;

class SystemInfoMenuItem extends AbstractMenuItem {
    private SystemInfoMenuItem() {
        super(true,
                MAIN,
                "4",
                "Show System Info...",
                new SystemInfoRunner()
        );
    }
}
