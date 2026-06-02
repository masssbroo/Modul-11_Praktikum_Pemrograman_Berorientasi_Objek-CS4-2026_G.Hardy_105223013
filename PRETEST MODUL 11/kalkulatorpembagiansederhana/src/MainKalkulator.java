import java.util.InputMismatchException;
import java.util.Scanner;

public class MainKalkulator {

    public int lakukanPembagian(int pembilang, int penyebut) throws ArithmeticException {
        return pembilang / penyebut;
    }

    public static void main(String[] args) {
        Scanner scanner = null;
        MainKalkulator kalkulator = new MainKalkulator();

        try {
            scanner = new Scanner(System.in);
            
            System.out.println("=== PROGRAM KALKULATOR PEMBAGIAN SEDERHANA ===");
            System.out.print("Masukkan angka pertama (pembilang): ");
            int pembilang = scanner.nextInt();
            
            System.out.print("Masukkan angka kedua (penyebut): ");
            int penyebut = scanner.nextInt();

            int hasil = kalkulator.lakukanPembagian(pembilang, penyebut);
            System.out.println("Hasil pembagian: " + hasil);

        } catch (InputMismatchException e) {
            System.out.println("Peringatan: Input tidak valid! Anda harus memasukkan angka, bukan huruf atau karakter lainnya.");
        } catch (ArithmeticException e) {
            System.out.println("Peringatan: Terjadi kesalahan aritmatika! Angka penyebut tidak boleh bernilai nol (0).");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
            System.out.println("Proses kalkulasi selesai dan resource memori telah dibersihkan.");
        }
    }
}