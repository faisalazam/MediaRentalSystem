package com.mediarentalsystem.menu.runner.find;

import com.mediarentalsystem.menu.runner.MenuOptionRunnable;
import com.mediarentalsystem.model.media.Media;

import java.util.Collection;

import static com.mediarentalsystem.utils.Const.LINE_FEED;

public class FindMediaObjectsByYearRangeRunner implements MenuOptionRunnable {
    @Override
    public void run() {
        System.out.print(LINE_FEED + "Enter the 'from year': ");
        final String fromYear = inputScanner.nextLine();
        System.out.print("Enter the 'to year': ");
        final String toYear = inputScanner.nextLine();
        final Collection<Media> matchingMedia = mediaService.findMediaByYear(fromYear, toYear);
        if (matchingMedia.isEmpty()) {
            System.out.println("There is no media with this year range: " + fromYear + " and " + toYear + LINE_FEED);
            return;
        }
        matchingMedia.forEach(System.out::println);
        System.out.println();
    }
}
