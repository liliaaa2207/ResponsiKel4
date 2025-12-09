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

### 1. Object Oriented Programming (OOP)

Konsep yang digunakan:

- Class & Object
- Encapsulation
- Inheritance
- Polymorphism

Contoh implementasi:
```java
class Song { ... }
class PopSong extends Song { ... }

### 2. Array & Collection (ArrayList)

Menggunakan ArrayList untuk menyimpan dan mengelola playlist:

Nama Anggota	Tugas
Nadiva Meiliya	Membuat class Song, PopSong, RockSong, JazzSong
Wizad Akmalia Zulfaa	Membuat PlaylistManager dan fitur File I/O
Zefanya Christian Natasha	Membuat GUI dan Multithreading
