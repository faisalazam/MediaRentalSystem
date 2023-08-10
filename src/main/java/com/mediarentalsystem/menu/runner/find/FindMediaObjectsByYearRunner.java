package com.mediarentalsystem.menu.runner.find;

import com.mediarentalsystem.model.media.Media;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

import static com.mediarentalsystem.utils.Const.LINE_FEED;

public class FindMediaObjectsByYearRunner extends AbstractFindMediaObjectsRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(FindMediaObjectsByYearRunner.class);

    @Override
    String getPromptText() {
        return "Enter the year: ";
    }

    @Override
    String getErrorText(String userInput) {
        return "There is no media with this year: " + userInput;
    }

    @Override
    Collection<Media> matchingMedias(String userInput) {
        final int year;
        try {
            year = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            LOGGER.debug("Error parsing the input", e);
            System.out.println(LINE_FEED + "Enter a number for the 'year'.");
            return null;
        }
        return mediaService.findMediaByYear(year);
    }
}
