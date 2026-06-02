public class MainAtm {
    public static void main(String[] args) {
        AkunBank nasabahUtama = new AkunBank("105223013", 5000000.0);
        AkunBank nasabahTujuan = new AkunBank("987654321", 2000000.0);

        System.out.println("=== SIMULASI ATM DIGITAL ===");
        System.out.println("Nomor Rekening Anda: " + nasabahUtama.getNomorRekening());
        System.out.println("Saldo Awal Anda   : Rp " + nasabahUtama.getSaldo());

        try {
            System.out.println("\n--- Memulai Alur Transaksi Berkelanjutan ---");
            
            // Tindakan 1: Menarik uang hingga saldonya habis 
            System.out.println("Memproses penarikan tunai...");
            nasabahUtama.tarikTunai(5000000.0);
            
            // Tindakan 2: Mencoba transfer uang dalam jumlah besar melewati limit
            System.out.println("\nMemproses transfer dana...");
            nasabahUtama.transfer(nasabahTujuan, 12000000.0);

        } catch (SaldoTidakMencukupiException e) {
            // Menangani kegagalan jika saldo kurang
            System.out.println(e.getMessage());
            System.out.println("Nominal Kekurangan Saldo: Rp " + e.getNominalKekurangan());
            
        } catch (BatasTransferHarianException e) {
            // Menangani kegagalan jika melebihi batas transfer harian
            System.out.println(e.getMessage());
            
        } finally {
            System.out.println("\nSesi transaksi ATM Anda telah diakhiri. Kartu dikeluarkan otomatis.");
        }
    }
}