package media;

import java.util.HashSet;
import java.util.Set;


public class Season{
    Set <Episode> episodes = new HashSet<>();

    public Season(int episodes) {
        for (int i = 0; i < episodes; i++) {
            this.episodes.add(new Episode(i));
        }
    } // Constructor for season to calculate the amount of episodes in the season
}
