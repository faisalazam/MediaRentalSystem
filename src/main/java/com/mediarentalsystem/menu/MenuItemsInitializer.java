package com.mediarentalsystem.menu;

import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import static com.mediarentalsystem.MediaRentalSystem.MAIN_PACKAGE;
import static com.mediarentalsystem.menu.MenuItem.ID_TO_ITEM_MAP;

class MenuItemsInitializer {
    static {
        // caching to avoid calculating again and again
        final Reflections reflections = new Reflections(MAIN_PACKAGE);
        final Set<Class<? extends AbstractMenuItem>> menuItemsSubTypes = reflections.getSubTypesOf(AbstractMenuItem.class);
        for (Class<? extends AbstractMenuItem> menuItemClass : menuItemsSubTypes) {
            try {
                final Constructor<? extends AbstractMenuItem> classDeclaredConstructor = menuItemClass.getDeclaredConstructor();
                classDeclaredConstructor.setAccessible(true);
                final AbstractMenuItem menuItem = classDeclaredConstructor.newInstance();
                ID_TO_ITEM_MAP.put(menuItem.getItemId(), menuItem);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
