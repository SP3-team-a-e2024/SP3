package media;

import enums.Categories;
import Main.Playable;

import java.util.Arrays;
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
            this.seasons.add(new Season(episodes.get(i)));
        }
    }
    //plays media (there is no media, this is a dummy)
    public void playMedia() {

    }

    //getter for title
    public Set<Season> getSeasons() {
        return this.getSeasons();
    }

    public void setSeasons(Set<Season> seasons) {
        this.seasons = seasons;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    //getter for rating
    @Override
    public float getRating() {
        return this.rating;
    }

    //getter for releaseYear
    @Override
    public int[] getReleaseYear() {
        return this.releaseYear;
    }

    //getter for categories
    @Override

    public Set<Categories> getCategories() {
        return this.categories;
    }
    //equals override
    //todo: equals function
    @Override
    public boolean equals(Object o) {
        Series series = (Series) o;
        boolean isNameEqual = this.title.equals(series.title);
        boolean isRatingEqual = this.rating == series.rating;
        boolean isReleaseYearEqual = this.releaseYear == series.releaseYear;
        boolean isCategoriesEqual = this.categories.equals(series.categories);
        boolean isSeasonsEqual = this.seasons.equals(series.seasons);
        return isNameEqual && isRatingEqual && isReleaseYearEqual && isCategoriesEqual && isSeasonsEqual;
    }
    //hashcode override
    //todo: hashcode function
    @Override
    public int hashCode() {
        return (int) (
                this.getTitle().hashCode()
                        * this.getRating()
                        * Arrays.hashCode(this.getReleaseYear())
                        * this.getCategories().hashCode()
                        * this.getSeasons().hashCode()
        );
    }
}
