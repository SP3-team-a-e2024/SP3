//bare for at fjerne compiller fejl
import java.util.HashSet;

import java.util.Set;

public class StreamingService {

    private StartMenu startMenu;
    //hashset is not certain
    private Set<Media> media = new HashSet<>();
    private User currentUser;
    //copied from monopoly
    private TextUI ui;
    private FileIO io;

    public void StreamingService() {
        //copied from monopoly
        this.ui = new TextUI();
        this.io = new FileReader();
    }

    //dummy, will be used to find a movie
    public void searchMovie(){}
    //dummy, will be used to find movies in a category
    public void searchCategory(){}

    private void displayMenu(){

    }

    //i assume it will get data for the Set of media? or running methods from the startmenu class?
    private void setup(){
        //
        // ikke sikker om placering
        // also this is fucking stupid way to do so
        // should be wrapped up in TextUi as a function
        if (currentUser == null){
            ui.displayMsg("Theres no user logged in");
            ui.displayMsg("1) log in");
            ui.displayMsg("2) sign up");
            int choice = ui.promptBinary("Choose an option");
            while (choice != 1 || choice != 2){
                choice = ui.promptBinary("please choose a valid option");
            }
            switch (choice){
                case 1:
                    startMenu.login();
                    break;
                case 2:
                    startMenu.signUp();
                    break;
            }
            setup();
            return;
        }
        else{
            ui.displayMsg("Welcome to notflix");
        }

    }

    private void loadMedia(){}

}
