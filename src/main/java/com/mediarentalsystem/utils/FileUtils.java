package com.mediarentalsystem.utils;

import java.io.File;

public class FileUtils {
    private static final String MEDIA_FILE_FILTER_REGEX = "^[0-9]+_[a-zA-Z]+\\.json$";

    public static String removeFileExtension(String filename, boolean removeAllExtensions) {
        if (filename == null || filename.isEmpty()) {
            return filename;
        }

        final String extPattern = "(?<!^)[.]" + (removeAllExtensions ? ".*" : "[^.]*$");
        return filename.replaceAll(extPattern, "");
    }

    public static File[] getFilesToLoad(String pathToLoadFrom) {
        if (pathToLoadFrom == null || pathToLoadFrom.trim().isEmpty()) {
            return new File[]{};
        }
        final File file = new File(pathToLoadFrom.trim());
        if (file.isDirectory()) {
            return file.listFiles((dir, fileName) ->
                    fileName.matches(MEDIA_FILE_FILTER_REGEX)
            );
        } else if (file.getName().matches(MEDIA_FILE_FILTER_REGEX)) {
            return new File[]{file};
        }
        return new File[]{};
    }
}
