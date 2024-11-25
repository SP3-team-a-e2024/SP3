package UserTest;

import enums.Categories;
import user.User;
import media.Media;
import media.Series;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getWatchedMedia() {
        User user = new User("Alissa", "123");
        Set<Categories> categories = new HashSet<>();
        Set<Media> watchedMedia = new HashSet<>();
        ArrayList<Integer> seasons = new ArrayList<>();
        ArrayList<Integer> episodes = new ArrayList<>();
        Media series = new Series("Game of Thrones",9, new int[] {2010}, categories,seasons,episodes);

        watchedMedia.add(series);

        Set<Media> result = user.getWatchedMedia();

        assertNotNull(watchedMedia,"The list set should not be null");
        assertTrue(watchedMedia.contains(series), "The list should contain series1");

    }

    @Test
    void addWatchedMedia() {
        User user = new User("Alissa", "123");
        Set<Categories> categories = new HashSet<>();
        ArrayList<Integer> seasons = new ArrayList<>();
        ArrayList<Integer> episodes = new ArrayList<>();
        Media series = new Series("Game of Thrones",9, new int[] {2010}, categories,seasons,episodes);
        user.addWatchedMedia(series);
        Set<Media> watchedMedia = user.getWatchedMedia();
        assertTrue(watchedMedia.contains(series), "The list should contain series");
    }

    @Test
    void getSavedMedia() {
        // Arrange
        Set<Media> savedMedia = new HashSet<>();
        Set<Categories> categories = new HashSet<>();
        categories.add(Categories.FANTASY);
        ArrayList<Integer> seasons = new ArrayList<>();
        ArrayList<Integer> episodes = new ArrayList<>();
        Media series = new Series("Game of Thrones",9, new int[] {2010}, categories,seasons,episodes);

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
        Set<Categories> categories = new HashSet<>();
        ArrayList<Integer> seasons = new ArrayList<>();
        ArrayList<Integer> episodes = new ArrayList<>();
        Media series = new Series("Game of Thrones",9, new int[] {2010}, categories,seasons,episodes);
        user.addSavedMedia(series);
        Set<Media> savedMedia = user.getSavedMedia();
        assertTrue(savedMedia.contains(series), "The list should contain series");

    }

    @Test
    void removeSavedMedia() {
        User user = new User("Alissa", "123");
        Set<Categories> categories = new HashSet<>();
        ArrayList<Integer> seasons = new ArrayList<>();
        ArrayList<Integer> episodes = new ArrayList<>();
        Media series = new Series("Game of Thrones",9, new int[] {2010}, categories,seasons,episodes);
        user.addSavedMedia(series);
        Set<Media> savedMedia = user.getSavedMedia();
        assertTrue(savedMedia.contains(series),"The saved Media should contain series");
        user.removeSavedMedia(series);
        assertFalse(savedMedia.contains(series), "The savedMedia should not contain series");
    }
}