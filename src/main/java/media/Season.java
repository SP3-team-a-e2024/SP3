package media;

import enums.Categories;

import java.util.Set;
import java.util.TreeSet;



public class Season extends Series {
    Set <Episode> episodes = new TreeSet<>();

    public Season(String name, float rating, int releaseYear, Set<Categories> categories) {
        super(name, rating, releaseYear, categories);
    }
}
