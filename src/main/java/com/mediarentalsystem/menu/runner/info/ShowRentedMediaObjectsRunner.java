package com.mediarentalsystem.menu.runner.info;

import com.mediarentalsystem.menu.runner.MenuOptionRunnable;
import com.mediarentalsystem.model.media.Media;

import java.util.Collection;

import static com.mediarentalsystem.utils.Const.LINE_FEED;

public class ShowRentedMediaObjectsRunner implements MenuOptionRunnable {
    @Override
    public void run() {
        final Collection<Media> rentedMedias = mediaService.findRentedMedias();
        if (rentedMedias.isEmpty()) {
            System.out.println(LINE_FEED + "There are no Media objects which are rented." + LINE_FEED);
            return;
        }
        System.out.println(LINE_FEED + "Below are the Media objects which are rented:");
        rentedMedias.forEach(System.out::println);
        System.out.println();
    }
}
