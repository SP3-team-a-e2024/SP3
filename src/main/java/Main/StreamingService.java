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
        TextUI.displayMsg("Please enter the title you wish to search, (or press x if you wont search for a movie): ");

        String mediaName = TextUI.promptText("Search for a title: ");
        Set<Media> result = new HashSet<>();

        if(mediaName.equalsIgnoreCase("x")){
            TextUI.displayMsg("You decided not to search, closing searching... ");
            displayMenu();
            return result;
        }

            for (Media m : media) {
                if(m.getTitle().contains(mediaName)) {
                    result.add(m);
                    TextUI.displayMsg(mediaName + " found, enjoy!");
                }
            }
            if(result.isEmpty()){
                TextUI.displayMsg(mediaName + " not found, try again!");
                return searchMedia();
            }
        return result;
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
            for (Media m : media) {
                if (m.getCategories().contains(Categories.valueOf(categoryName.toUpperCase()))) {
                    result.add(m);
                }
            }

            TextUI.displayMsg(categoryName + " found, you can watch these movies and series: ");
            return result;
        }
        catch (Exception e) {
                TextUI.displayMsg(categoryName + " not found, try again: ");
                return searchCategory();
        }
    }

    private void displayMenu(){
        TextUI.displayMsg("Welcome to NotFlix");
        List<String> options = new ArrayList();
        options.add("Search movie");
        options.add("Search categories");
        options.add("See previous movies watched");
        options.add("See saved movies");
        options = TextUI.promptChoice(options,1,"What do you want to do");
        Set<Media> result = new HashSet<>();
                switch (options.get(0)) {
            case "Search movie":
                result = searchMedia();
                break;
            case "Search categories":
                result = searchCategory();
                break;
            case "See previous movies watched":
                //missing function. in user?
                break;
            case "See saved movies":
                //missing function. in user?
                break;
        }
        displayTitles(result);
    }

    private void displayTitles(Set<Media> media){
        for(Media m : media){
            TextUI.displayMsg(m.getTitle());
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
            media.addAll(FileIO.readMedia("data/movies"));
            media.addAll(FileIO.readMedia("data/series"));
            displayMenu();
        }

    }

    private void loadMedia(){}

}
