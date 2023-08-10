package com.mediarentalsystem.service;

import com.mediarentalsystem.model.media.Media;

import java.util.Collection;

public interface MediaService {
    boolean loadMedia(String pathToLoadFrom);

    Collection<Media> findMediaByTitle(String title);

    Collection<Media> findRentedMedias();

    Collection<Media> findAvailableMedias();

    double rentMediaById(int id);

    boolean returnRentedMediaById(int id);

    double getTotalRentalIncome();

    Collection<Media> findMediaByType(String type);

    Collection<Media> findMediaByYear(String year);

    Collection<Media> findMediaByYear(String fromYear, String toYear);
}
