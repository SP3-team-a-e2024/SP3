package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextUI {
    private static Scanner scan = new Scanner(System.in);

    private TextUI(){};

    public static void displayMsg(String msg){
        System.out.println(msg);
    } // prompts message which will display a message

    public static boolean promptBinary(String msg){
        String input = promptText(msg);
        if(input.equalsIgnoreCase("Y")){
            return true;
        }
        else if(input.equalsIgnoreCase("N")){
            return false;
        }
        return promptBinary(msg);
    } // Gives the user an option to either press y to continue or n to return to message

    public static int promptNumeric(String msg) {
        System.out.println(msg);
        String input = scan.nextLine();
        int number;

        try {
            number = Integer.parseInt(input);
        }
        catch(NumberFormatException e){
            displayMsg("Please type a number");
            number = promptNumeric(msg);
        }
        return number;
    } // Gives the user an option to press an integer to move forward which returns a number

    public static String promptText(String msg){
        System.out.println(msg);
        return scan.nextLine();
    }

    public static List<String> promptChoice(List<String> options, int limit, String msg){
        List<String> choices = new ArrayList<>();
        displayList(options, msg);

        while(choices.size() < limit){
            int choice = promptNumeric("");

            if (choice > 0 && choice <= options.size()) {
                choices.add(options.get(choice-1));
            }
        }
        return choices;
    }   // - The `displayList()` function is used to present options to the user.
        // -The `promptNumeric()` function is used to capture numeric input from the user.
        // -This method doesn't prevent selecting the same option multiple times.
        //- User choices are one-indexed, i.e., selecting `1` corresponds to the first item in the options list.

    public static void displayList(List<String> options, String msg){
        System.out.println();
        System.out.println(msg);
        System.out.println();

        int i = 1;

        for (String option : options) {
            System.out.println(i+": "+option);
            i++;
        }
    }   // The method prints the provided message.
        // It then iterates through the list, printing each option with an incremental index starting from 1.


    public static void setScanner(Scanner scanner) {
        scan = scanner;
    }
}