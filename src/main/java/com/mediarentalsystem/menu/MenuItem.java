package com.mediarentalsystem.menu;

import com.mediarentalsystem.menuoptions.FindMediaObjectsMenuOption;
import com.mediarentalsystem.menuoptions.InvalidMenuOption;
import com.mediarentalsystem.menuoptions.LoadMediaObjectsMenuOption;
import com.mediarentalsystem.menuoptions.MenuOptionRunnable;
import com.mediarentalsystem.menuoptions.QuitMenuOption;
import com.mediarentalsystem.menuoptions.RentMediaObjectsMenuOption;
import com.mediarentalsystem.menuoptions.ReturnRentedMediaObjectsMenuOption;
import com.mediarentalsystem.menuoptions.ShowAvailableMediaObjectsMenuOption;
import com.mediarentalsystem.menuoptions.ShowRentalIncomeFromMediaObjectsMenuOption;
import com.mediarentalsystem.menuoptions.ShowRentedMediaObjectsMenuOption;

import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.stream;

enum MenuItem {
    LOAD_MEDIA_OBJECTS("1", "Load Media objects...", new LoadMediaObjectsMenuOption()),
    FIND_MEDIA_OBJECTS("2", "Find Media objects...", new FindMediaObjectsMenuOption()),
    RENT_MEDIA_OBJECTS("3", "Rent Media objects...", new RentMediaObjectsMenuOption()),
    RETURN_RENTED_MEDIA_OBJECTS("4", "Return Rented Media objects...", new ReturnRentedMediaObjectsMenuOption()),
    SHOW_AVAILABLE_MEDIA_OBJECTS("6", "Show Available Media objects...", new ShowAvailableMediaObjectsMenuOption()),
    SHOW_RENTED_MEDIA_OBJECTS("7", "Show Rented Media objects...", new ShowRentedMediaObjectsMenuOption()),
    SHOW_RENTAL_INCOME("8", "Show Rental Income From Media objects...", new ShowRentalIncomeFromMediaObjectsMenuOption()),
    QUIT("9", "Quit", new QuitMenuOption()),
    INVALID_ITEM("-1", "", new InvalidMenuOption());

    private static final Map<String, MenuItem> ID_TO_ITEM_MAP = new HashMap<>();

    static {
        // caching to avoid calculating again and again
        stream(values()).forEach(menuItem -> ID_TO_ITEM_MAP.put(menuItem.itemId, menuItem));
    }

    private final String itemId;
    private final String itemDisplayText;
    private final MenuOptionRunnable runnable;

    MenuItem(String itemId, String itemDisplayText, MenuOptionRunnable runnable) {
        this.itemId = itemId;
        this.itemDisplayText = itemDisplayText;
        this.runnable = runnable;
    }

    MenuOptionRunnable getRunnable() {
        return runnable;
    }

    String getItemId() {
        return itemId;
    }

    String getItemDisplayText() {
        return itemDisplayText;
    }

    static MenuItem convert(String option) {
        return ID_TO_ITEM_MAP.getOrDefault(option, INVALID_ITEM);
    }
}