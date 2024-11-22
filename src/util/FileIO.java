package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FileIO {

        public static HashMap<String, String> readUserCredentials(String path) {
            HashMap<String, String> data = new HashMap<String, String>();
            File file = new File(path);
            try {
                Scanner scan = new Scanner(file);
                scan.nextLine();//skip header

                while (scan.hasNextLine()) {
                    String line = scan.nextLine(); // "tess, 40000"
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

               HashMap<String , String> credentials = readUserCredentials(path);
               credentials.put(username,  password);
                FileWriter writer = new FileWriter(path);
                for(Map.Entry<String , String> entry : credentials.entrySet()) {
                    writer.write(entry.getKey() + ";" + entry.getValue()+ "\n");
                }
                writer.close();
            } catch (IOException e) {
                System.out.println("something went wrong when writing to file");
            }
        }

            public static List<String[]> readMedia(String path) {
                List<String[]> mediaList = new ArrayList<>();
                File file = new File(path);
                try {
                    Scanner scan = new Scanner(file);
                    if (scan.hasNextLine()) {
                        scan.nextLine(); // Spring headeren over
                    }
                    while (scan.hasNextLine()) {
                        String line = scan.nextLine();
                        String[] lineSplitter = line.split(";");
                        mediaList.add(lineSplitter); // Tilføj hver linje som en array af strings
                    }
                    scan.close();
                } catch (FileNotFoundException e) {
                    System.out.println("Media file not found: " + path);
                }
                return mediaList;
            }

}
