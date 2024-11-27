package media;
import Main.Playable;
import enums.Categories;
import util.TextUI;
import java.util.Arrays;
import java.util.Set;

public class Movie extends Media implements Playable {
    public Movie(String title, float rating, int[] releaseYear, Set<Categories> categories) {
        super(title, rating, releaseYear, categories);
    }

    @Override
    public void playMedia(){
        TextUI.displayMsg("Now playing: '" + this.getTitle() + "'");
    }

    @Override
    public String getTitle(){
        return this.title;
    }

    @Override
    public float getRating(){
        return this.rating;
    }

    @Override
    public int[] getReleaseYear(){
        return this.releaseYear;
    public int[] getReleaseYear(){
        return 0;
    }

    @Override
    public Set<Categories> getCategories(){
        return this.categories;
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof Movie) {
            Movie movie = (Movie)o;
            boolean isNameEqual = this.getTitle().equalsIgnoreCase(movie.getTitle());
            boolean isRatingEqual = this.getRating() == movie.getRating();
            boolean isReleaseYearEqual = Arrays.equals(this.getReleaseYear(), movie.getReleaseYear());
            boolean areCategoriesEqual = this.getCategories().equals(movie.getCategories());
            return isNameEqual && isRatingEqual && isReleaseYearEqual && areCategoriesEqual;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return (int) (
                this.getTitle().hashCode()
                * this.getRating()
                * Arrays.hashCode(this.getReleaseYear())
                * this.getCategories().hashCode()
        );
    }
}
