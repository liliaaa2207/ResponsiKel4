package playlistmanager;

import java.util.Scanner;

public class MusicPlaylistManager {

    static class PlayThread extends Thread {
        private final Song song;
        private boolean running = true;

        public PlayThread(Song song) {
            this.song = song;
        }

        public void stopPlaying() {
            running = false;
        }

        @Override
        public void run() {
            System.out.println("\n▶ Memutar: " + song.getTitle() + " - " + song.getArtist());
            int dur = (int) song.getDuration();
            for (int i = 1; i <= dur && running; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println("   Waktu: " + i + "/" + dur + " detik");
                } catch (InterruptedException e) { return; }
            }
            if (running) System.out.println("✔ Lagu selesai\n");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PlaylistManager manager = new PlaylistManager();
        PlayThread playing = null;
        int choice;

        do {
            System.out.println("\n=== MENU MUSIC PLAYLIST MANAGER ===");
            System.out.println("1. Tambah Lagu");
            System.out.println("2. Tampilkan Lagu");
            System.out.println("3. Simpan ke File");
            System.out.println("4. Muat dari File");
            System.out.println("5. Putar Lagu");
            System.out.println("6. Stop Lagu");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            choice = input.nextInt(); input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Judul: ");
                    String title = input.nextLine();
                    System.out.print("Artis: ");
                    String artist = input.nextLine();
                    System.out.print("Durasi (detik): ");
                    double dur = input.nextDouble(); input.nextLine();
                    System.out.print("Genre (Pop/Rock/Jazz): ");
                    String g = input.nextLine();

                    Song s;
                    switch (g.toLowerCase()) {
                        case "pop": s = new PopSong(title, artist, dur); break;
                        case "rock": s = new RockSong(title, artist, dur); break;
                        case "jazz": s = new JazzSong(title, artist, dur); break;
                        default: s = new Song(title, artist, dur);
                    }
                    manager.addSong(s);
                    break;

                case 2: manager.displaySongs(); break;
                case 3: manager.saveToFile("playlist.txt"); break;
                case 4: manager.loadFromFile("playlist.txt"); break;

                case 5:
                    manager.displaySongs();
                    System.out.print("Pilih nomor: ");
                    int idx = input.nextInt() - 1;
                    if (idx >= 0 && idx < manager.getSongs().size()) {
                        if (playing != null) playing.stopPlaying();
                        playing = new PlayThread(manager.getSongs().get(idx));
                        playing.start();
                    }
                    break;

                case 6:
                    if (playing != null) playing.stopPlaying();
                    break;
            }

        } while (choice != 0);

        if (playing != null) playing.stopPlaying();
        input.close();
    }
}