package media;

import Main.Playable;
import util.TextUI;

public class Episode implements Playable {
    //used to store what episode this is
    private int episodeNumber;

    //constructor
    public Episode(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    @Override
    public void playMedia() {
        TextUI.displayMsg("Now playing Episode: '" + this.getEpisodeNumber() + "'");
    }

    //getter for value episodeNumber
    public int getEpisodeNumber() {
        return episodeNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Episode)) {
            return false;
        }
        Episode other = (Episode) o;
        return this.episodeNumber == other.episodeNumber;
    }
}
