package com.mediarentalsystem.menu.runner.rent;

import com.mediarentalsystem.menu.runner.MenuOptionRunnable;
import org.slf4j.Logger;

import static com.mediarentalsystem.utils.Const.LINE_FEED;
import static org.slf4j.LoggerFactory.getLogger;

public class RentMediaObjectsByIdRunner implements MenuOptionRunnable {
    private static final Logger LOGGER = getLogger(RentMediaObjectsByIdRunner.class);

    @Override
    public void run() {
        System.out.print(LINE_FEED + "Enter the id: ");
        final String idStr = inputScanner.nextLine();
        final int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            LOGGER.debug("Error parsing the input", e);
            System.out.println(LINE_FEED + "Enter a number for the 'id'.");
            return;
        }
        double rentalFee = mediaService.rentMediaById(id);
        if (rentalFee > 0) {
            System.out.println("Media was successfully rented. Rental fee = $" + rentalFee);
        }
    }
}
