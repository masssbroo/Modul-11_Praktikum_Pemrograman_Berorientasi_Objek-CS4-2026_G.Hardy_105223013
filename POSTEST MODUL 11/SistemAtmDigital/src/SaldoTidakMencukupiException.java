public class SaldoTidakMencukupiException extends Exception {
    private double nominalKekurangan;

    public SaldoTidakMencukupiException(String message, double nominalKekurangan) {
        super(message);
        this.nominalKekurangan = nominalKekurangan;
    }

    public double getNominalKekurangan() {
        return nominalKekurangan;
    }
}