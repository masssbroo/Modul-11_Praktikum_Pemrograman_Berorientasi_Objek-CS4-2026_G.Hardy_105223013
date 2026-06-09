import java.util.Scanner;
import java.util.InputMismatchException;

public class JavaExpressApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservasiController controller = new ReservasiController();
        boolean isRunning = true;

        System.out.println("Selamat datang di Sistem Reservasi Tiket JAVA EXPRESS");

        while (isRunning) {
            try {
                System.out.println("\n=== MENU UTAMA ===");
                System.out.println("1. Lihat Jadwal");
                System.out.println("2. Pesan Tiket");
                System.out.println("3. Keluar");
                System.out.print("Pilih menu (1-3): ");
                
                int pilihan = scanner.nextInt();
                scanner.nextLine(); 

                switch (pilihan) {
                    case 1:
                        controller.tampilkanJadwal();
                        break;
                    case 2:
                        System.out.print("Masukkan Kode Kereta: ");
                        String kode = scanner.nextLine();
                        System.out.print("Masukkan NIK Penumpang: ");
                        String nik = scanner.nextLine();
                        System.out.print("Masukkan Nama Penumpang: ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan Jumlah Tiket: ");
                        
                        int jumlah = scanner.nextInt();
                        scanner.nextLine(); 

                        controller.pesanTiket(kode, nik, nama, jumlah);
                        break;
                    case 3:
                        isRunning = false;
                        break;
                    default:
                        System.out.println("⚠️ Pilihan tidak valid. Silakan ketik angka 1, 2, atau 3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("⚠️ Error Input: Anda memasukkan format yang salah. Harap hanya memasukkan angka untuk Pilihan Menu dan Jumlah Tiket.");
                scanner.nextLine(); 
            } catch (DataPenumpangTidakValidException e) {
                System.out.println("❌ Reservasi Gagal: " + e.getMessage());
            } catch (RuteTidakDitemukanException | TiketHabisException e) {
                System.out.println("❌ Reservasi Gagal: " + e.getMessage());
            } finally {
                if (!isRunning) {
                    System.out.println("\n🔒 Sistem Ditutup. Terima kasih telah menggunakan JAVA EXPRESS!");
                    scanner.close();
                }
            }
        }
    }
}