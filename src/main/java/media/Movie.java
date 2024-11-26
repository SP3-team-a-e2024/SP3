package media;
import Main.Playable;
import enums.Categories;
import util.TextUI;
import java.util.Arrays;
import java.util.Set;

public class Movie extends Media implements Playable {
    public Movie(String name, float rating, int[] releaseYear, Set<Categories> categories) {
        super(name, rating, releaseYear, categories);
    }

    @Override
    public void playMedia(){
        TextUI.displayMsg("Now playing: '" + this.getName() + "'");
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public float getRating(){
        return this.rating;
    }

    @Override
    public int[] getReleaseYear(){
        return this.releaseYear;
    }

    @Override
    public Set<Categories> getCategories(){
        return this.categories;
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof Movie) {
            Movie movie = (Movie)o;
            boolean isNameEqual = this.getName().equalsIgnoreCase(movie.getName());
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
                this.getName().hashCode()
                * this.getRating()
                * Arrays.hashCode(this.getReleaseYear())
                * this.getCategories().hashCode()
        );
    }
}
