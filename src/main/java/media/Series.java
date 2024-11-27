package media;

import enums.Categories;
import Main.Playable;

import java.util.Arrays;
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

    public void playMedia() {

    }

    public Set<Season> getSeasons() {
        return this.getSeasons();
    }

    public void setSeasons(Set<Season> seasons) {
        this.seasons = seasons;
    }

    @Override
    public String getTitle() {
        return "";
        public String getName () {
            return this.name;
        }

        @Override
        public float getRating () {
            return this.rating;
        }

        @Override
        public int[] getReleaseYear () {
            return new int[]{};
            public int[] getReleaseYear () {
                return this.releaseYear;
            }

            @Override
            public Set<Categories> getCategories () {
                return Set.of();
                public Set<Enum> getCategories () {
                    return this.categories;
                }

                @Override
                public boolean equals (Object o){
                    Series series = (Series) o;
                    boolean isNameEqual = this.name.equals(series.name);
                    boolean isRatingEqual = this.rating == series.rating;
                    boolean isReleaseYearEqual = this.releaseYear == series.releaseYear;
                    boolean isCategoriesEqual = this.categories.equals(series.categories);
                    boolean isSeasonsEqual = this.seasons.equals(series.seasons);
                    return isNameEqual && isRatingEqual && isReleaseYearEqual && isCategoriesEqual && isSeasonsEqual;
                }

                @Override
                public int hashCode () {
                    return (int) (
                            this.getName().hashCode()
                                    * this.getRating()
                                    * Arrays.hashCode(this.getReleaseYear())
                                    * this.getCategories().hashCode()
                                    * this.getSeasons().hashCode()
                    );
                }
            }
        }
    }
}