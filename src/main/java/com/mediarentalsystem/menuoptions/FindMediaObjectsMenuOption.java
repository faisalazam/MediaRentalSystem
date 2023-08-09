package com.mediarentalsystem.menuoptions;

import com.mediarentalsystem.model.media.Media;

import java.util.Collection;

import static com.mediarentalsystem.utils.Const.LINE_FEED;

public class FindMediaObjectsMenuOption implements MenuOptionRunnable {
    public void run() {
        System.out.print(LINE_FEED + "Enter the title: ");
        final String title = inputScanner.nextLine();
        final Collection<Media> matchingMedia = mediaService.findMediaByTitle(title);
        if (matchingMedia.isEmpty()) {
            System.out.println("There is no media with this title: " + title);
            return;
        }
        matchingMedia.forEach(System.out::println);
    }
}
