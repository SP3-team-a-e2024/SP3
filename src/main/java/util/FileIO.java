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

    public static Map<String, String> readUserCredentials(String path) {
        Map<String, String> data = new HashMap<>();
        File file = new File(path);
        try {
            Scanner scan = new Scanner(file);
            scan.nextLine();//skip header

            while (scan.hasNextLine()) {
                String line = scan.nextLine(); // "username ; password"
                String[] lineSplitter = line.split(";");
                data.put(lineSplitter[0].trim(), lineSplitter[1].trim());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        }
        return data;
    }


    public static void saveCredentials(String username, String password, String path) {

        try {
            File file = new File(path);

            Map<String, String> credentials = readUserCredentials(path);
            credentials.put(username, password);
            FileWriter writer = new FileWriter(path);
            for (Map.Entry<String, String> entry : credentials.entrySet()) {
                writer.write(entry.getKey() + ";" + entry.getValue() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("something went wrong when writing to file");
        }
    }

    public static Set<Media> readMedia(String path) {
        Set<Media> mediaSet = new TreeSet<>();
        File file = new File(path);
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] lineSplitter = line.split(";");
                String[] categoriesSplitter = (lineSplitter[2]).split(",");
                Set<Categories> enumCategories = mapCategoriesToEnum(categoriesSplitter);

                if (lineSplitter.length > 4) {
                    String[] Seasons = (lineSplitter[4]).split(",");
                    for (String season : Seasons) {
                        
                    }
                    mediaSet.add(new Series(lineSplitter[0], Float.parseFloat(lineSplitter[3].trim()), Integer.parseInt(lineSplitter[1].trim()), enumCategories));

                } else {
                    mediaSet.add(new Movie(lineSplitter[0], Float.parseFloat(lineSplitter[3].trim()), Integer.parseInt(lineSplitter[1].trim()), enumCategories));
                }
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("Media file not found: " + path);
        }
        return mediaSet;
    }


    private static Set<Categories> mapCategoriesToEnum(String[] categories){

        Set<Categories> enumSet = new HashSet<>();
        for (String category : categories) {
            enumSet.add(Categories.valueOf(category.toUpperCase()));
        }
        return enumSet;
    }
}
