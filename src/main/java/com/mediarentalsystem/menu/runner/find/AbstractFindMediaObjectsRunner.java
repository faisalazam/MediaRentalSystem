package com.mediarentalsystem.menu.runner.find;

import com.mediarentalsystem.menu.runner.MenuOptionRunnable;
import com.mediarentalsystem.model.media.Media;

import java.util.Collection;

import static com.mediarentalsystem.utils.Const.LINE_FEED;

abstract class AbstractFindMediaObjectsRunner implements MenuOptionRunnable {
    abstract String getPromptText();

    abstract String getErrorText(String userInput);

    abstract Collection<Media> matchingMedias(String userInput);

    @Override
    public void run() {
        System.out.print(LINE_FEED + getPromptText());
        final String userInput = inputScanner.nextLine();
        final Collection<Media> matchingMedia = matchingMedias(userInput);
        if (matchingMedia == null) {
            return;
        } else if (matchingMedia.isEmpty()) {
            System.out.println(getErrorText(userInput) + LINE_FEED);
            return;
        }
        matchingMedia.forEach(System.out::println);
        System.out.println();
    }
}
