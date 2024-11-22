package enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeriesCategoriesTest {

    @Test
    void values() {
        // Arrange
        String category = "ACTION";

        // Act
        Enum<SeriesCategories> actual = SeriesCategories.valueOf(category);

        // Assert
        assertEquals(category, actual.name());
    }

    @Test
    void valueOf() {
        // Arrange
        String category = "ACTION";

        // Act
        Enum<SeriesCategories> actual = SeriesCategories.valueOf(category);

        // Assert
        assertEquals(SeriesCategories.ACTION, actual);
    }
}