package com.mediarentalsystem.menu.item.main;

import com.mediarentalsystem.menu.item.AbstractMenuItem;
import com.mediarentalsystem.menu.runner.main.LoadMediaObjectsRunner;

import static com.mediarentalsystem.menu.ParentMenu.MAIN;

class LoadMediaObjectsMenuItem extends AbstractMenuItem {
    private LoadMediaObjectsMenuItem() {
        super(false,
                MAIN,
                "1",
                "Load Media objects...",
                new LoadMediaObjectsRunner()
        );
    }
}
