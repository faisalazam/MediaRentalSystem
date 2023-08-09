package com.mediarentalsystem.repository;

import com.mediarentalsystem.model.media.Media;

import java.io.File;
import java.util.Collection;

public interface MediaRepository {
    boolean loadMedia(final File[] filesToLoad);

    Collection<Media> findAllMedias();

    Media rentMediaById(int id);

    boolean returnRentedMediaById(int id);

    double getTotalRentalIncome();
}
