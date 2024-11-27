package Main;//bare for at fjerne compiller fejl
import enums.Categories;
import media.Media;
import user.User;
import util.FileIO;
import util.TextUI;

import java.util.*;

import static java.lang.System.exit;

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


    public Set<Media> searchMedia() {
        TextUI.displayMsg("Please enter the title you wish to search, (or press x if you wont search for a movie): ");

        String mediaName = TextUI.promptText("Search for a title: ");
        Set<Media> result = new HashSet<>(); // This is being used to return a value of our search of a movie or a series

        if (mediaName.equalsIgnoreCase("x")) {
            TextUI.displayMsg("You decided not to search, closing searching... ");
            return result;
        }

        for (Media m : media) {
            if (m.getTitle().contains(mediaName)) {
                result.add(m);
            }
        }

        if (result.isEmpty()) {
            TextUI.displayMsg(mediaName + " not found, try again!");
            return searchMedia();
        }
        return result;
    }   //  This method prompts the user to enter the title of a movie or series they want to search for.
    // The user can also exit the search process by entering 'x'.


    public Set<Media> searchCategory() {
        TextUI.displayMsg("Please enter the category you wish to search, (or press x if you wont search for a category): ");

        String categoryName = TextUI.promptText("Search for a category: ");
        Set<Media> result = new HashSet<>();

        if (categoryName.equalsIgnoreCase("x")) {
            TextUI.displayMsg("You decided not to search, closing searching... ");
            return result;
        }
        try {
            for (Media m : media) {
                if (m.getCategories().contains(Categories.valueOf(categoryName.toUpperCase()))) {
                    result.add(m);
                }
            }

            TextUI.displayMsg(categoryName + " found, you can watch these movies and series: ");
            return result;
        } catch (Exception e) {
            TextUI.displayMsg(categoryName + " not found, try again: ");
            return searchCategory();
        }
    }   // Prompt the user to enter a category name or to exit.
    // If 'x' is entered, terminate the search and return an empty result.
    // Attempt to match the entered category to a predefined enum (`Categories`).
    // If found, iterate through the media list and add matching items to the result set.
    // If not found, handle the exception and prompt the user to search again.

    private void displayMenu() {
        List<String> options = new ArrayList();
        options.add("Search media");
        options.add("Search categories");
        options.add("See previous media watched");
        options.add("See saved media");
        options.add("Exit");
        options = TextUI.promptChoice(options, 1, "What do you want to do");
        Set<Media> result = new HashSet<>();
        switch (options.get(0)) {
            case "Search media":
                result = searchMedia();
                break;
            case "Search categories":
                result = searchCategory();
                break;
            case "See previous media watched":
                //missing function. in user?
                break;
            case "See saved media":
                //missing function. in user?
                break;
            case "Exit":
                exit(0);
                break;
        }
        displayTitles(result);
        displayMenu();
    }   // Displays a welcome message to the user.
    // Defines a list of options that the user can choose from.
    //Prompts the user to choose one option from the list.
    // Uses a `switch` statement to handle the user's selected option and executes the appropriate action.


    private void displayTitles(Set<Media> media) {
        for (Media m : media) {
            TextUI.displayMsg(m.getTitle());
        }
    }

    private void setup() {
        //if there is no user logged in, it will go to the login page
        if (currentUser == null) {
            currentUser = startMenu.loginMenuLogic();
            //if something somehow goes wrong it will double check that there is a user
            setup();
            return;
        }
        //if there is a user logged in it will start the menu
        else {
            loadMedia();
            //todo: load users watched and saved movies
            displayMenu();
        }
    }

    private void loadMedia() {
        media.addAll(FileIO.readMedia("data/movies"));
        media.addAll(FileIO.readMedia("data/series"));
    }
}