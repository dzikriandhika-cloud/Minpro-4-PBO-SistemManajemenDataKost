package com.mycompany.minpro.pbo.sistemmanajemendatakost;

import java.util.Scanner;
import com.mycompany.minpro.pbo.sistemmanajemendatakost.dao.PenghuniDAO;

public class Minpro4PBOSistemManajemenDataKost {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PenghuniDAO dao = new PenghuniDAO();
        int pilihan = -1;

        do {
            System.out.println("\n=== SISTEM MANAJEMEN DATA KOST ===");
            System.out.println("1. Tampilkan Data");
            System.out.println("2. Tambah Data");
            System.out.println("3. Ubah Data");
            System.out.println("4. Hapus Data");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            try {
                pilihan = Integer.parseInt(input.nextLine());

                switch (pilihan) {
                    case 1:
                        dao.tampilkanSemuaData();
                        break;

                    case 2:
                        System.out.println("\n=== TAMBAH DATA ===");
                        System.out.print("ID: ");
                        String id = input.nextLine();
                        System.out.print("Nama: ");
                        String nama = input.nextLine();
                        System.out.print("No. HP: ");
                        String noHp = input.nextLine();
                        System.out.print("No. Kamar: ");
                        String noKamar = input.nextLine();
                        System.out.print("Jenis Penghuni: ");
                        String jenis = input.nextLine();
                        System.out.print("NIM: ");
                        String nim = input.nextLine();
                        System.out.print("Universitas: ");
                        String universitas = input.nextLine();

                        if (dao.tambahData(id, nama, noHp, noKamar,
                                jenis, nim, universitas)) {
                            System.out.println("Data berhasil ditambahkan.");
                        } else {
                            System.out.println("Data gagal ditambahkan.");
                        }
                        break;

                    case 3:
                        System.out.println("\n=== UBAH DATA ===");
                        System.out.print("Masukkan ID yang akan diubah: ");
                        String idUbah = input.nextLine();
                        System.out.print("Nama baru: ");
                        String namaBaru = input.nextLine();
                        System.out.print("No. HP baru: ");
                        String hpBaru = input.nextLine();
                        System.out.print("No. Kamar baru: ");
                        String kamarBaru = input.nextLine();
                        System.out.print("Jenis Penghuni baru: ");
                        String jenisBaru = input.nextLine();
                        System.out.print("NIM baru: ");
                        String nimBaru = input.nextLine();
                        System.out.print("Universitas baru: ");
                        String universitasBaru = input.nextLine();

                        if (dao.ubahPenghuni(idUbah, namaBaru, hpBaru,
                                kamarBaru, jenisBaru, nimBaru,
                                universitasBaru)) {
                            System.out.println("Data berhasil diubah.");
                        } else {
                            System.out.println(
                                    "Data gagal diubah. Pastikan ID tersedia.");
                        }
                        break;

                    case 4:
                        System.out.println("\n=== HAPUS DATA ===");
                        System.out.print("Masukkan ID yang akan dihapus: ");
                        String idHapus = input.nextLine();

                        System.out.print("Yakin ingin menghapus data? (y/n): ");
                        String konfirmasi = input.nextLine();

                        if (konfirmasi.equalsIgnoreCase("y")) {
                            if (dao.hapusPenghuni(idHapus)) {
                                System.out.println("Data berhasil dihapus.");
                            } else {
                                System.out.println(
                                        "Data gagal dihapus atau ID tidak ditemukan.");
                            }
                        } else {
                            System.out.println("Penghapusan dibatalkan.");
                        }
                        break;

                    case 0:
                        System.out.println("Program selesai. Terima kasih!");
                        break;

                    default:
                        System.out.println("Pilihan tidak tersedia.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Masukkan nomor menu yang benar.");
            }
        } while (pilihan != 0);

        input.close();
    }
}