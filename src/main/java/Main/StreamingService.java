package Main;//bare for at fjerne compiller fejl
import enums.MovieCategories;
import enums.SeriesCategories;
import media.Media;
import user.User;
import util.TextUI;

import java.util.*;

public class StreamingService {

    private StartMenu startMenu;
    //hashset is not certain
    private Set<Media> media;
    private User currentUser;

    public StreamingService() {
        Set<Media> media = new HashSet<Media>();
        startMenu = new StartMenu();
        setup();
    }


    public void searchMovie(){
    }

    public Set<Media> searchCategory(){
        TextUI.displayMsg("Please enter the category you wish to search, (or press x if you wont search for a category): ");

        String categoryName = TextUI.promptText("Search for a category: ");
        Set<Media> result = new HashSet<>();

        if(categoryName.equalsIgnoreCase("x")){
            TextUI.displayMsg("You decided not to search, closing searching... ");
            return result;
        }

        try {
            SeriesCategories.valueOf(categoryName.toUpperCase());
            MovieCategories.valueOf(categoryName.toUpperCase());
            TextUI.displayMsg(categoryName + " found, you can watch these movies and series: ");

            for (Media m : media) {
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
    }

    private void displayMenu(){
        TextUI.displayMsg("Welcome to NotFlix");
        List<String> options = new ArrayList();
        options.add("Search movie");
        options.add("Search categories");
        options.add("See previous movies watched");
        options.add("See saved movies");
        options = TextUI.promptChoice(options,1,"What do you want to do");
        switch (options.get(0)) {
            case "Search movie":
                searchMovie();
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

    }

    private void setup(){
        //if theres no user logged in, it will go to the login page
        if (currentUser == null){
            currentUser = startMenu.loginMenuLogic();
            //if something somehow goes wrong it will double check that there is a user
            setup();
            return;
        }
        //if there is a user logged in it will start the menu
        else{
            displayMenu();
        }

    }

    private void loadMedia(){}

}
