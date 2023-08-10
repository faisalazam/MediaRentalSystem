package com.mediarentalsystem.menu.runner.find;

import com.mediarentalsystem.menu.runner.MenuOptionRunnable;
import com.mediarentalsystem.model.media.Media;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

import static com.mediarentalsystem.utils.Const.LINE_FEED;

public class FindMediaObjectsByYearRangeRunner implements MenuOptionRunnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(FindMediaObjectsByYearRangeRunner.class);

    @Override
    public void run() {
        System.out.print(LINE_FEED + "Enter the 'from year': ");
        final String fromYear = inputScanner.nextLine();
        final int fromYearInt = parseYear(fromYear);

        System.out.print("Enter the 'to year': ");
        final String toYear = inputScanner.nextLine();
        final int toYearInt = parseYear(toYear);

        if (toYearInt == -1 || fromYearInt == -1) {
            return;
        }

        final Collection<Media> matchingMedia = mediaService.findMediaByYear(fromYearInt, toYearInt);
        if (matchingMedia.isEmpty()) {
            System.out.println("There is no media with this year range: " + fromYearInt + " and " + toYearInt + LINE_FEED);
            return;
        }
        matchingMedia.forEach(System.out::println);
        System.out.println();
    }

    private static int parseYear(String year) {
        try {
            return Integer.parseInt(year);
        } catch (NumberFormatException e) {
            LOGGER.debug("Error parsing the input", e);
            System.out.println(LINE_FEED + "Enter a number for the 'year'.");
            return -1;
        }
    }
}
