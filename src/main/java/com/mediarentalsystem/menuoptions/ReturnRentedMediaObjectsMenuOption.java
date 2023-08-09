package com.mediarentalsystem.menuoptions;

import static com.mediarentalsystem.utils.Const.LINE_FEED;

public class ReturnRentedMediaObjectsMenuOption implements com.mediarentalsystem.menuoptions.MenuOptionRunnable {
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
        boolean returned = mediaService.returnRentedMediaById(id);
        if (returned) {
            System.out.println("Rented media with id=" + id + " Media was returned successfully.");
        }
    }
}
