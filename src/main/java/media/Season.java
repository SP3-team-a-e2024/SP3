package media;

import enums.Categories;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class Season extends Series {
    Set <Episode> episodes = new HashSet<>();

    public Season(String name, float rating, int[] releaseYear, Set<Categories> categories, List<Integer> seasons, List<Integer> episodes) {
        super(name, rating, releaseYear, categories, seasons, episodes);
    }
}
