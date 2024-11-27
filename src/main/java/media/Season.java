package media;

import java.util.HashSet;
import java.util.Set;


public class Season{
    Set <Episode> episodes = new HashSet<>();
    int seasonNumber;

    public Season(int seasonNumber, int episodes) {
        for (int i = 0; i < episodes; i++) {
            this.episodes.add(new Episode(i));
        }
        this.seasonNumber = seasonNumber;
    }

    public Set<Episode> getEpisodes() {
        return episodes;
    }
    public int getSeasonNumber() {
        return seasonNumber;
    }
}
