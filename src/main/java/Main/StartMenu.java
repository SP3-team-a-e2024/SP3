package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import user.User;
import util.FileIO;
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
        {
            Map<String, String> users =  FileIO.readUserCredentials("data/credentials");
            String username =  TextUI.promptText("Please enter your username: ");
            username  = username.trim();
            String password =  TextUI.promptText("Please enter your password: ");
            password = password.trim();
            if(username == null || password == null || username.equals("") || password.equals("")){
                TextUI.displayMsg("Username or password is empty, please try again");
                return login();
            }
            else if(username.length() < 4 || password.length() < 4) {
                TextUI.displayMsg("Username and password are not valid, \n username and password must be at least 4 characters");
                return login();
            }
            if (users.containsKey(username)) {
                if (users.get(username).equals(password)) {
                    TextUI.displayMsg("You have successfully logged in. Welcome " + username + " to NotFlix");
                    return new User(username, password);
                }
            }
            TextUI.displayMsg("Username or password is incorrect, please try again or Sign up");
            return loginMenuLogic();
        }
    }

    private void signUp(){
        Map<String, String> users =  FileIO.readUserCredentials("data/credentials");
        String username = TextUI.promptText("Please create a new username: ");
        username = username.trim();
        String password = TextUI.promptText("Please create a new password: ");
        password = password.trim();
        if (username.trim() != username || password.trim() != password) {
            TextUI.displayMsg("Username and password is incorrect \n username and password can't contain spaces");
            signUp();
            return;
        } else if (username == null || password == null || username.equals("") || password.equals("")) {
            TextUI.displayMsg("Username or password is empty, please try again");
            signUp();
            return;
        } else if (username.length() < 4 || password.length() < 4) {
            TextUI.displayMsg("Username and password must contian at least 4 characters, please try again");
            signUp();
            return;
        }

        if (users.containsKey(username)) {
            TextUI.displayMsg("Username already exists, please try again or please login");
            loginMenuLogic();
            return;
        }
        FileIO.saveCredentials(username, password, "data/credentials");
        TextUI.displayMsg("User created successfully. Welcome to NotFlix");
        login();
    }
}