package media;

import enums.Categories;
import Main.Playable;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class Series extends Media implements Playable {
    Set<Season> seasons = new HashSet<>();

    public Series(String name, float rating, int[] releaseYear, Set<Categories> categories, List<Integer> seasonlist, List<Integer> episodes) {
        super(name, rating, releaseYear, categories);
        for (int i = 0; i < seasonlist.size(); i++) {
            this.seasons.add(new Season(episodes.get(i)));
        }
    }
    public void playMedia(){

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getRating() {
        return this.rating;
    }

    @Override
    public int[] getReleaseYear() {
        return this.releaseYear;
    }

    @Override
    public Set<Enum> getCategories() {
        return this.categories;
    }

    @Override
    public boolean equals(Object o) {
        return this.equals(o);
    }

    @Override
    public int hashCode() {
        return this.hashCode();
    }
}
