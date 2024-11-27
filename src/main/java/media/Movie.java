package media;
import Main.Playable;
import enums.Categories;

import java.util.Set;

public class Movie extends Media implements Playable {
    public Movie(String name, float rating, int[] releaseYear, Set<Categories> categories) {
        super(name, rating, releaseYear, categories);
    }

    public void playMedia(){

    }
    public String getName(){return ""; }
    public float getRating(){
        return 0;
    }
    public int[] getReleaseYear(){
        return 0;
    }
    public Set<Enum> getCategories(){
        return null;
    }
    public boolean equals(Object o){
        return false;
    }
    public int hashCode(){
        return 0;
    }
}
