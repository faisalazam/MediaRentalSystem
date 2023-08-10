package com.mediarentalsystem.menu.runner.find;

import com.mediarentalsystem.model.media.Media;

import java.util.Collection;

public class FindMediaObjectsByTypeRunner extends AbstractFindMediaObjectsRunner {
    @Override
    String getPromptText() {
        return "Enter the type: ";
    }

    @Override
    String getErrorText(String userInput) {
        return "There is no media with this type: " + userInput;
    }

    @Override
    Collection<Media> matchingMedias(String userInput) {
        return mediaService.findMediaByType(userInput);
    }
}
