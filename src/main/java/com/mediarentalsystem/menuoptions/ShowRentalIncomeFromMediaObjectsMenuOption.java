package com.mediarentalsystem.menuoptions;

import static com.mediarentalsystem.utils.Const.LINE_FEED;

public class ShowRentalIncomeFromMediaObjectsMenuOption implements com.mediarentalsystem.menuoptions.MenuOptionRunnable {
    public void run() {
        System.out.println(LINE_FEED + "Total Rental Income is: " + mediaService.getTotalRentalIncome());
    }
}
