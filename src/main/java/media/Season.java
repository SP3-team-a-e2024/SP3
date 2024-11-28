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
    public Season(int seasonNumber, Set<Episode> episodes) {
        this.seasonNumber = seasonNumber;
        this.episodes = episodes;
    }

    public Set<Episode> getEpisodes() {
        return episodes;
    }
    public void addEpisodes(Set<Episode> episodes) {
        this.episodes.addAll(episodes);
    }
    public int getSeasonNumber() {
        return seasonNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Season)) {
            return false;
        }
        Season other = (Season) o;
        boolean episodesEqual = true;
        for (Episode episode : episodes) {
            for (Episode otherEpisode : other.episodes) {
                if (episode.getEpisodeNumber() == otherEpisode.getEpisodeNumber()) {
                    episodesEqual = false;
                }
            }
        }
        boolean seasonNumberEqual = seasonNumber == other.seasonNumber;
        return episodesEqual && seasonNumberEqual;
    }
}
