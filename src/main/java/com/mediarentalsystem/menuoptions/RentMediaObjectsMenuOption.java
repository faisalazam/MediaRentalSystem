package com.mediarentalsystem.menuoptions;

import static com.mediarentalsystem.utils.Const.LINE_FEED;

public class RentMediaObjectsMenuOption implements com.mediarentalsystem.menuoptions.MenuOptionRunnable {
    public void run() {
        System.out.print(LINE_FEED + "Enter the id: ");
        final String idStr = inputScanner.nextLine();
        final int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            System.out.println(LINE_FEED + "Enter a number for the 'id'.");
            return;
        }
        double rentalFee = mediaService.rentMediaById(id);
        if (rentalFee > 0) {
            System.out.println("Media was successfully rented. Rental fee = $" + rentalFee);
        }
    }
}
