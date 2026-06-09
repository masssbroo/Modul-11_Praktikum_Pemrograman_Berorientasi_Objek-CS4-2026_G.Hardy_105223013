public class TiketHabisException extends Exception {
    public TiketHabisException(String namaKereta, int sisaKursi) {
        super("Tiket habis! Kereta " + namaKereta + " hanya tersisa " + sisaKursi + " kursi.");
    }
}