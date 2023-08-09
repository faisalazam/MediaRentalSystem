package com.mediarentalsystem.model.media;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public
class MusicCD extends Media {
    private final int duration;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public MusicCD(@JsonProperty("id") int id,
                   @JsonProperty("title") String title,
                   @JsonProperty("year") int year,
                   @JsonProperty("duration") int duration) {
        super(id, year, 3.0, title);
        this.duration = duration;
    }

    @Override
    public String getStringToAppend() {
        return "duration=" + duration;
    }
}
