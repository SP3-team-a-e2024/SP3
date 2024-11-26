package user;

import media.Media;
import util.TextUI;
import java.util.HashSet;
import java.util.Set;

public class User {
    private String username;
    private String password;
    private Set<Media> watchedMedia;
    private Set<Media> savedMedia;

    public User(String username, String password) {
        setUsername(username);
        setPassword(password);
        this.watchedMedia = new HashSet<>();
        this.savedMedia = new HashSet<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username == null) return;
        else if(username.isEmpty() || username.isBlank()) {
            System.out.println("Username cannot be empty or blank");
            return;
        }
        else if (username.length() < 2) {
            System.out.println("Username must be at least 2 characters");
            return;
        }
        this.username = username;
    }   // The validation ensures that the `username` is non-null, non-empty, and of sufficient length.
        // The validation messages are printed to the console to notify the user of any invalid input.
        // The use of `isEmpty()` and `isBlank()` ensures that usernames containing only spaces are also considered invalid.

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null) return;
        else if(password.isEmpty() || password.isBlank()) {
            System.out.println("Password cannot be empty or blank");
            return;
        }
        else if (password.length() < 2) {
            System.out.println("Password must be at least 2 characters");
            return;
        }
        this.password = password;
    }   // The validation ensures that the `password` is non-null, non-empty, and of a minimal acceptable length.
        // The error messages are printed to the console to notify the user of invalid inputs.
        // The use of `isEmpty()` and `isBlank()` ensures that passwords containing only whitespace are considered invalid.


    public Set<Media> getWatchedMedia(){
        return watchedMedia;
    }

    public void addWatchedMedia(Media media){
        watchedMedia.add(media);
    }

    public Set<Media> getSavedMedia(){
        return savedMedia;
    }

    public boolean addSavedMedia(Media media) {
        if (savedMedia.contains(media)) {
            TextUI.displayMsg(media.getTitle()+ " is already saved");
            return false;
        } else {
            savedMedia.add(media);
            TextUI.displayMsg(media.getTitle()+ " has been saved");
        }
        return true;
    }

    public void removeSavedMedia(Media media){
        savedMedia.remove(media);
        System.out.println("You just removed " + media + " from the list");
    }

    public void setWatchedMedia(Set<Media> watchedMedia) {
        this.watchedMedia = watchedMedia;
    }

    public void setSavedMedia(Set<Media> savedMedia) {
        this.savedMedia = savedMedia;
    }
}
