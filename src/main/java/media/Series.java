package media;

import enums.SeriesCategories;
import Main.Playable;
import java.util.Set;
import java.util.TreeSet;

public class Series extends Media implements Playable {
    Set<Season> seasons = new TreeSet<>();

    public Series(String name, float rating, int releaseYear, Set<SeriesCategories> categories) {
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
