package com.mediarentalsystem.menu.runner.info;

import com.mediarentalsystem.menu.runner.MenuOptionRunnable;

import static com.mediarentalsystem.utils.Const.LINE_FEED;

public class ShowRentalIncomeFromMediaObjectsRunner implements MenuOptionRunnable {
    @Override
    public void run() {
        System.out.println(LINE_FEED + "Total Rental Income is: " + mediaService.getTotalRentalIncome() + LINE_FEED);
    }
}
