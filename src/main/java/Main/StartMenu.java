package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import user.User;
import util.FileIO;
import util.TextUI;

public class StartMenu {


    public User loginMenuLogic(){
        //asks the user if they want to log in or sign-up
        List<String> options = new ArrayList();
        options.add("Log in");
        options.add("Sign up");
        options = TextUI.promptChoice(options,1,"Theres no user logged in");

        User currentUser = null;

        //depending on what they want to do it runs different functions for the login and sign-up function
        switch (options.get(0)) {
            case "Log in":
                currentUser = login();
                break;

            case "Sign up":
                signUp();
                break;
        }

        //if theres no user, it runs itself
        if (currentUser == null){
            return loginMenuLogic();
        }
        return currentUser;
    }

    //the function for logging a user in
    private User login() {
        {
            //gets the credentials for all users
            Map<String, String> users =  FileIO.readUserCredentials("data/credentials");
            //Asks the user for what their username and password is
            String username =  TextUI.promptText("Please enter your username: ");
            String password =  TextUI.promptText("Please enter your password: ");

            //checks if the username is a valid key in Map
            //then checks if that username key has the same password as entered
            if (users.containsKey(username)) {
                if (users.get(username).equals(password)) {
                    TextUI.displayMsg("You have successfully logged in. Welcome " + username + " to NotFlix");
                    //todo: make it able to get media
                    return new User(username, password);
                }
            }
            //error message for if user doesn't exist
            TextUI.displayMsg("Username or password is incorrect, please try again or Sign up");
            //goes back to the previous method
            return loginMenuLogic();
        }
    }

    private void signUp(){
        //gets the credentials for all users
        Map<String, String> users =  FileIO.readUserCredentials("data/credentials");
        //Asks the user for what their username and password is
        String username = TextUI.promptText("Please create a new username: ");
        String password = TextUI.promptText("Please create a new password: ");
        //invalidation checks
        //checks if there is a space at the beginning or end of the username or password
        if (username.trim() != username || password.trim() != password) {
            TextUI.displayMsg("Username and password is incorrect \n username and password can't contain spaces");
            signUp();
            return;
        }
        //checks if the username or password is empty
        else if (username == null || password == null || username.equals("") || password.equals("")) {
            TextUI.displayMsg("Username or password is empty, please try again");
            signUp();
            return;
        }
        //checks if the username or password is less than 4 characters long
        else if (username.length() < 4 || password.length() < 4) {
            TextUI.displayMsg("Username and password must contian at least 4 characters, please try again");
            signUp();
            return;
        }
        //checks if there is already a existing user with the same username
        if (users.containsKey(username)) {
            TextUI.displayMsg("Username already exists, please try again or please login");
            loginMenuLogic();
            return;
        }
        //saves the user which has passed the checks
        FileIO.saveCredentials(username, password, "data/credentials");
        TextUI.displayMsg("User created successfully. Welcome to NotFlix");
    }
}