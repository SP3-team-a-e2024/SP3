package media;

import enums.Categories;
import Main.Playable;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class Series extends Media implements Playable {
    Set<Season> seasons = new HashSet<>();

    public Series(String name, float rating, int[] releaseYear, Set<Categories> categories, List<Integer> seasons, List<Integer> episodes) {
        super(name, rating, releaseYear, categories);
    }
    public void playMedia(){

    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public float getRating() {
        return 0;
    }

    @Override
    public int getReleaseYear() {
        return 0;
    }

    @Override
    public Set<Enum> getCategories() {
        return Set.of();
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
