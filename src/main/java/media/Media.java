package media;

import enums.Categories;

import java.util.Set;

public abstract class Media {

    protected String title;
    protected float rating;
    protected int[] releaseYear;
    protected Set<Categories> categories;

    public Media(String title, float rating, int[] releaseYear, Set<Categories> categories) {
        this.title = title;
        this.rating = rating;
        this.releaseYear = releaseYear;
        this.categories = categories;
    }



    public abstract String getTitle();


    public abstract float getRating();


    public abstract int[] getReleaseYear();


    public abstract Set<Categories> getCategories();

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract int hashCode();

}
