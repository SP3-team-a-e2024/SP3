package Main;//bare for at fjerne compiller fejl
import enums.Categories;
import media.Media;
import user.User;
import util.FileIO;
import util.TextUI;

import java.util.*;

public class StreamingService {
    private Set<Media> media;
    private StartMenu startMenu;
    //hashset is not certain

    private User currentUser;
    public StreamingService() {
        this.media = new HashSet<Media>();
        this.startMenu = new StartMenu();
        setup();

    }


    public Set<Media> searchMedia(){
        TextUI.displayMsg("Please enter the title you wish to search, (or press x if you wont search for a movie): "); // prompts a message for the user

        String mediaName = TextUI.promptText("Search for a title: ");
        Set<Media> result = new HashSet<>(); // This is being used to return a value of our search of a movie or a series

        if(mediaName.equalsIgnoreCase("x")){
            TextUI.displayMsg("You decided not to search, closing searching... ");
            displayMenu();
            return result;
        }

            for (Media m : media) {
                if(m.getTitle().contains(mediaName)) {
                    result.add(m);
                }
            }
            TextUI.displayMsg(mediaName + " found, enjoy!");

            if(result.isEmpty()){
                TextUI.displayMsg(mediaName + " not found, try again!");
                return searchMedia();
            }
        return result;
    }   //  This method prompts the user to enter the title of a movie or series they want to search for.
        // The user can also exit the search process by entering 'x'.


    public Set<Media> searchCategory(){
        TextUI.displayMsg("Please enter the category you wish to search, (or press x if you wont search for a category): ");

        String categoryName = TextUI.promptText("Search for a category: ");
        Set<Media> result = new HashSet<>();

        if(categoryName.equalsIgnoreCase("x")){
            TextUI.displayMsg("You decided not to search, closing searching... ");
            return result;
        }

        try {
            Categories.valueOf(categoryName.toUpperCase());
            TextUI.displayMsg(categoryName + " found, you can watch these movies and series: ");

            for (Media m : media) {
                var category = m.getCategories();
                boolean mybool = category.contains(categoryName);
                if(m.getCategories().contains(categoryName)) {
                    result.add(m);
                }
            }
        }

        catch (IllegalArgumentException e) {
            TextUI.displayMsg(categoryName + " not found, try again: ");
            return searchCategory();
        }

        return result;
    }   // Prompt the user to enter a category name or to exit.
        // If 'x' is entered, terminate the search and return an empty result.
        // Attempt to match the entered category to a predefined enum (`Categories`).
        // If found, iterate through the media list and add matching items to the result set.
        // If not found, handle the exception and prompt the user to search again.

    private void displayMenu(){
        List<String> options = new ArrayList();
        options.add("Search movie");
        options.add("Search categories");
        options.add("See previous movies watched");
        options.add("See saved movies");
        options = TextUI.promptChoice(options,1,"What do you want to do");
        switch (options.get(0)) {
            case "Search movie":
                searchMedia();
                break;
            case "Search categories":
                searchCategory();
                break;
            case "See previous movies watched":
                //missing function. in user?
                break;
            case "See saved movies":
                //missing function. in user?
                break;
        }
    }   // Displays a welcome message to the user.
        // Defines a list of options that the user can choose from.
        //Prompts the user to choose one option from the list.
        // Uses a `switch` statement to handle the user's selected option and executes the appropriate action.

    private void setup(){
        //if there is no user logged in, it will go to the login page
        if (currentUser == null){
            currentUser = startMenu.loginMenuLogic();
            //if something somehow goes wrong it will double check that there is a user
            setup();
            return;
        }
        //if there is a user logged in it will start the menu
        else{
            loadMedia();
            //todo: load users watched and saved movies
            displayMenu();
        }
    }

    private void loadMedia(){
        media.addAll(FileIO.readMedia("data/movies"));
        media.addAll(FileIO.readMedia("data/series"));
            media.addAll(FileIO.readMedia("data/movies"));
            media.addAll(FileIO.readMedia("data/series"));
    }
}

