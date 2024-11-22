import util.TextUI;

import java.util.ArrayList;
import java.util.List;

public class StartMenu {

    public User loginMenuLogic(){
        List<String> options = new ArrayList();
        options.add("Log in");
        options.add("Sign up");
        options = TextUI.promptChoice(options,1,"Theres no user logged in");

        User currentUser = new User();

        switch (options.getFirst()) {
            case "log in":
                currentUser = login();
                break;
            case "sign up":
                signUp();
                break;
        }

        if (User = null){
            return loginMenuLogic();
        }
        return User;
    }


    private User login() {
        //dummy
        return new user();
    }
    private void signUp(){
    }
}