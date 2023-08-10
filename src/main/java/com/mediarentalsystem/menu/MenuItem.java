package com.mediarentalsystem.menu;

import com.mediarentalsystem.menu.runner.GoBackToParentRunner;
import com.mediarentalsystem.menu.runner.MenuOptionRunnable;
import com.mediarentalsystem.menu.runner.find.FindMediaObjectsByTitleRunner;
import com.mediarentalsystem.menu.runner.info.ShowAvailableMediaObjectsRunner;
import com.mediarentalsystem.menu.runner.info.ShowRentalIncomeFromMediaObjectsRunner;
import com.mediarentalsystem.menu.runner.info.ShowRentedMediaObjectsRunner;
import com.mediarentalsystem.menu.runner.main.FindMediaObjectsRunner;
import com.mediarentalsystem.menu.runner.main.InvalidRunner;
import com.mediarentalsystem.menu.runner.main.LoadMediaObjectsRunner;
import com.mediarentalsystem.menu.runner.main.QuitRunner;
import com.mediarentalsystem.menu.runner.main.RentMediaObjectsRunner;
import com.mediarentalsystem.menu.runner.main.SystemInfoRunner;
import com.mediarentalsystem.menu.runner.rent.RentMediaObjectsByIdRunner;
import com.mediarentalsystem.menu.runner.rent.ReturnRentedMediaObjectsRunner;

import static com.mediarentalsystem.menu.ParentMenu.FIND;
import static com.mediarentalsystem.menu.ParentMenu.INFO;
import static com.mediarentalsystem.menu.ParentMenu.MAIN;
import static com.mediarentalsystem.menu.ParentMenu.RENT;

class LoadMediaObjectsMenuItemImpl extends AbstractMenuItem {
    private LoadMediaObjectsMenuItemImpl() {
        super(false, MAIN, "1", "Load Media objects...", new LoadMediaObjectsRunner());
    }
}


class FindMediaObjectsMenuItemImpl extends AbstractMenuItem {
    private FindMediaObjectsMenuItemImpl() {
        super(true, MAIN, "2", "Find Media objects...", new FindMediaObjectsRunner());
    }
}

class FindByTitleMediaObjectsMenuItemImpl extends AbstractMenuItem {
    private FindByTitleMediaObjectsMenuItemImpl() {
        super(false, FIND, "1", "Find Media objects by title...", new FindMediaObjectsByTitleRunner());
    }
}

class FindByTypeMediaObjectsMenuItemImpl extends AbstractMenuItem {
    private FindByTypeMediaObjectsMenuItemImpl() {
        super(false, FIND, "2", "Find Media objects by type...", new FindMediaObjectsByTitleRunner());
    }
}

class FindByYearMediaObjectsMenuItemImpl extends AbstractMenuItem {
    private FindByYearMediaObjectsMenuItemImpl() {
        super(false, FIND, "3", "Find Media objects by year...", new FindMediaObjectsByTitleRunner());
    }
}

class FindByYearRangeMediaObjectsMenuItemImpl extends AbstractMenuItem {
    private FindByYearRangeMediaObjectsMenuItemImpl() {
        super(false, FIND, "4", "Find Media objects by year range...", new FindMediaObjectsByTitleRunner());
    }
}

class GoBackToParentMenuFromFindMenuItemImpl extends AbstractMenuItem {
    private GoBackToParentMenuFromFindMenuItemImpl() {
        super(false, FIND, "9", "Go back to parent menu...", new GoBackToParentRunner());
    }
}


class RentMediaObjectsMenuItemImpl extends AbstractMenuItem {
    private RentMediaObjectsMenuItemImpl() {
        super(true, MAIN, "3", "Rent Media objects...", new RentMediaObjectsRunner());
    }
}

class RentByIdMediaObjectsMenuItemImpl extends AbstractMenuItem {
    private RentByIdMediaObjectsMenuItemImpl() {
        super(false, RENT, "1", "Rent Media objects by id...", new RentMediaObjectsByIdRunner());
    }
}

class ReturnMediaObjectsMenuItemImpl extends AbstractMenuItem {
    private ReturnMediaObjectsMenuItemImpl() {
        super(false, RENT, "2", "Return Rented Media objects...", new ReturnRentedMediaObjectsRunner());
    }
}

class GoBackToParentMenuFromRentMenuItemImpl extends AbstractMenuItem {
    private GoBackToParentMenuFromRentMenuItemImpl() {
        super(false, RENT, "9", "Go back to parent menu...", new GoBackToParentRunner());
    }
}


class SystemInfoMenuItemImpl extends AbstractMenuItem {
    private SystemInfoMenuItemImpl() {
        super(true, MAIN, "4", "Show System Info...", new SystemInfoRunner());
    }
}

class ShowAvailableMediaObjectsMenuItemImpl extends AbstractMenuItem {
    private ShowAvailableMediaObjectsMenuItemImpl() {
        super(false, INFO, "1", "Show Available Media objects...", new ShowAvailableMediaObjectsRunner());
    }
}

class ShowRentedMediaObjectsMenuItemImpl extends AbstractMenuItem {
    private ShowRentedMediaObjectsMenuItemImpl() {
        super(false, INFO, "2", "Show Rented Media objects...", new ShowRentedMediaObjectsRunner());
    }
}

class ShowRentalIncomeFromMediaObjectsMenuItemImpl extends AbstractMenuItem {
    private ShowRentalIncomeFromMediaObjectsMenuItemImpl() {
        super(false, INFO, "3", "Show Rental Income From Media objects...", new ShowRentalIncomeFromMediaObjectsRunner());
    }
}

class GoBackToParentMenuFromInfoMenuItemImpl extends AbstractMenuItem {
    private GoBackToParentMenuFromInfoMenuItemImpl() {
        super(false, INFO, "9", "Go back to parent menu...", new GoBackToParentRunner());
    }
}


class QuitMenuItemImpl extends AbstractMenuItem {
    private QuitMenuItemImpl() {
        super(false, MAIN, "9", "Quit", new QuitRunner());
    }
}

class InvalidMenuItemImpl extends AbstractMenuItem {
    private InvalidMenuItemImpl() {
        super(false, MAIN, "-1", "", new InvalidRunner());
    }
}

public interface MenuItem {
    boolean hasSubMenu();

    String getItemId();

    String getItemDisplayText();

    ParentMenu getParentMenu();

    MenuOptionRunnable getRunnable();
}