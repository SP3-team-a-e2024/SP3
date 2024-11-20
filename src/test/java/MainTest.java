import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void main() {
        // Arrange
        Runnable actual;

        // Act
        actual = () -> Main.main(null);

        // Assert
        assertDoesNotThrow(actual::run);
    }
}