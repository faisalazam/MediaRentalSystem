package com.mediarentalsystem.service;

import com.mediarentalsystem.model.media.Media;
import com.mediarentalsystem.repository.MediaRepository;
import com.mediarentalsystem.repository.MediaRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Collection;

import static com.mediarentalsystem.utils.FileUtils.getFilesToLoad;
import static java.util.Collections.emptyList;

public class MediaServiceImpl implements MediaService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MediaServiceImpl.class);
    private final MediaRepository mediaRepository;

    public MediaServiceImpl() {
        //new MediaRepositoryImpl("media_data.txt");
        this.mediaRepository = new MediaRepositoryImpl();
    }

    @Override
    public boolean loadMedia(String pathToLoadFrom) {
        final File[] filesToLoad = getFilesToLoad(pathToLoadFrom);
        return mediaRepository.loadMedia(filesToLoad);
    }

    @Override
    public Collection<Media> findMediaByTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            return emptyList();
        }
        return mediaRepository.findAllMedias().stream()
                .filter(media -> media.getTitle().trim().toLowerCase().contains(title.trim().toLowerCase()))
                .toList();
    }

    @Override
    public Collection<Media> findMediaByType(String type) {
        if (type == null || type.trim().isEmpty()) {
            return emptyList();
        }
        final Class<? extends Media> mediaClazz = Media.getClazz(type);
        if (mediaClazz == null) {
            System.out.println("Provided media type '" + type + "' is invalid");
            return emptyList();
        }
        return mediaRepository.findAllMedias().stream()
                .filter(media -> mediaClazz.equals(media.getClass()))
                .toList();
    }

    @Override
    public Collection<Media> findMediaByYear(int year) {
        return mediaRepository.findAllMedias().stream()
                .filter(media -> media.getYear() == year)
                .toList();
    }

    @Override
    public Collection<Media> findMediaByYear(int fromYear, int toYear) {
        return mediaRepository.findAllMedias().stream()
                .filter(media -> media.getYear() >= fromYear && media.getYear() <= toYear)
                .toList();
    }

    @Override
    public Collection<Media> findRentedMedias() {
        return mediaRepository.findAllMedias().stream()
                .filter(media -> !media.isAvailable())
                .toList();
    }

    @Override
    public Collection<Media> findAvailableMedias() {
        return mediaRepository.findAllMedias().stream()
                .filter(Media::isAvailable)
                .toList();
    }

    @Override
    public double rentMediaById(int id) {
        final Media rentedMedia = mediaRepository.rentMediaById(id);
        return rentedMedia == null ? 0.0 : rentedMedia.getRent();
    }

    @Override
    public boolean returnRentedMediaById(int id) {
        return mediaRepository.returnRentedMediaById(id);
    }

    @Override
    public double getTotalRentalIncome() {
        return mediaRepository.getTotalRentalIncome();
    }
}
