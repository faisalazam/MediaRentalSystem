package com.mediarentalsystem.utils;

import com.mediarentalsystem.model.media.Media;

import java.io.File;

import static com.mediarentalsystem.utils.FileUtils.removeFileExtension;
import static java.lang.Integer.parseInt;

class MediaFile {
    private static final String ID_TYPE_SPLITTER = "_";

    private final int mediaId;
    private final String mediaType;
    private final Class<? extends Media> mediaClass;

    MediaFile(final File file) {
        final String fileName = removeFileExtension(file.getName(), true);
        final String[] fileNameSplit = fileName.split(ID_TYPE_SPLITTER);
        this.mediaId = parseInt(fileNameSplit[0]);
        this.mediaType = fileNameSplit[1];
        this.mediaClass = Media.getClazz(getMediaType());
    }

    int getMediaId() {
        return mediaId;
    }

    Class<? extends Media> getMediaClass() {
        return mediaClass;
    }

    private String getMediaType() {
        return mediaType;
    }
}
