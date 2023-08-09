package com.mediarentalsystem.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mediarentalsystem.model.media.Media;

import java.io.File;
import java.io.IOException;

public class MediaFileParser {
    // Static variable reference of single_instance of type Singleton
    private static MediaFileParser singleInstance = null;

    // Constructor
    // Here we will be creating private constructor restricted to this class itself
    private MediaFileParser() {
    }

    // Static method to create instance of Singleton class
    public static synchronized MediaFileParser getInstance() {
        if (singleInstance == null) {
            singleInstance = new MediaFileParser();
        }
        return singleInstance;
    }

    public Media parse(final File file) {
        final com.mediarentalsystem.utils.MediaFile mediaFile = new com.mediarentalsystem.utils.MediaFile(file);
        final ObjectMapper objectMapper = new ObjectMapper();
        Media media;
        try {
            media = objectMapper.readValue(file, mediaFile.getMediaClass());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(media);
        return media;
    }
}