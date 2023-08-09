package com.mediarentalsystem.menuoptions;

import static com.mediarentalsystem.utils.Const.LINE_FEED;

public class LoadMediaObjectsMenuOption implements com.mediarentalsystem.menuoptions.MenuOptionRunnable {
    public void run() {
        System.out.print(LINE_FEED + "Enter path (directory) where to load from: ");
        final String pathToLoadFrom = inputScanner.nextLine();
        final boolean isMediaLoaded = mediaService.loadMedia(pathToLoadFrom);
        if (!isMediaLoaded) {
            System.out.println(LINE_FEED + "File cannot be opened: Could not load, no such directory");
        }
    }
}
