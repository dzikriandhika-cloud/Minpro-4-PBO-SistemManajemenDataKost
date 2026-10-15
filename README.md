Minpro-4-PBO-SistemManajemenDataKost

Deskripsi Program

Program Sistem Manajemen Data Kost merupakan aplikasi berbasis Java yang digunakan untuk mengelola data penghuni kost melalui antarmuka console. Program menyediakan fitur menampilkan, menambahkan, mengubah, dan menghapus data penghuni.

Teknologi yang Digunakan

- Java
- Maven
- JDBC
- MySQL
- PreparedStatement dengan pola DAO

Database

Nama database: "db_kost"

Tabel: "penghuni"

Data awal database disediakan melalui file SQL.

Fitur Program

1. Menampilkan seluruh data penghuni.
2. Menambahkan data penghuni.
3. Mengubah data penghuni berdasarkan ID.
4. Menghapus data penghuni berdasarkan ID.
5. Keluar dari program.

Struktur Program

- "config/DatabaseConnection.java": mengatur koneksi ke database MySQL.
- "dao/PenghuniDAO.java": menjalankan operasi CRUD menggunakan JDBC dan PreparedStatement.
- "Minpro4PBOSistemManajemenDataKost.java": menampilkan menu dan menerima input pengguna.

Cara Menjalankan

1. Jalankan MySQL melalui XAMPP.
2. Import file SQL untuk membuat database dan tabel beserta data awal.
3. Buka project menggunakan NetBeans.
4. Pastikan konfigurasi koneksi database sesuai.
5. Jalankan class utama program.

Operasi CRUD

Program menerapkan CRUD (Create, Read, Update, Delete) untuk pengelolaan data penghuni kost.
