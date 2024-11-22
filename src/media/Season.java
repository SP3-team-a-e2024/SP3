package media;

import enums.SeriesCategories;

import java.util.Set;
import java.util.TreeSet;



public class Season extends Series {
    Set <Episode> episodes = new TreeSet<>();

    public Season(String name, float rating, int releaseYear, Set<SeriesCategories> categories) {
        super(name, rating, releaseYear, categories);
    }
}
