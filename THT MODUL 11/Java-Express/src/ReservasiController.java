import java.util.ArrayList;
import java.util.List;

public class ReservasiController {
    private List<KeretaApi> daftarKereta;

    public ReservasiController() {
        daftarKereta = new ArrayList<>();
        daftarKereta.add(new KeretaApi("K01", "Argo Bromo", "JKT - SBY", 50));
        daftarKereta.add(new KeretaApi("K02", "Parahyangan", "JKT - BDG", 15));
    }

    public void tampilkanJadwal() {
        System.out.println("\n=== JADWAL KERETA API JAVA EXPRESS ===");
        for (KeretaApi k : daftarKereta) {
            System.out.println(k.getKode() + " | " + k.getNama() + " (" + k.getRute() + ") - Sisa Kursi: " + k.getSisaKursi());
        }
        System.out.println("======================================");
    }

    public void pesanTiket(String kode, String nik, String namaPenumpang, int jumlahTiket) 
            throws RuteTidakDitemukanException, TiketHabisException {
        
        if (nik == null || nik.length() != 16 || !nik.matches("\\d+")) {
            throw new DataPenumpangTidakValidException("Format NIK salah. NIK harus terdiri dari 16 digit angka.");
        }

        KeretaApi keretaPilihan = null;
        for (KeretaApi k : daftarKereta) {
            if (k.getKode().equalsIgnoreCase(kode)) {
                keretaPilihan = k;
                break;
            }
        }

        if (keretaPilihan == null) {
            throw new RuteTidakDitemukanException("Kode kereta '" + kode + "' tidak terdaftar di sistem.");
        }

        if (jumlahTiket > keretaPilihan.getSisaKursi()) {
            throw new TiketHabisException(keretaPilihan.getNama(), keretaPilihan.getSisaKursi());
        }

        keretaPilihan.kurangiKursi(jumlahTiket);
        System.out.println("\n✅ RESERVASI BERHASIL!");
        System.out.println("Detail Pemesanan:");
        System.out.println("- Penumpang    : " + namaPenumpang + " (NIK: " + nik + ")");
        System.out.println("- Kereta       : " + keretaPilihan.getNama() + " (" + keretaPilihan.getRute() + ")");
        System.out.println("- Jumlah Tiket : " + jumlahTiket);
    }
}