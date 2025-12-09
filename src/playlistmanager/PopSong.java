package playlistmanager;

public class PopSong extends Song {
    public PopSong(String title, String artist, double duration) {
        super(title, artist, duration);
    }

    @Override
    public String getGenre() {
        return "Pop";
    }
}