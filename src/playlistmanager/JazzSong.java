package playlistmanager;

public class JazzSong extends Song {
    public JazzSong(String title, String artist, double duration) {
        super(title, artist, duration);
    }

    @Override
    public String getGenre() {
        return "Jazz";
    }
}