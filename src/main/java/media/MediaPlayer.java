package media;

import Main.Playable;
import user.User;
import util.MediaComparator;
import util.TextUI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MediaPlayer {
    private static User user;
    private static Media media;
    private static int season;
    private static int episode;

    private MediaPlayer() {}

    public static void playerStrategy(Media media, User user) {
        setMedia(media);
        setUser(user);

        if (media instanceof Movie movie) {
            displayMediaOptions(movie);
        }
        else if (media instanceof Series series) {
            displaySeasonOptions(series);
        }
    }

    private static Media getMedia() {
        return media;
    }

    private static void setMedia(Media media) {
        MediaPlayer.media = media;
    }

    private static User getUser() {
        return user;
    }

    private static void setUser(User user) {
        MediaPlayer.user = user;
    }

    private static int getSeason() {
        return season;
    }

    private static void setSeason(int season) {
        MediaPlayer.season = season;
    }

    private static int getEpisode() {
        return episode;
    }

    private static void setEpisode(int episode) {
        MediaPlayer.episode = episode;
    }

    private static void play(Playable media) {
        media.playMedia();
        getUser().addWatchedMedia(mapEpisodeToMedia(getMedia()));
    }
    private static void save(Playable media) {
        getUser().addSavedMedia(mapEpisodeToMedia(getMedia()));

    }

    private static void displaySeasonOptions(Series series) {
        List<String> options = new ArrayList<>();

        for (Season season : series.getSeasons()) {
            options.add("Season " + season.getSeasonNumber());
        }
        options.sort(new MediaComparator());
        options.add("Cancel");
        options = TextUI.promptChoice(options, 1, "Which season do you want to watch?");
        String userInput = options.get(0);

        if (userInput.equals("Cancel")) {
            return;
        }


        for (Season season : series.getSeasons()) {
            if (season.getSeasonNumber() == userInputToInt(userInput)) {
                setSeason(userInputToInt(userInput));
                displayEpisodeOptions(season);
                return;
            }
        }
    }

    private static void displayEpisodeOptions(Season season) {
        List<String> options = new ArrayList<>();

        for (Episode episode : season.getEpisodes()) {
            options.add("Episode " + episode.getEpisodeNumber());
        }
        options.sort(new MediaComparator());
        options.add("Cancel");
        options = TextUI.promptChoice(options, 1, "Which episode do you want to watch?");
        String userInput = options.get(0);

        if (userInput.equals("Cancel")) {
            return;
        }

        for (Episode episode : season.getEpisodes()) {
            if (episode.getEpisodeNumber() == userInputToInt(userInput)) {
                setEpisode(userInputToInt(userInput));
                displayMediaOptions(episode);
                return;
            }
        }
    }

    private static void displayMediaOptions(Playable media) {
        List<String> options = new ArrayList<>();
        options.add("Play");
        if (media instanceof Movie) {
            options.add("Save movie");
        }
        else if (media instanceof Series) {
            options.add("Save series");
        }

        options.add("Cancel");
        options = TextUI.promptChoice(options, 1, "What do you want to do?");
        String userInput = options.get(0);

        switch (userInput) {
            case "Play":
                play(media);
                break;
            case "Save movie":
            case "Save series":
                save(media);
                break;
            case "Cancel":
                break;
        }
    }

    private static int userInputToInt(String userInput) {
        String[] input = userInput.split(" ");
        return Integer.parseInt(input[1]);
    }

    private static Media mapEpisodeToMedia(Media media) {
        if (media instanceof Movie movie) {
            return movie;
        }

        Set<Episode> episode = new HashSet<>();
        episode.add(new Episode(getEpisode()));

        Set<Season> season = new HashSet<>();
        season.add(new Season(getSeason(), episode));

        return new Series(
                media.getTitle(),
                media.getRating(),
                media.getReleaseYear(),
                media.getCategories(),
                season
        );
    }
}
