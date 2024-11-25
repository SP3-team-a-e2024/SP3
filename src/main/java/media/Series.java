package media;

import enums.Categories;

import java.util.Set;
import java.util.TreeSet;

public class Series extends Media {
    Set<Season> seasons = new TreeSet<>();

    public Series(String name, float rating, int releaseYear, Set<Categories> categories) {
        super(name, rating, releaseYear, categories);
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
