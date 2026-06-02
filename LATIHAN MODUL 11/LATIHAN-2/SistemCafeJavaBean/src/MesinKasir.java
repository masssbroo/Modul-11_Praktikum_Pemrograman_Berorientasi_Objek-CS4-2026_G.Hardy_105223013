public class MesinKasir {
    
    // Soal 4: Pembayaran
    public void bayar(int totalBelanja, int uangDiberikan) throws UangKurangException {
        if (uangDiberikan < totalBelanja) {
            throw new UangKurangException("UangKurangException: Uang yang diberikan tidak cukup!");
        }
        System.out.println("Pembayaran berhasil. Kembalian: Rp " + (uangDiberikan - totalBelanja));
    }

    // Soal 5: Mencetak Struk
    public void cetakStruk(boolean statusPrinter) throws Exception {
        if (!statusPrinter) { // Jika statusPrinter bernilai false
            throw new Exception("Printer error: Kertas struk habis!");
        }
        System.out.println("Struk belanja berhasil dicetak.");
    }
}