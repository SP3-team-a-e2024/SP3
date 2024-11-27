package media;

import enums.Categories;
import Main.Playable;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class Series extends Media implements Playable {
    Set<Season> seasons = new HashSet<>();
    //constructor
    public Series(String name, float rating, int[] releaseYear, Set<Categories> categories, List<Integer> seasonlist, List<Integer> episodes) {
        super(name, rating, releaseYear, categories);
        //for each season in the season list, create a season with an episode count corresponding to the same index in the episodes list
        for (int i = 0; i < seasonlist.size(); i++) {
            this.seasons.add(new Season(i,episodes.get(i)));
        }
    }
    //plays media (there is no media, this is a dummy)
    public void playMedia(){

    }

    //getter for title
    @Override
    public String getTitle() {
        return "";
    }

    //getter for rating
    @Override
    public float getRating() {
        return 0;
    }

    //getter for releaseYear
    @Override
    public int[] getReleaseYear() {
        return new int[]{};
    }

    //getter for categories
    @Override
    public Set<Categories> getCategories() {
        return Set.of();
    }
    //equals override
    //todo: equals function
    @Override
    public boolean equals(Object o) {
        return false;
    }
    //hashcode override
    //todo: hashcode function
    @Override
    public int hashCode() {
        return 0;
    }

    public Set<Season> getSeasons() {
        return seasons;
    }
}
