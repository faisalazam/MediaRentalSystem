package com.mediarentalsystem.menu;

import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.mediarentalsystem.MediaRentalSystem.MAIN_PACKAGE;
import static com.mediarentalsystem.menu.ParentMenu.MAIN;

class MenuItemsInitializer {
    private static final Map<ParentMenu, Map<String, MenuItem>> ID_TO_ITEM_MAP = new HashMap<>();
    private static final Logger log = LoggerFactory.getLogger(MenuItemsInitializer.class.getName());

    static {
        // caching to avoid calculating again and again
        log.info("Initializing menu items...");

        final Reflections reflections = new Reflections(MAIN_PACKAGE);
        final Set<Class<? extends AbstractMenuItem>> menuItemsSubTypes = reflections.getSubTypesOf(AbstractMenuItem.class);
        for (Class<? extends AbstractMenuItem> menuItemClass : menuItemsSubTypes) {
            try {
                final Constructor<? extends AbstractMenuItem> classDeclaredConstructor = menuItemClass.getDeclaredConstructor();
                classDeclaredConstructor.setAccessible(true);
                final AbstractMenuItem menuItem = classDeclaredConstructor.newInstance();
                final ParentMenu parentMenu = menuItem.getParentMenu();
                ID_TO_ITEM_MAP.putIfAbsent(parentMenu, new HashMap<>());
                ID_TO_ITEM_MAP.get(parentMenu).put(menuItem.getItemId(), menuItem);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static MenuItem convert(ParentMenu parentMenu, String option) {
        final MenuItem invalidMenuItem = ID_TO_ITEM_MAP.get(MAIN).get("-1");
        return ID_TO_ITEM_MAP.get(parentMenu).getOrDefault(option, invalidMenuItem);
    }

    static Collection<MenuItem> getMenuItems(ParentMenu parentMenu) {
        return ID_TO_ITEM_MAP.get(parentMenu).values();
    }
}
