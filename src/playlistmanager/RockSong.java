package playlistmanager;

public class RockSong extends Song {
    public RockSong(String title, String artist, double duration) {
        super(title, artist, duration);
    }

    @Override
    public String getGenre() {
        return "Rock";
    }
}