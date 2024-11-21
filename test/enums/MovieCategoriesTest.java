package enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieCategoriesTest {

    @Test
    void values() {
        // Arrange
        String category = "ACTION";

        // Act
        Enum<MovieCategories> actual = MovieCategories.valueOf(category);

        // Assert
        assertEquals(category, actual.name());
    }

    @Test
    void valueOf() {
        // Arrange
        String category = "ACTION";

        // Act
        Enum<MovieCategories> actual = MovieCategories.valueOf(category);

        // Assert
        assertEquals(MovieCategories.ACTION, actual);
    }
}