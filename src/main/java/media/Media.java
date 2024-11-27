package media;

import java.util.Set;

public abstract class Media {

    private String name;
    private float rating;
    private int[] releaseYear;
    private Set<Enum> categories;

    public Media(String name, float rating, int[] releaseYear, Set<?> categories) {
        this.name = name;
        this.rating = rating;
        this.releaseYear = releaseYear;
        this.categories = (Set<Enum>) categories;
    }

    public abstract String getName(); // returns name from the constructor


    public abstract float getRating();// returns rating from the constructor


    public abstract int getReleaseYear();// returns the release year from the constructor


    public abstract Set<Enum> getCategories();// returns categories of enums from the constructor

    @Override
    public abstract boolean equals(Object o); // equals override for subclasses

    @Override
    public abstract int hashCode(); // hashcode override for subclasses

}
