package Main;//bare for at fjerne compiller fejl
import media.Media;
import user.User;
import util.TextUI;

import java.util.ArrayList;
import java.util.HashSet;

import java.util.List;
import java.util.Set;

public class StreamingService {

    private StartMenu startMenu;
    //hashset is not certain
    private Set<Media> media;
    private User currentUser;



    public void StreamingService() {
        Set<Media> media = new HashSet<Media>();
        startMenu = new StartMenu();
        setup();

    }


    public void searchMovie(){
            }

    public void searchCategory(){

    }

    private void displayMenu(){
        TextUI.displayMsg("Welcome to notflix");
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
