package com.mediarentalsystem.menuoptions.rent;

import com.mediarentalsystem.menuoptions.MenuOptionRunnable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.mediarentalsystem.utils.Const.LINE_FEED;

public class RentMediaObjectsByIdMenuOption implements MenuOptionRunnable {
    private static final Logger log = LoggerFactory.getLogger(RentMediaObjectsByIdMenuOption.class.getName());

    public void run() {
        System.out.print(LINE_FEED + "Enter the id: ");
        final String idStr = inputScanner.nextLine();
        final int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            log.debug("Error parsing the input", e);
            System.out.println(LINE_FEED + "Enter a number for the 'id'.");
            return;
        }
        double rentalFee = mediaService.rentMediaById(id);
        if (rentalFee > 0) {
            System.out.println("Media was successfully rented. Rental fee = $" + rentalFee);
        }
    }
}
