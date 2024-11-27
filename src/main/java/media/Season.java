package media;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Season{
    Set <Episode> episodes = new HashSet<>();
    int seasonNumber;

    public Season(int seasonNumber, int episodes) {
        for (int i = 0; i < episodes; i++) {
            this.episodes.add(new Episode(i+1));
        }
        this.seasonNumber = seasonNumber;
    }
    public Season(int seasonNumber, List<Integer> episodes) {
        this.seasonNumber = seasonNumber;
        for (int i = 0; i < episodes.size(); i++) {
            this.episodes.add(new Episode(episodes.get(i)));
        }
    }

    public Set<Episode> getEpisodes() {
        return episodes;
    }
    public int getSeasonNumber() {
        return seasonNumber;
    }
}
