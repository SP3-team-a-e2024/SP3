package media;
import Main.Playable;
import enums.Categories;
import util.TextUI;
import java.util.Arrays;
import java.util.Set;

public class Movie extends Media implements Playable {
   //constructor
    public Movie(String title, float rating, int[] releaseYear, Set<Categories> categories) {
        super(title, rating, releaseYear, categories);
    }

    //plays media (there is no media, this is a dummy)
    @Override
    public void playMedia(){
        TextUI.displayMsg("Now playing: '" + this.getTitle() + "'");
    }

    //getter for title
    @Override
    public String getTitle(){
        return this.title;
    }

    //getter for rating
    @Override
    public float getRating(){
        return this.rating;
    }
    //getter for releaseYear
    @Override
    public int[] getReleaseYear(){
        return this.releaseYear;
    }
    //getter for categories
    @Override
    public Set<Categories> getCategories(){
        return this.categories;
    }

    //equals override
    @Override
    public boolean equals(Object o){
        //can only be the same if its the same class
        if (o instanceof Movie) {
            Movie movie = (Movie)o;
            //all variables must be the same to be the same
            boolean isNameEqual = this.getTitle().equalsIgnoreCase(movie.getTitle());
            boolean isRatingEqual = this.getRating() == movie.getRating();
            boolean isReleaseYearEqual = Arrays.equals(this.getReleaseYear(), movie.getReleaseYear());
            boolean areCategoriesEqual = this.getCategories().equals(movie.getCategories());
            return isNameEqual && isRatingEqual && isReleaseYearEqual && areCategoriesEqual;
        }

        return false;
    }

    @Override
    //hashcode overrride
    public int hashCode() {
        return (int) (
                //variables must be the same for it to be equal
                this.getTitle().hashCode()
                        * this.getRating()
                        * Arrays.hashCode(this.getReleaseYear())
                        * this.getCategories().hashCode()
        );
    }
}