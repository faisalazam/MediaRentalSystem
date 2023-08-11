package com.mediarentalsystem.repository;

import com.mediarentalsystem.model.media.Media;
import com.mediarentalsystem.utils.MediaFileParser;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MediaRepositoryImpl implements MediaRepository {
    private static double totalRentalIncome = 0.0;
    private static final Map<Integer, Media> ID_TO_MEDIA_MAP = new HashMap<>();

    private final MediaFileParser mediaFileParser;

    public MediaRepositoryImpl() {
        this.mediaFileParser = MediaFileParser.getInstance();
    }

    @Override
    public boolean loadMedia(final File[] filesToLoad) {
        final List<Media> medias = Arrays.stream(filesToLoad).map(mediaFileParser::parse).toList();
        if (medias.isEmpty()) {
            return false;
        }
        ID_TO_MEDIA_MAP.clear();
        medias.forEach(media -> ID_TO_MEDIA_MAP.put(media.getId(), media));
        return true;
    }

    @Override
    public Collection<Media> findAllMedias() {
        return ID_TO_MEDIA_MAP.values();
    }

    @Override
    public Media rentMediaById(int id) {
        final Media media = ID_TO_MEDIA_MAP.get(id);
        if (media == null) {
            System.out.println("The media object id=" + id + " is not found");
            return null;
        } else if (!media.isAvailable()) {
            System.out.println("Media with ID " + id + " is not available for rent.");
            return null;
        }
        updateAvailability(media, false);
        return media;
    }

    @Override
    public boolean returnRentedMediaById(int id) {
        final Media media = ID_TO_MEDIA_MAP.get(id);
        if (media == null) {
            System.out.println("The media object id=" + id + " is not found");
            return false;
        } else if (media.isAvailable()) {
            System.out.println("Media with id=" + id + " is not rented.");
            return false;
        }
        updateAvailability(media, true);
        totalRentalIncome += media.getRent();
        return true;
    }

    @Override
    public double getTotalRentalIncome() {
        return totalRentalIncome;
    }

    private void updateAvailability(Media media, boolean availability) {
        if (updateAvailability(media)) {
            media.setAvailable(availability);
        } else {
            System.out.println("Media with id=" + media.getId() + " could not be rented for some technical issue.");
        }
    }

    @SuppressWarnings("unused")
    private boolean updateAvailability(Media media) {
        // TODO update the file with the availability information in the actual Media json file
        return true;
    }
}