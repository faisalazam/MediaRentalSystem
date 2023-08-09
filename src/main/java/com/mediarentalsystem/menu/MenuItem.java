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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class LoadMediaObjectsMenuItemImpl extends AbstractMenuItem {
    private LoadMediaObjectsMenuItemImpl() {
        super("1", "Load Media objects...", new LoadMediaObjectsMenuOption());
    }
}

class FindMediaObjectsMenuItemImpl extends AbstractMenuItem {
    private FindMediaObjectsMenuItemImpl() {
        super("2", "Find Media objects...", new FindMediaObjectsMenuOption());
    }
}

class RentMediaObjectsMenuItemImpl extends AbstractMenuItem {
    private RentMediaObjectsMenuItemImpl() {
        super("3", "Rent Media objects...", new RentMediaObjectsMenuOption());
    }
}

class ReturnMediaObjectsMenuItemImpl extends AbstractMenuItem {
    private ReturnMediaObjectsMenuItemImpl() {
        super("4", "Return Rented Media objects...", new ReturnRentedMediaObjectsMenuOption());
    }
}

class ShowAvailableMediaObjectsMenuItemImpl extends AbstractMenuItem {
    private ShowAvailableMediaObjectsMenuItemImpl() {
        super("6", "Show Available Media objects...", new ShowAvailableMediaObjectsMenuOption());
    }
}

class ShowRentedMediaObjectsMenuItemImpl extends AbstractMenuItem {
    private ShowRentedMediaObjectsMenuItemImpl() {
        super("7", "Show Rented Media objects...", new ShowRentedMediaObjectsMenuOption());
    }
}

class ShowRentalIncomeFromMediaObjectsMenuItemImpl extends AbstractMenuItem {
    private ShowRentalIncomeFromMediaObjectsMenuItemImpl() {
        super("8", "Show Rental Income From Media objects...", new ShowRentalIncomeFromMediaObjectsMenuOption());
    }
}

class QuitMenuItemImpl extends AbstractMenuItem {
    private QuitMenuItemImpl() {
        super("9", "Quit", new QuitMenuOption());
    }
}

class InvalidMenuItemImpl extends AbstractMenuItem {
    private InvalidMenuItemImpl() {
        super("-1", "", new InvalidMenuOption());
    }
}

public interface MenuItem {
    Map<String, MenuItem> ID_TO_ITEM_MAP = new HashMap<>();

    String getItemId();

    String getItemDisplayText();

    MenuOptionRunnable getRunnable();

    static MenuItem convert(String option) {
        return ID_TO_ITEM_MAP.getOrDefault(option, ID_TO_ITEM_MAP.get("-1"));
    }

    static Collection<MenuItem> getMenuItems() {
        return ID_TO_ITEM_MAP.values();
    }
}