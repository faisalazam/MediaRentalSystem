package com.mediarentalsystem.menu;

import com.mediarentalsystem.menuoptions.GoBackToParentMenuOption;
import com.mediarentalsystem.menuoptions.MenuOptionRunnable;
import com.mediarentalsystem.menuoptions.find.FindByTitleMediaObjectsMenuOption;
import com.mediarentalsystem.menuoptions.info.ShowAvailableMediaObjectsMenuOption;
import com.mediarentalsystem.menuoptions.info.ShowRentalIncomeFromMediaObjectsMenuOption;
import com.mediarentalsystem.menuoptions.info.ShowRentedMediaObjectsMenuOption;
import com.mediarentalsystem.menuoptions.main.FindMediaObjectsMenuOption;
import com.mediarentalsystem.menuoptions.main.InvalidMenuOption;
import com.mediarentalsystem.menuoptions.main.LoadMediaObjectsMenuOption;
import com.mediarentalsystem.menuoptions.main.QuitMenuOption;
import com.mediarentalsystem.menuoptions.main.RentMediaObjectsMenuOption;
import com.mediarentalsystem.menuoptions.main.SystemInfoMenuOption;
import com.mediarentalsystem.menuoptions.rent.RentMediaObjectsByIdMenuOption;
import com.mediarentalsystem.menuoptions.rent.ReturnRentedMediaObjectsMenuOption;

import static com.mediarentalsystem.menu.ParentMenu.FIND;
import static com.mediarentalsystem.menu.ParentMenu.INFO;
import static com.mediarentalsystem.menu.ParentMenu.MAIN;
import static com.mediarentalsystem.menu.ParentMenu.RENT;

class LoadMediaObjectsMenuItemImpl extends AbstractMenuItem {
    private LoadMediaObjectsMenuItemImpl() {
        super(false, MAIN, "1", "Load Media objects...", new LoadMediaObjectsMenuOption());
    }
}


class FindMediaObjectsMenuItemImpl extends AbstractMenuItem {
    private FindMediaObjectsMenuItemImpl() {
        super(true, MAIN, "2", "Find Media objects...", new FindMediaObjectsMenuOption());
    }
}

class FindByTitleMediaObjectsMenuItemImpl extends AbstractMenuItem {
    private FindByTitleMediaObjectsMenuItemImpl() {
        super(false, FIND, "1", "Find Media objects by title...", new FindByTitleMediaObjectsMenuOption());
    }
}

class FindByTypeMediaObjectsMenuItemImpl extends AbstractMenuItem {
    private FindByTypeMediaObjectsMenuItemImpl() {
        super(false, FIND, "2", "Find Media objects by type...", new FindByTitleMediaObjectsMenuOption());
    }
}

class FindByYearMediaObjectsMenuItemImpl extends AbstractMenuItem {
    private FindByYearMediaObjectsMenuItemImpl() {
        super(false, FIND, "3", "Find Media objects by year...", new FindByTitleMediaObjectsMenuOption());
    }
}

class FindByYearRangeMediaObjectsMenuItemImpl extends AbstractMenuItem {
    private FindByYearRangeMediaObjectsMenuItemImpl() {
        super(false, FIND, "4", "Find Media objects by year range...", new FindByTitleMediaObjectsMenuOption());
    }
}

class GoBackToParentMenuFromFindMenuItemImpl extends AbstractMenuItem {
    private GoBackToParentMenuFromFindMenuItemImpl() {
        super(false, FIND, "9", "Go back to parent menu...", new GoBackToParentMenuOption());
    }
}


class RentMediaObjectsMenuItemImpl extends AbstractMenuItem {
    private RentMediaObjectsMenuItemImpl() {
        super(true, MAIN, "3", "Rent Media objects...", new RentMediaObjectsMenuOption());
    }
}

class RentByIdMediaObjectsMenuItemImpl extends AbstractMenuItem {
    private RentByIdMediaObjectsMenuItemImpl() {
        super(false, RENT, "1", "Rent Media objects by id...", new RentMediaObjectsByIdMenuOption());
    }
}

class ReturnMediaObjectsMenuItemImpl extends AbstractMenuItem {
    private ReturnMediaObjectsMenuItemImpl() {
        super(false, RENT, "2", "Return Rented Media objects...", new ReturnRentedMediaObjectsMenuOption());
    }
}

class GoBackToParentMenuFromRentMenuItemImpl extends AbstractMenuItem {
    private GoBackToParentMenuFromRentMenuItemImpl() {
        super(false, RENT, "9", "Go back to parent menu...", new GoBackToParentMenuOption());
    }
}


class SystemInfoMenuItemImpl extends AbstractMenuItem {
    private SystemInfoMenuItemImpl() {
        super(true, MAIN, "4", "Show System Info...", new SystemInfoMenuOption());
    }
}

class ShowAvailableMediaObjectsMenuItemImpl extends AbstractMenuItem {
    private ShowAvailableMediaObjectsMenuItemImpl() {
        super(false, INFO, "1", "Show Available Media objects...", new ShowAvailableMediaObjectsMenuOption());
    }
}

class ShowRentedMediaObjectsMenuItemImpl extends AbstractMenuItem {
    private ShowRentedMediaObjectsMenuItemImpl() {
        super(false, INFO, "2", "Show Rented Media objects...", new ShowRentedMediaObjectsMenuOption());
    }
}

class ShowRentalIncomeFromMediaObjectsMenuItemImpl extends AbstractMenuItem {
    private ShowRentalIncomeFromMediaObjectsMenuItemImpl() {
        super(false, INFO, "3", "Show Rental Income From Media objects...", new ShowRentalIncomeFromMediaObjectsMenuOption());
    }
}

class GoBackToParentMenuFromInfoMenuItemImpl extends AbstractMenuItem {
    private GoBackToParentMenuFromInfoMenuItemImpl() {
        super(false, INFO, "9", "Go back to parent menu...", new GoBackToParentMenuOption());
    }
}


class QuitMenuItemImpl extends AbstractMenuItem {
    private QuitMenuItemImpl() {
        super(false, MAIN, "9", "Quit", new QuitMenuOption());
    }
}

class InvalidMenuItemImpl extends AbstractMenuItem {
    private InvalidMenuItemImpl() {
        super(false, MAIN, "-1", "", new InvalidMenuOption());
    }
}

public interface MenuItem {
    boolean hasSubMenu();

    String getItemId();

    String getItemDisplayText();

    ParentMenu getParentMenu();

    MenuOptionRunnable getRunnable();
}