package com.mediarentalsystem.menu.runner.find;

import com.mediarentalsystem.model.media.Media;

import java.util.Collection;

public class FindMediaObjectsByYearRunner extends AbstractFindMediaObjectsRunner {
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
        return mediaService.findMediaByYear(userInput);
    }
}
