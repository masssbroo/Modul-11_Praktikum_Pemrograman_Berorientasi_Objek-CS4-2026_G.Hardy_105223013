public class Mahasiswa {
    private int sksMaksimal;
    private int sisaSks;

    public void setSksMaksimal(int sks) {
        if (sks < 2 || sks > 24) {
            throw new IllegalArgumentException("Kesalahan sistem: Batas SKS tidak valid (harus antara 2 - 24 SKS)!");
        }
        this.sksMaksimal = sks;
        this.sisaSks = sks;
        System.out.println("Batas maksimal SKS berhasil diatur ke: " + sks);
    }

    public void ambilMataKuliah(String namaMatkul, int bebanSks) {
        if (bebanSks > sisaSks) {
            throw new SksTidakCukupException("SksTidakCukupException: Sisa SKS tidak mencukupi untuk mengambil " + namaMatkul);
        }
        sisaSks -= bebanSks;
        System.out.println("Berhasil mengambil " + namaMatkul + " (" + bebanSks + " SKS). Sisa SKS: " + sisaSks);
    }
}