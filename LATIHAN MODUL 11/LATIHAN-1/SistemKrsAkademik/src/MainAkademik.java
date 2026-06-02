import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainAkademik {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- SOAL 1: Persiapan Kuota Kelas ---");
        int[] kuotaKelas = new int[3];
        try {
            for (int i = 0; i < 4; i++) {
                System.out.print("Masukkan data kuota ke-" + (i + 1) + ": ");
                kuotaKelas[i] = scanner.nextInt();
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Input harus berupa angka bulat!");
            scanner.nextLine();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Batas kuota terlampaui! Kapasitas simpan kuota kelas penuh.");
        }

        Mahasiswa mhs = new Mahasiswa();

        System.out.println("\n--- SOAL 2: Validasi Data Mahasiswa ---");
        try {
            mhs.setSksMaksimal(25);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            mhs.setSksMaksimal(20);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n--- SOAL 3: Penambahan Mata Kuliah ---");
        try {
            mhs.ambilMataKuliah("Pemrograman Berorientasi Objek", 24);
        } catch (SksTidakCukupException e) {
            System.out.println(e.getMessage());
        }

        SistemAkademik akademik = new SistemAkademik();

        System.out.println("\n--- SOAL 4: Pengecekan Ketersediaan Kelas ---");
        try {
            akademik.gabungKelas("CS301", 0);
        } catch (KelasPenuhException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n--- SOAL 5: Pencetakan Dokumen KRS ---");
        try {
            akademik.cetakDokumenKrs("krs_salah.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("\nSesi Sistem Rencana Studi telah ditutup. Koneksi database diputuskan.");
            scanner.close();
        }
    }
}