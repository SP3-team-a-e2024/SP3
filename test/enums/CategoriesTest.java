package enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoriesTest {

    @Test
    void values() {
        // Arrange
        String category = "ACTION";

        // Act
        Enum<Categories> actual = Categories.valueOf(category);

        // Assert
        assertEquals(category, actual.name());
    }

    @Test
    void valueOf() {
        // Arrange
        String category = "ACTION";

        // Act
        Enum<Categories> actual = Categories.valueOf(category);

        // Assert
        assertEquals(Categories.ACTION, actual);
    }
}