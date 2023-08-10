package com.mediarentalsystem.menu.runner.rent;

import com.mediarentalsystem.menu.runner.MenuOptionRunnable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.mediarentalsystem.utils.Const.LINE_FEED;

public class ReturnRentedMediaObjectsRunner implements MenuOptionRunnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReturnRentedMediaObjectsRunner.class);

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
        boolean returned = mediaService.returnRentedMediaById(id);
        if (returned) {
            System.out.println("Rented media with id=" + id + " Media was returned successfully.");
        }
    }
}
