#  Music Playlist Manager

##  Deskripsi Project
Music Playlist Manager adalah aplikasi berbasis Java yang digunakan untuk mengelola daftar lagu (playlist) secara sederhana. Aplikasi ini menyediakan dua versi penggunaan, yaitu versi **Console** dan **GUI (Graphical User Interface)**.

Aplikasi ini dibuat untuk menerapkan konsep dasar **Pemrograman Berorientasi Objek (PBO)** seperti encapsulation, inheritance, polymorphism, collection (ArrayList), file I/O, dan multithreading.

Fitur utama aplikasi:
- Menambah lagu
- Menampilkan daftar lagu
- Menyimpan playlist ke file
- Memuat playlist dari file
- Memutar lagu (simulasi menggunakan thread)
- Menghentikan lagu

---

##  Cara Menjalankan Project

###  Versi Console
1. Buka project di NetBeans / IntelliJ / VS Code
2. Jalankan file berikut:
3. Gunakan menu angka yang muncul di terminal.

###  Versi GUI
1. Jalankan file:
2. Program akan membuka jendela aplikasi.

---

##  Penjelasan GUI yang Digunakan

Aplikasi menggunakan **Java Swing** sebagai teknologi GUI.

Komponen GUI yang dipakai:

| Komponen | Fungsi |
|---------|--------|
| JFrame | Jendela utama aplikasi |
| JTextField | Input judul, artis, dan durasi lagu |
| JComboBox | Memilih genre lagu |
| JTable | Menampilkan daftar lagu |
| JButton | Tombol tambah, play, stop, save, dan load |

### Fitur GUI:
 Tambah lagu  
 Menampilkan playlist dalam bentuk tabel  
 Putar dan stop lagu  
 Simpan dan muat playlist ke/dari file  

---

##  Materi Sebelum UTS yang Diimplementasikan

1. Object Oriented Programming (OOP)

Project ini dibuat menggunakan paradigma Pemrograman Berorientasi Objek (PBO) yang berfokus pada penggunaan objek sebagai dasar pembuatan program.

Konsep OOP yang digunakan dalam project ini meliputi:

a. Class dan Object

Setiap lagu direpresentasikan sebagai objek dari class Song, dan genre lagu diwakili oleh class turunan seperti PopSong, RockSong, dan JazzSong.

Contoh implementasi:
```java
class Song { ... }
class PopSong extends Song { ... }
```
b. Encapsulation (Enkapsulasi)

Data dalam objek dilindungi menggunakan private dan diakses melalui getter dan setter. Tujuannya agar data tidak bisa diubah secara langsung dari luar class.

Contoh:
```java
private String title;
public String getTitle() { return title; }
```
c. Inheritance (Pewarisan)

Class turunan seperti PopSong, RockSong, dan JazzSong mewarisi sifat dari class Song menggunakan keyword extends.

Contoh:
```java
public class PopSong extends Song { ... }
```
d. Polymorphism (Polimorfisme)

Method getGenre() dioverride pada class turunan untuk menghasilkan output yang berbeda meskipun pemanggilan method sama.

2. Array dan Collection (ArrayList)

Project ini menggunakan struktur data ArrayList untuk menyimpan daftar lagu yang ada di playlist.

ArrayList digunakan karena:
- Dapat menyimpan data secara dinamis
- Mudah ditambah dan dihapus
- Cocok untuk data bertipe objek
Contoh penggunaan:
```java
private ArrayList<Song> playlist = new ArrayList<>();
```
Fungsi yang memanfaatkan ArrayList:
- addSong() → menambahkan lagu
- displaySongs() → menampilkan semua lagu
- getSongs() → mengambil data playlist

3. File Input dan Output (File I/O)

Aplikasi mendukung penyimpanan dan pemuatan data playlist menggunakan file teks.

Digunakan class Java berikut:
- FileWriter
- FileReader
- BufferedWriter
- BufferedReader

Tujuan fitur ini:
- Menyimpan data agar tidak hilang saat program ditutup
- Membaca kembali playlist yang sudah disimpan

Contoh implementasi:
```java
BufferedWriter writer = new BufferedWriter(new FileWriter("playlist.txt"));
```
4. Multithreading (Materi Setelah UTS)

Project ini juga mengimplementasikan Multithreading, yaitu menjalankan beberapa proses secara bersamaan.

Digunakan untuk:
- Simulasi pemutaran lagu
- Menampilkan waktu berjalan tanpa menghentikan program utama

Class yang digunakan:
```java
static class PlayThread extends Thread {
    @Override
    public void run() {
        Thread.sleep(1000);
    }
}
```
Keuntungan Multithreading:
- Program tetap bisa menerima input saat lagu diputar
- Tidak mengganggu menu utama
- Memberi pengalaman seperti pemutar musik sungguhan

|Nama Anggota |	Tugas|
|------------ |------|
|Nadiva Meiliya |	Membuat class Song, PopSong, RockSong, JazzSong
|Wizad Akmalia Zulfaa |	Membuat PlaylistManager dan fitur File I/O
|Zefanya Christian Natasha	| Membuat GUI dan Multithreading
