package util;

import enums.Categories;
import media.Media;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.io.File;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FileIOTest {
    @Test
    void readUserCredentialsNullUsers(){
        //arrange
        String path = "test/test Data/testUserData";
        Map<String,String> expected = new HashMap<>();
        //act
        Map<String,String> users = FileIO.readUserCredentials(path);
        //assert
        assertEquals(expected, users);
    }

    @Test
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
    @Test
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


    @Test
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
    @Test
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
    @Test
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
    void readMedia (){
        // Arrange
        String moviePath = "data/movies";
        String seriesPath = "data/series";

        // Act
        Set<Media> movieResult = FileIO.readMedia(moviePath);
        Set<Media> seriesResult = FileIO.readMedia(seriesPath);

        // Assert
        /*
        assertTrue(movieResult.stream().anyMatch(x -> x.getName().equalsIgnoreCase("Yankee Doodle Dandy")));
        assertTrue(movieResult.stream().anyMatch(x -> x.getReleaseYear() == 1942));
        assertTrue(movieResult.stream().anyMatch(x -> x.getCategories().stream().anyMatch(y -> y == Categories.BIOGRAPHY)));
        assertTrue(movieResult.stream().anyMatch(x -> x.getCategories().stream().anyMatch(y -> y == Categories.DRAMA)));
        assertTrue(movieResult.stream().anyMatch(x -> x.getCategories().stream().anyMatch(y -> y == Categories.MUSICAL)));
        assertTrue(movieResult.stream().anyMatch(x -> x.getRating() == 7.7));

        assertTrue(seriesResult.stream().anyMatch(x -> x.getName().equalsIgnoreCase("Dexter")));
        assertTrue(seriesResult.stream().anyMatch(x -> x.getReleaseYear() == 2006)); // TODO: Also implement end releaseYear
        assertTrue(seriesResult.stream().anyMatch(x -> x.getCategories().stream().anyMatch(y -> y == Categories.CRIME)));
        assertTrue(seriesResult.stream().anyMatch(x -> x.getCategories().stream().anyMatch(y -> y == Categories.DRAMA)));
        assertTrue(seriesResult.stream().anyMatch(x -> x.getCategories().stream().anyMatch(y -> y == Categories.MYSTERY)));
        assertTrue(seriesResult.stream().anyMatch(x -> x.getRating() == 8.7));
        */
    }
}