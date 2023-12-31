package com.mediarentalsystem.menu.runner.find;

import com.mediarentalsystem.model.media.Media;

import java.util.Collection;

public class FindMediaObjectsByTitleRunner extends AbstractFindMediaObjectsRunner {
    @Override
    String getPromptText() {
        return "Enter the title: ";
    }

    @Override
    String getErrorText(String userInput) {
        return "There is no media with this title: " + userInput;
    }

    @Override
    Collection<Media> matchingMedias(String userInput) {
        return mediaService.findMediaByTitle(userInput);
    }
}
