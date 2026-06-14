package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;

public class Koneksi {

    // Membuat variabel koneksi
    private static Connection koneksi;

    // Method untuk koneksi ke database
    public static Connection getKoneksi() {

        try {

            // URL database
            String url = "jdbc:mysql://localhost:3306/db_rental";

            // Username database
            String user = "root";

            // Password database
            String pass = "";

            // Memanggil driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Membuat koneksi
            koneksi = DriverManager.getConnection(
                    url, user, pass);

            // Pesan berhasil
            System.out.println("Koneksi Berhasil");

        } catch (Exception e) {

            // Pesan gagal
            System.out.println("Koneksi Gagal");

            // Menampilkan detail error
            System.out.println(e);

        }

        // Mengembalikan nilai koneksi
        return koneksi;
    }
}