package com.mediarentalsystem.menuoptions.info;

import com.mediarentalsystem.menuoptions.MenuOptionRunnable;

import static com.mediarentalsystem.utils.Const.LINE_FEED;

public class ShowRentalIncomeFromMediaObjectsMenuOption implements MenuOptionRunnable {
    public void run() {
        System.out.println(LINE_FEED + "Total Rental Income is: " + mediaService.getTotalRentalIncome() + LINE_FEED);
    }
}
