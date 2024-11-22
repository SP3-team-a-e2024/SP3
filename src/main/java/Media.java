
public abstract class Media {

    private String name;
    private float rating;
    private int releaseYear;
    private Enum categories;


    public abstract String getName();


    public abstract float getRating();


    public abstract int getReleaseYear();


    public abstract Enum getCategories();

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract int hashCode();

}
