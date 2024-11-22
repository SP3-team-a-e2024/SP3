package media;

import enums.SeriesCategories;

import java.util.Set;

public class Episode extends Season {
    private int episodeNumber;

    public Episode(String name, float rating, int releaseYear, Set<SeriesCategories> categories) {
        super(name, rating, releaseYear, categories);
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }
}
