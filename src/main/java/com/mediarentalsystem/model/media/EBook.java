package com.mediarentalsystem.model.media;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.fasterxml.jackson.annotation.JsonCreator.Mode.PROPERTIES;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EBook extends Media {
    private final int chapters;

    @JsonCreator(mode = PROPERTIES)
    public EBook(@JsonProperty("id") int id,
                 @JsonProperty("title") String title,
                 @JsonProperty("year") int year,
                 @JsonProperty("chapters") int chapters) {
        super(id, year, 2.0, title);
        this.chapters = chapters;
    }

    @Override
    public String getStringToAppend() {
        return "chapters=" + chapters;
    }
}
