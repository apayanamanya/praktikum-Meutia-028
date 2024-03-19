import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

            Scanner scanner = new
                    Scanner(System.in);

            //data user
            String adminUsername = "admin";
            String adminPassword = "admin123";
            String mahasiswaUsername = "mahasiswa";
            // Input username dan password
            System.out.println("Selamat Datang di Sistem Login Perpustakaan.");
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            // Proses autentikasi
            if (username.equals(adminUsername) && password.equals(adminPassword)) {
                System.out.println("Login berhasil sebagai admin.");
                // Tambahkan logika atau menu untuk admin di sini
            } else if (username.equals(mahasiswaUsername)) {
                System.out.println("Login berhasil sebagai mahasiswa.");
                // Tambahkan logika atau menu untuk mahasiswa di sini
            } else {
                System.out.println("Username atau password salah. Silakan coba lagi.");
            }

            scanner.close();
        }
    }