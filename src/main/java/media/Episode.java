package media;

import enums.Categories;
import java.util.List;
import java.util.Set;

public class Episode extends Season {
    private int episodeNumber;

    public Episode(String name, float rating, int[] releaseYear, Set<Categories> categories, List<Integer> seasons, List<Integer> episodes) {
        super(name, rating, releaseYear, categories, seasons, episodes);
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }
}
