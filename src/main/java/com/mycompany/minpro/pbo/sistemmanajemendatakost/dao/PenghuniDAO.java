package com.mycompany.minpro.pbo.sistemmanajemendatakost.dao;

import com.mycompany.minpro.pbo.sistemmanajemendatakost.config.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PenghuniDAO {

    // READ: Menampilkan semua data penghuni
    public void tampilkanSemuaData() {
        String sql = "SELECT * FROM penghuni";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("\n=== DATA PENGHUNI KOST ===");

            while (rs.next()) {
                System.out.println("-------------------------");
                System.out.println("ID             : " + rs.getString("id"));
                System.out.println("Nama           : " + rs.getString("nama"));
                System.out.println("No. HP         : " + rs.getString("no_hp"));
                System.out.println("No. Kamar      : " + rs.getString("no_kamar"));
                System.out.println("Jenis Penghuni : " + rs.getString("jenis_penghuni"));
                System.out.println("NIM            : " + rs.getString("nim"));
                System.out.println("Universitas    : " + rs.getString("universitas"));
            }

        } catch (SQLException e) {
            System.out.println("Gagal membaca data: " + e.getMessage());
        }
    }

    // CREATE: Menambahkan data penghuni
    public boolean tambahData(
            String id, String nama, String noHp,
            String noKamar, String jenisPenghuni,
            String nim, String universitas) {

        String sql = "INSERT INTO penghuni "
                + "(id, nama, no_hp, no_kamar, jenis_penghuni, nim, universitas) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.setString(2, nama);
            stmt.setString(3, noHp);
            stmt.setString(4, noKamar);
            stmt.setString(5, jenisPenghuni);
            stmt.setString(6, nim);
            stmt.setString(7, universitas);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Gagal menambahkan data: " + e.getMessage());
            return false;
        }
    }

    // UPDATE: Mengubah data penghuni berdasarkan ID
    public boolean ubahPenghuni(
            String id, String nama, String noHp,
            String noKamar, String jenisPenghuni,
            String nim, String universitas) {

        String sql = "UPDATE penghuni SET nama = ?, no_hp = ?, "
                + "no_kamar = ?, jenis_penghuni = ?, nim = ?, "
                + "universitas = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nama);
            stmt.setString(2, noHp);
            stmt.setString(3, noKamar);
            stmt.setString(4, jenisPenghuni);
            stmt.setString(5, nim);
            stmt.setString(6, universitas);
            stmt.setString(7, id);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Gagal mengubah data: " + e.getMessage());
            return false;
        }
    }

    // DELETE: Menghapus data penghuni berdasarkan ID
    public boolean hapusPenghuni(String id) {
        String sql = "DELETE FROM penghuni WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Gagal menghapus data: " + e.getMessage());
            return false;
        }
    }
}