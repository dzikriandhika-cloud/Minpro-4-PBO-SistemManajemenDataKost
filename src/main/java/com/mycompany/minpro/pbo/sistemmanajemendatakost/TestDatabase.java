package com.mycompany.minpro.pbo.sistemmanajemendatakost;

import com.mycompany.minpro.pbo.sistemmanajemendatakost.config.DatabaseConnection;
import com.mycompany.minpro.pbo.sistemmanajemendatakost.dao.PenghuniDAO;
import java.sql.Connection;
import java.sql.SQLException;

public class TestDatabase {

    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            System.out.println("Koneksi database berhasil!");

            PenghuniDAO dao = new PenghuniDAO();
            dao.tampilkanSemuaData();

        } catch (SQLException e) {
            System.out.println("Koneksi database gagal!");
            System.out.println(e.getMessage());
        }
    }
}