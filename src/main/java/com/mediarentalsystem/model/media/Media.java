package com.mediarentalsystem.model.media;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static com.mediarentalsystem.MediaRentalSystem.MAIN_PACKAGE;

// /Users/muhammadfaisal/Documents/projects/upwork/MediaRentalSystem/src/main/resources/media
@JsonInclude(NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Media {
    private final int id;
    private final int year;
    private final double rent;
    private final String title;
    private boolean available;

    private static final Map<String, Class<? extends Media>> NAME_TO_CLASS_MAP = new HashMap<>();

    static {
        final Reflections reflections = new Reflections(MAIN_PACKAGE);
        final Set<Class<? extends Media>> mediaSubTypes = reflections.getSubTypesOf(Media.class);
        mediaSubTypes.forEach(mediaSubType -> NAME_TO_CLASS_MAP.put(mediaSubType.getSimpleName().toLowerCase(), mediaSubType));
    }

    public Media(int id, int year, double rent, String title) {
        this.id = id;
        this.year = year;
        this.rent = rent;
        this.title = title;
        this.available = true;
    }

    abstract String getStringToAppend();

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public double getRent() {
        return rent;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public static Class<? extends Media> getClazz(String name) {
        return NAME_TO_CLASS_MAP.get(name.toLowerCase());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [ " +
                "id=" + getId() + ", " +
                "title=" + getTitle() + ", " +
                "year=" + getYear() + ", " +
                getStringToAppend() + ", " +
                "available=" + isAvailable() +
                ']';
    }
}
