package com.mediarentalsystem.menu.item;

import com.mediarentalsystem.menu.ParentMenu;
import com.mediarentalsystem.menu.runner.MenuOptionRunnable;

public interface MenuItem {
    boolean hasSubMenu();

    String getItemId();

    String getItemDisplayText();

    ParentMenu getParentMenu();

    MenuOptionRunnable getRunnable();
}