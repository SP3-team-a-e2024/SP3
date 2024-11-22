package media;

import java.util.Set;

public abstract class Media {

    private String name;
    private float rating;
    private int releaseYear;
    private Set<Enum> categories;

    public Media(String name, float rating, int releaseYear, Set<?> categories) {
        this.name = name;
        this.rating = rating;
        this.releaseYear = releaseYear;
        this.categories = (Set<Enum>) categories;
    }

    public abstract String getName();


    public abstract float getRating();


    public abstract int getReleaseYear();


    public abstract Set<Enum> getCategories();

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract int hashCode();

}
