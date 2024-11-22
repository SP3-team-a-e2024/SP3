import enums.SeriesCategories;
import main.java.User;
import media.Media;
import media.Series;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getWatchedMedia() {
        User user = new User("Alissa", "123");
        Set<SeriesCategories> categories = new HashSet<>();
        Set<Media> watchedMedia = new HashSet<>();
        Media series1 = new Series("Game of Thrones",9, 2010, categories);

        watchedMedia.add(series1);

        Set<Media> result = user.getWatchedMedia();

        assertNotNull(watchedMedia,"The list set should not be null");
        assertTrue(watchedMedia.contains(series1), "The list should contain series1");

    }

    @Test
    void addWatchedMedia() {
        User user = new User("Alissa", "123");
        Set<SeriesCategories> categories = new HashSet<>();
        Media series = new Series("Game of Thrones",9, 2010, categories);

        user.addWatchedMedia(series);
        Set<Media> watchedMedia = user.getWatchedMedia();
        assertTrue(watchedMedia.contains(series), "The list should contain series");
    }

    @Test
    void getSavedMedia() {
        // Arrange
        Set<Media> savedMedia = new HashSet<>();
        Set<SeriesCategories> categories = new HashSet<>();
        categories.add(SeriesCategories.FANTASY);
        Media series = new Series("Game of Thrones", 10f, 2011, categories);
        savedMedia.add(series);
        User user = new User("Alissa", "123");

        // Act
        user.addSavedMedia(series);
        Set<Media> result = user.getSavedMedia();

        // Assert
        assertEquals(savedMedia, result);
    }

    @Test
    void addSavedMedia() {
        User user = new User("Alissa", "123");
        Set<SeriesCategories> categories = new HashSet<>();
        Series series = new Series("Game of Thrones",9, 2010, categories);


        user.addSavedMedia(series);
        Set<Media> savedMedia = user.getSavedMedia();
        assertTrue(savedMedia.contains(series), "The list should contain series");

    }

    @Test
    void removeSavedMedia() {
        User user = new User("Alissa", "123");
        Set<SeriesCategories> categories = new HashSet<>();
        Series series = new Series("Game of Thrones",9, 2010, categories);

        user.addSavedMedia(series);
        Set<Media> savedMedia = user.getSavedMedia();
        assertTrue(savedMedia.contains(series),"The saved Media should contain series");

        user.removeSavedMedia(series);
        assertFalse(savedMedia.contains(series), "The savedMedia should not contain series");

    }
}