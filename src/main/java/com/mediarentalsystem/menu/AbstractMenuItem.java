package com.mediarentalsystem.menu;

import com.mediarentalsystem.menuoptions.MenuOptionRunnable;

abstract class AbstractMenuItem implements MenuItem {
    private final ParentMenu parentMenu;
    private final String itemId;
    private final boolean hasSubMenu;
    private final String itemDisplayText;
    private final MenuOptionRunnable runnable;

    AbstractMenuItem(boolean hasSubMenu,
                     ParentMenu parentMenu,
                     String itemId,
                     String itemDisplayText,
                     MenuOptionRunnable runnable) {
        this.hasSubMenu = hasSubMenu;
        this.itemId = itemId;
        this.runnable = runnable;
        this.parentMenu = parentMenu;
        this.itemDisplayText = itemDisplayText;
    }

    @Override
    public boolean hasSubMenu() {
        return hasSubMenu;
    }

    @Override
    public String getItemId() {
        return itemId;
    }

    @Override
    public String getItemDisplayText() {
        return itemDisplayText;
    }

    @Override
    public ParentMenu getParentMenu() {
        return parentMenu;
    }

    @Override
    public MenuOptionRunnable getRunnable() {
        return runnable;
    }
}