package Main;

import java.util.ArrayList;
import java.util.List;
import user.User;
import util.TextUI;

public class StartMenu {

    public User loginMenuLogic(){
        List<String> options = new ArrayList();
        options.add("Log in");
        options.add("Sign up");
        options = TextUI.promptChoice(options,1,"Theres no user logged in");

        User currentUser = null;

        switch (options.get(0)) {
            case "Log in":
                currentUser = login();
                break;

            case "Sign up":
                signUp();
                break;
        }

        if (currentUser == null){
            return loginMenuLogic();
        }
        return currentUser;
    }


    private User login() {
        //dummy
        return null;
    }
    private void signUp(){
    }
}