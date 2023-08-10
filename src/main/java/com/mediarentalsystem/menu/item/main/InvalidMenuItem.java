package com.mediarentalsystem.menu.item.main;

import com.mediarentalsystem.menu.item.AbstractMenuItem;
import com.mediarentalsystem.menu.runner.main.InvalidRunner;

import static com.mediarentalsystem.menu.ParentMenu.MAIN;

public class InvalidMenuItem extends AbstractMenuItem {
    private InvalidMenuItem() {
        super(false,
                MAIN,
                "-1",
                "",
                new InvalidRunner())
        ;
    }
}
