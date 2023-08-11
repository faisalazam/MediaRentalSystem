<!-- TOC -->
  * [Sample media JSON files](#sample-media-json-files)
      * [[123_EBook.json][123_EBook-json]](#123ebookjson123ebook-json)
      * [[126_MovieDVD.json][126_MovieDVD-json]](#126moviedvdjson126moviedvd-json)
      * [[136_MusicCD.json][136_MusicCD-json]](#136musiccdjson136musiccd-json)
  * [Media Filename Format](#media-filename-format)
  * [Adding new Media Format](#adding-new-media-format)
  * [[Media.java][Media-java]](#mediajavamedia-java)
<!-- TOC -->

[Go Back](../README.md)

## Sample media JSON files

Following are the sample JSON files containing the media information for different media formats.
You can add as many of these as you like in the directory which you'll be uploading later.

#### [123_EBook.json][123_EBook-json]

```json
{
  "id": 123,
  "title": "Forever Young",
  "year": 2018,
  "chapters": 20,
  "available": true
}
```

#### [126_MovieDVD.json][126_MovieDVD-json]

```json
{
  "id": 126,
  "title": "Forever Young",
  "year": 2020,
  "size": 140.0,
  "available": true
}
```

#### [136_MusicCD.json][136_MusicCD-json]

```json
{
  "id": 136,
  "title": "Forever Green",
  "year": 2022,
  "duration": 75,
  "available": true
}
```

## Media Filename Format

Media files are expected to follow the naming convention which is:

`MEDIA-ID_MEDIA-TYPE.json` e.g.: [136_MusicCD.json][136_MusicCD-json]

This naming pattern will had additional benefits, for example, we know the type of the media by looking at the filename
without actually opening the file.

## Adding new Media Format

It's quite easy to introduce a new media format into this system. All you have to do is:

* create a new media class in the [media package][media-package]
* extend it from [Media.java][Media-java]
* Following is a sample media class:

```java
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
```

Note the use of `@JsonCreator(mode = PROPERTIES)` and `@JsonProperty("...")` around/in the constructor,
these annotations will tell Jackson that don't look for no-args constructor and instead, use the annotated constructor.

## [Media.java][Media-java]

Apart from being a simple parent abstract class, it has a static initialization block:

```
private static final Map<String, Class<? extends Media>> NAME_TO_CLASS_MAP = new HashMap<>();

static {
    final Reflections reflections = new Reflections(MAIN_PACKAGE);
    final Set<Class<? extends Media>> mediaSubTypes = reflections.getSubTypesOf(Media.class);
    mediaSubTypes.forEach(mediaSubType -> NAME_TO_CLASS_MAP.put(mediaSubType.getSimpleName().toLowerCase(), mediaSubType));
}
```

That code above, is using reflection to load all available media formats into system.
And that's how simply creating a new media class extended it from [Media.java][Media-java]
will start working automagically.

[Go Back](../README.md)


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->

[123_EBook-json]:../src/main/resources/media/123_EBook.json

[136_MusicCD-json]:../src/main/resources/media/136_MusicCD.json

[126_MovieDVD-json]:../src/main/resources/media/126_MovieDVD.json

[media-package]:../src/main/java/com/mediarentalsystem/model/media

[Media-java]:../src/main/java/com/mediarentalsystem/model/media/Media.java
