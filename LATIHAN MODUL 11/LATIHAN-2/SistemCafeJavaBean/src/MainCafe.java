import java.util.InputMismatchException;
import java.util.Scanner;

public class MainCafe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // SOAL 1: Input Harga Menu Dasar
        System.out.println("--- SOAL 1: Input Menu ---");
        int[] hargaMenu = new int[3]; // Array ukuran 3
        
        try {
            // Sengaja dibuat loop 4 kali untuk memicu ArrayIndexOutOfBoundsException
            for (int i = 0; i < 4; i++) { 
                System.out.print("Masukkan harga menu ke-" + (i + 1) + ": ");
                hargaMenu[i] = scanner.nextInt();
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Input harga harus berupa angka!");
            scanner.nextLine();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Kapasitas memori harga sudah penuh!");
        }


        // Instansiasi objek pelanggan untuk Soal 2 & 3
        Pelanggan pelanggan = new Pelanggan();

        // SOAL 2: Validasi Umur Pelanggan
        System.out.println("\n--- SOAL 2: Daftar Member ---");
        try {
            pelanggan.daftarMember(15); // Simulasi umur 15
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // SOAL 3: Cek Ketersediaan Kopi
        System.out.println("\n--- SOAL 3: Pesan Kopi ---");
        try {
            pelanggan.pesanKopi(10); // Simulasi pesan 10 gelas (stok hanya 5)
        } catch (KopiHabisException e) {
            System.out.println(e.getMessage());
        }


        // Instansiasi objek kasir
        MesinKasir kasir = new MesinKasir();

        // SOAL 4: Pembayaran di Kasir
        System.out.println("\n--- SOAL 4: Pembayaran ---");
        try {
            kasir.bayar(50000, 30000); // Simulasi total 50rb, uang 30rb
        } catch (UangKurangException e) {
            System.out.println(e.getMessage());
        }

        // SOAL 5: Mencetak Struk & Finally
        System.out.println("\n--- SOAL 5: Cetak Struk ---");
        try {
            kasir.cetakStruk(false); // Simulasi kertas habis (false)
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            // Blok ini akan selalu dieksekusi di akhir program
            System.out.println("\nTerima kasih telah berkunjung ke Cafe Java Bean. Program kasir ditutup.");
            scanner.close(); // Menutup scanner
        }
    }
}