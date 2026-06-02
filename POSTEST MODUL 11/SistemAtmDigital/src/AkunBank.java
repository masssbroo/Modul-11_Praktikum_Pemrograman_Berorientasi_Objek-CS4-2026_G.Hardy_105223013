public class AkunBank {
    private String nomorRekening;
    private double saldo;
    private double totalTransferHariIni;
    private static final double LIMIT_HARIAN = 10000000.0;

    public AkunBank(String nomorRekening, double saldo) {
        this.nomorRekening = nomorRekening;
        this.saldo = saldo;
        this.totalTransferHariIni = 0;
    }

    public String getNomorRekening() {
        return nomorRekening;
    }

    public double getSaldo() {
        return saldo;
    }

    public void tarikTunai(double nominal) throws SaldoTidakMencukupiException {
        if (nominal > saldo) {
            double kekurangan = nominal - saldo;
            throw new SaldoTidakMencukupiException("Error: Saldo tidak mencukupi untuk melakukan penarikan.", kekurangan);
        }
        saldo -= nominal;
        System.out.println("Penarikan berhasil: Rp " + nominal + " | Sisa Saldo: Rp " + saldo);
    }

    public void transfer(AkunBank tujuan, double nominal) throws SaldoTidakMencukupiException, BatasTransferHarianException {
        if (totalTransferHariIni + nominal > LIMIT_HARIAN) {
            throw new BatasTransferHarianException("Error: Transaksi gagal! Akumulasi transfer Anda melampaui limit harian Rp 10.000.000.");
        }

        if (nominal > saldo) {
            double kekurangan = nominal - saldo;
            throw new SaldoTidakMencukupiException("Error: Saldo tidak mencukupi untuk melakukan transfer.", kekurangan);
        }
        
        saldo -= nominal;
        totalTransferHariIni += nominal;
        tujuan.saldo += nominal;
        System.out.println("Transfer berhasil: Rp " + nominal + " ke Rekening " + tujuan.getNomorRekening());
    }
}