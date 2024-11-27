package util;

import enums.Categories;
import media.Media;
import media.Movie;
import media.Series;
import user.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FileIO {

    private FileIO(){};

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
            writer.write("username ; password\n");
            for (Map.Entry<String, String> entry : credentials.entrySet()) {
                writer.write(entry.getKey() + " ; " + entry.getValue() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("something went wrong when writing to file");
        }
    }

    public static Set<Media> readMedia(String path) {
        Set<Media> mediaSet = new HashSet<>();
        File file = new File(path);
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] lineSplitter = line.split(";");
                String[] categoriesSplitter = (lineSplitter[2]).split(",");
                Set<Categories> enumCategories = mapCategoriesToEnum(categoriesSplitter);

                if (lineSplitter.length > 4) {
                    String[] data = (lineSplitter[4]).split(",");
                    ArrayList<Integer> seasons = new ArrayList<>();
                    ArrayList<Integer> episodes = new ArrayList<>();
                    for (String d : data) {
                        String [] temp = d.split("-");
                        seasons.add(Integer.parseInt(temp[0].trim()));
                        episodes.add(Integer.parseInt(temp[1].trim()));
                    }

                    data = (lineSplitter[1].split("-"));
                    int[] releaseYears = new int[data.length];
                    for (int i = 0; i < data.length; i++) {
                        if (data[i].isBlank() || data[i].isEmpty()) continue;
                        releaseYears[i] = Integer.parseInt(data[i].trim());
                    }
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
                    String[] data = (lineSplitter[1].split("-"));
                    int[] releaseYears = new int[data.length];
                    for (int i = 0; i < data.length; i++) {
                        releaseYears[i] = Integer.parseInt(data[i].trim());
                    }

                    Media movie = new Movie(
                            lineSplitter[0], // name
                            Float.parseFloat(lineSplitter[3].trim().replace(",",".")), // rating
                            releaseYears, // release year
                            enumCategories // categories
                    );
                    mediaSet.add(movie);
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
            enumSet.add(Categories.valueOf(category.toUpperCase().trim().replace("-","_")));
        }
        return enumSet;
    }

    



}
