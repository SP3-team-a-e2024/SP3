package util;

import enums.Categories;
import media.Media;
import org.junit.jupiter.api.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FileIOTest {

    @Test @Disabled
    void readUserCredentialsNullUsers(){
        //arrange
        String path = "test/test Data/testUserData";
        Map<String,String> expected = new HashMap<>();
        //act
        Map<String,String> users = FileIO.readUserCredentials(path);
        //assert
        assertEquals(expected, users);
    }

    @Test @Disabled
    void readUserCredentials(){
        //arrange
        String path = "test/test Data/testUserData2";
        Map<String,String> expected = new HashMap<String,String>();
        expected.put("user1","pass1");
        expected.put("user2","pass2");
        //act
        Map<String,String> users = FileIO.readUserCredentials(path);
        //assert
        assertEquals(expected, users);
    }
    @Test @Disabled
    void readUserCredentialsDoubleUser(){
        //arrange
        String path = "test/test Data/testUserData3";
        Map<String,String> expected = new HashMap<String,String>();
        expected.put("user1","pass1");
        //act
        Map<String,String> users = FileIO.readUserCredentials(path);
        //assert
        assertEquals(expected, users);
    }


    @Test @Disabled
    void saveCredentials(){
        //arrange
        String path = "test/test Data/testUserData4";
        String pathExpected = ("test/test Data/testUserData4Expected");
        Map<String,String> expected = FileIO.readUserCredentials(pathExpected);
        //act
        FileIO.saveCredentials("user1","pass1",path);
        Map<String,String> users = FileIO.readUserCredentials(path);
        //assert
        assertEquals(expected, users);
    }
    @Test @Disabled
    void saveCredentialsDoubleUser(){
        //arrange
        String path = "test/test Data/testUserData5";
        String pathExpected = ("test/test Data/testUserData5Expected");
        Map<String,String> expected = FileIO.readUserCredentials(pathExpected);
        //act
        FileIO.saveCredentials("user1","pass1",path);
        FileIO.saveCredentials("user1","pass1",path);
        Map<String,String> users = FileIO.readUserCredentials(path);
        //assert
        assertTrue(expected.equals(users));
    }
    @Test @Disabled
    void saveCredentialsDoubleUsername(){
        //arrange
        String path = "test/test Data/testUserData6";
        String pathExpected = ("test/test Data/testUserDate6Expected");
        Map<String,String> expected = FileIO.readUserCredentials(pathExpected);
        //act
        FileIO.saveCredentials("user1","pass1",path);
        FileIO.saveCredentials("user1","pass2",path);
        Map<String,String> users = FileIO.readUserCredentials(path);
        //assert
        assertNotEquals(expected, users);
    }
    @Test
    void readMovieMedia (){
        // Arrange
        String moviePath = "data/movies";

        // Act
        Set<Media> movieResult = FileIO.readMedia(moviePath);

        // Assert
        assertTrue(movieResult.stream().anyMatch(
                x -> x.getTitle().equalsIgnoreCase("Yankee Doodle Dandy")
                && x.getReleaseYear()[0] == 1942
                && x.getCategories().stream().anyMatch(y -> y == Categories.BIOGRAPHY)
                && x.getCategories().stream().anyMatch(y -> y == Categories.DRAMA)
                && x.getCategories().stream().anyMatch(y -> y == Categories.MUSICAL)
                && x.getRating() == 7.7f
        ));
    }

    @Test @Disabled
    void readSeriesMedia (){
        // Arrange
        String seriesPath = "data/series";

        // Act
        Set<Media> seriesResult = FileIO.readMedia(seriesPath);

        // Assert
        /*
        assertTrue(seriesResult.stream().anyMatch(
                x -> x.getTitle().equalsIgnoreCase("Dexter")
                && x.getReleaseYear()[0] == 2006
                && x.getReleaseYear()[1] == 2013
                && x.getCategories().stream().anyMatch(y -> y == Categories.CRIME)
                && x.getCategories().stream().anyMatch(y -> y == Categories.DRAMA)
                && x.getCategories().stream().anyMatch(y -> y == Categories.MYSTERY)
                && x.getRating() == 8.7f
        ));
        */
    }
}