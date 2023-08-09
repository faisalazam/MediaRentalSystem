package com.mediarentalsystem.model.media;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.fasterxml.jackson.annotation.JsonCreator.Mode.PROPERTIES;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDVD extends Media {
    private final double size;

    @JsonCreator(mode = PROPERTIES)
    public MovieDVD(@JsonProperty("id") int id,
                    @JsonProperty("title") String title,
                    @JsonProperty("year") int year,
                    @JsonProperty("size") double size) {
        super(id, year, 5.0, title);
        this.size = size;
    }

    @Override
    public String getStringToAppend() {
        return "size=" + size + "MB";
    }
}
