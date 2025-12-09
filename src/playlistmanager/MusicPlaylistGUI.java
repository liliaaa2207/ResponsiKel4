package playlistmanager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MusicPlaylistGUI extends JFrame {

    private PlaylistManager manager = new PlaylistManager();
    private JTextField titleField, artistField, durationField;
    private JComboBox<String> genreBox;
    private JTable table;
    private DefaultTableModel model;
    private MusicPlaylistManager.PlayThread playing;

    public MusicPlaylistGUI() {
        setTitle("Music Playlist Manager (GUI)");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        JPanel form = new JPanel(new GridLayout(4,2,5,5));
        form.setBorder(BorderFactory.createTitledBorder("Tambah Lagu"));

        titleField = new JTextField();
        artistField = new JTextField();
        durationField = new JTextField();
        genreBox = new JComboBox<>(new String[]{"Pop","Rock","Jazz"});

        form.add(new JLabel("Judul:")); form.add(titleField);
        form.add(new JLabel("Artis:")); form.add(artistField);
        form.add(new JLabel("Durasi:")); form.add(durationField);
        form.add(new JLabel("Genre:")); form.add(genreBox);

        add(form, BorderLayout.NORTH);

        model = new DefaultTableModel(new String[]{"Judul","Artis","Durasi","Genre"},0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel buttons = new JPanel();

        JButton addBtn = new JButton("Tambah");
        JButton playBtn = new JButton("Play");
        JButton stopBtn = new JButton("Stop");
        JButton saveBtn = new JButton("Save");
        JButton loadBtn = new JButton("Load");

        buttons.add(addBtn);
        buttons.add(playBtn);
        buttons.add(stopBtn);
        buttons.add(saveBtn);
        buttons.add(loadBtn);

        add(buttons, BorderLayout.SOUTH);

        addBtn.addActionListener(e -> addSong());
        playBtn.addActionListener(e -> play());
        stopBtn.addActionListener(e -> { if (playing != null) playing.stopPlaying(); });
        saveBtn.addActionListener(e -> manager.saveToFile("playlist.txt"));
        loadBtn.addActionListener(e -> { manager.loadFromFile("playlist.txt"); updateTable(); });
    }

    private void addSong() {
        try {
            String title = titleField.getText();
            String artist = artistField.getText();
            double dur = Double.parseDouble(durationField.getText());
            String gen = genreBox.getSelectedItem().toString();

            Song s;
            switch (gen.toLowerCase()) {
                case "pop": s = new PopSong(title, artist, dur); break;
                case "rock": s = new RockSong(title, artist, dur); break;
                case "jazz": s = new JazzSong(title, artist, dur); break;
                default: s = new Song(title, artist, dur);
            }

            manager.addSong(s);
            updateTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Input salah!");
        }
    }

    private void play() {
        int row = table.getSelectedRow();
        if (row < 0) return;
        if (playing != null) playing.stopPlaying();
        playing = new MusicPlaylistManager.PlayThread(manager.getSongs().get(row));
        playing.start();
    }

    private void updateTable() {
        model.setRowCount(0);
        for (Song s : manager.getSongs()) {
            model.addRow(new Object[]{s.getTitle(), s.getArtist(), s.getDuration(), s.getGenre()});
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MusicPlaylistGUI().setVisible(true));
    }
}