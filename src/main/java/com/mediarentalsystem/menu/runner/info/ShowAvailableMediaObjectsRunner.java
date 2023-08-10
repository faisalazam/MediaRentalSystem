package com.mediarentalsystem.menu.runner.info;

import com.mediarentalsystem.menu.runner.MenuOptionRunnable;
import com.mediarentalsystem.model.media.Media;

import java.util.Collection;

import static com.mediarentalsystem.utils.Const.LINE_FEED;

public class ShowAvailableMediaObjectsRunner implements MenuOptionRunnable {
    public void run() {
        final Collection<Media> availableMedias = mediaService.findAvailableMedias();
        if (availableMedias.isEmpty()) {
            System.out.println(LINE_FEED + "There are no Media objects which are available for renting." + LINE_FEED);
            return;
        }
        System.out.println(LINE_FEED + "Below are the Media objects which are available for renting:");
        availableMedias.forEach(System.out::println);
        System.out.println();
    }
}
