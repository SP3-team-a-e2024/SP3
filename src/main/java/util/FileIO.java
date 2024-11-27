package util;

import enums.Categories;
import media.Media;
import media.Movie;
import media.Series;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FileIO {
    //constructor
    private FileIO(){};

    //used for getting a map of all user credentials
    public static Map<String, String> readUserCredentials(String path) {
        //creates an empty hashmap
        Map<String, String> data = new HashMap<>();
        //gets the file at the parameterized path
        File file = new File(path);
        //as it is file related, try catch
        try {
            //creates scanner
            Scanner scan = new Scanner(file);
            scan.nextLine();//skips header

            while (scan.hasNextLine()) {
                String line = scan.nextLine(); // "username ; password"
                //splits the line with regex ;
                String[] lineSplitter = line.split(";");
                //puts the split line into data formatted after what a user.
                data.put(lineSplitter[0].trim(), lineSplitter[1].trim());
            }
        }
        //if the file is not found
        catch (FileNotFoundException e) {
            System.out.println("File was not found while reading user credentials");
        }
        return data;
    }

    //used for saving a user to the credentials
    //this will replace a user if they already exists with a new one
    //remember to always check if there is a user already existing before usage
    public static void saveCredentials(String username, String password, String path) {
        //as it is file related, try catch
        try {
            //gets all users
            Map<String, String> credentials = readUserCredentials(path);
            //adds the new user to the map
            credentials.put(username, password);
            //makes a filewriter
            FileWriter writer = new FileWriter(path);
            //writes the header
            writer.write("username ; password\n");
            //writes each entry in the map in same format as header
            for (Map.Entry<String, String> entry : credentials.entrySet()) {
                writer.write(entry.getKey() + " ; " + entry.getValue() + "\n");
            }
            //finished writing
            writer.close();
            writer.flush();

        }
        //if the file is not found
        catch (FileNotFoundException e) {
            System.out.println("File was not found while saving credentials");
        }
        //anything else
        catch (IOException e) {
            System.out.println("something went wrong when writing to file");
        }
    }

    public static Set<Media> readMedia(String path) {
        //creates a set for all media
        Set<Media> mediaSet = new HashSet<>();
        //looks for the file
        File file = new File(path);
        try {
            //creates scanner
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                //scans a line with scanner
                String line = scan.nextLine();
                //splits the string for each segment of data
                String[] lineSplitter = line.split(";");
                //splits the string for categories and converts it into a set of enums
                String[] categoriesSplitter = (lineSplitter[2]).split(",");
                Set<Categories> enumCategories = mapCategoriesToEnum(categoriesSplitter);

                //if lineSplitter is longer than 4 splits it is a series
                if (lineSplitter.length > 4) {
                    //splits lineSplitter index 4 which is corresponding to seasons and episodes
                    //data is a temp storage array
                    String[] data = (lineSplitter[4]).split(",");

                    //creates 2 arraylists for each datatype
                    ArrayList<Integer> seasons = new ArrayList<>();
                    ArrayList<Integer> episodes = new ArrayList<>();

                    for (String d : data) {
                        //for each string, split it and add the first part to seasons and the 2nd to episodes
                        String [] temp = d.split("-");
                        seasons.add(Integer.parseInt(temp[0].trim()));
                        episodes.add(Integer.parseInt(temp[1].trim()));
                    }

                    //splits release year into multiple parts and makes an array the size of the amount of splits
                    data = (lineSplitter[1].split("-"));
                    int[] releaseYears = new int[data.length];
                    //goes through the the data and adds it to the array of release year if its not empty
                    for (int i = 0; i < data.length; i++) {
                        if (data[i].isBlank() || data[i].isEmpty()) continue;
                        //trims it and converts to a int
                        releaseYears[i] = Integer.parseInt(data[i].trim());
                    }
                    //makes a new series object and adds it to the mediaset
                    Media series = new Series(
                            lineSplitter[0], // Name
                            Float.parseFloat(lineSplitter[3].trim().replace(",",".")), // Rating
                            releaseYears, // Release year
                            enumCategories, // Categories
                            seasons, // Season no.
                            episodes // Episode no.
                    );
                    mediaSet.add(series);

                }
                else {
                    //splits release year into multiple parts and makes an array the size of the amount of splits
                    String[] data = (lineSplitter[1].split("-"));
                    int[] releaseYears = new int[data.length];
                    //goes through the the data and adds it to the array of release year if its not empty
                    for (int i = 0; i < data.length; i++) {
                        //trims it and converts to a int
                        releaseYears[i] = Integer.parseInt(data[i].trim());
                    }
                    //makes a new movie object and adds it to the mediaset
                    Media movie = new Movie(
                            lineSplitter[0], // name
                            Float.parseFloat(lineSplitter[3].trim().replace(",",".")), // rating
                            releaseYears, // release year
                            enumCategories // categories
                    );
                    mediaSet.add(movie);
                }
            }
            //scanner has now gone through all of it
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("Media file not found: " + path);
        }
        //returns all of it
        return mediaSet;
    }

    //used to map a string array onto a set of enums
    private static Set<Categories> mapCategoriesToEnum(String[] categories){
        //creates hashset for storing enums
        Set<Categories> enumSet = new HashSet<>();
        //for each string it will check if it matches with a existing enum
        for (String category : categories) {
            //gets reformatted into matching the Enums capitalization and other
            enumSet.add(Categories.valueOf(category.toUpperCase().trim().replace("-","_")));
        }
        return enumSet;
    }
}