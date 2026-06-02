import java.io.FileNotFoundException;

public class SistemAkademik {

    public void gabungKelas(String kodeKelas, int kuotaTersedia) throws KelasPenuhException {
        if (kuotaTersedia <= 0) {
            throw new KelasPenuhException("KelasPenuhException: Kuota kelas " + kodeKelas + " sudah penuh!");
        }
        System.out.println("Berhasil bergabung ke kelas " + kodeKelas);
    }

    public void cetakDokumenKrs(String namaFile) throws FileNotFoundException {
        if (!"krs_valid.txt".equals(namaFile)) {
            throw new FileNotFoundException("FileNotFoundException: File '" + namaFile + "' tidak ditemukan!");
        }
        System.out.println("Dokumen KRS berhasil dicetak dari file: " + namaFile);
    }
}