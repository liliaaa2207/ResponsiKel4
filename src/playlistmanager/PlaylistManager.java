package playlistmanager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistManager {
    private final ArrayList<Song> playlist = new ArrayList<>();

    public void addSong(Song song) {
        playlist.add(song);
        System.out.println("✅ Lagu ditambahkan!");
    }

    public void displaySongs() {
        if (playlist.isEmpty()) {
            System.out.println("⚠ Playlist kosong.");
            return;
        }
        System.out.println("\n===== DAFTAR LAGU =====");
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ". " + playlist.get(i));
        }
    }

    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Song s : playlist) {
                writer.write(s.getTitle() + "," + s.getArtist() + "," + s.getDuration() + "," + s.getGenre());
                writer.newLine();
            }
            System.out.println("💾 Playlist disimpan.");
        } catch (IOException e) {
            System.out.println("❌ Gagal menyimpan file.");
        }
    }

    public void loadFromFile(String filename) {
        playlist.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    String title = data[0];
                    String artist = data[1];
                    double duration = Double.parseDouble(data[2]);
                    String genre = data[3];

                    Song song;
                    switch (genre.toLowerCase()) {
                        case "pop": song = new PopSong(title, artist, duration); break;
                        case "rock": song = new RockSong(title, artist, duration); break;
                        case "jazz": song = new JazzSong(title, artist, duration); break;
                        default: song = new Song(title, artist, duration);
                    }
                    playlist.add(song);
                }
            }
            System.out.println("📂 Playlist dimuat.");
        } catch (IOException e) {
            System.out.println("❌ Gagal membaca file.");
        }
    }

    public List<Song> getSongs() {
        return playlist;
    }
}