package com.mediarentalsystem.menu;

import com.mediarentalsystem.menuoptions.MenuOptionRunnable;

abstract class AbstractMenuItem implements MenuItem {
    private final String itemId;
    private final String itemDisplayText;
    private final MenuOptionRunnable runnable;

    AbstractMenuItem(String itemId, String itemDisplayText, MenuOptionRunnable runnable) {
        this.itemId = itemId;
        this.runnable = runnable;
        this.itemDisplayText = itemDisplayText;
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
    public MenuOptionRunnable getRunnable() {
        return runnable;
    }
}