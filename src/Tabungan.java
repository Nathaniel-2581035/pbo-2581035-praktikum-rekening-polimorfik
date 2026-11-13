public class Tabungan extends Rekening implements BerBunga {
    private double bungaPersen;

    public Tabungan(String nomor, String pemilik, int saldo, double bungaPersen) {
        super(nomor, pemilik, saldo);
        this.bungaPersen = bungaPersen;
    }

    @Override
    public int biayaAdminBulanan() {
        return saldo >= 1_000_000 ? 0 : 5_000;
    }

    @Override
    public int tambahBunga() {
        int bunga = (int) (saldo * bungaPersen / 100);
        setor(bunga);
        return bunga;
    }

    @Override
    public void cetakInfo() {
        super.cetakInfo();
        System.out.println("Jenis: Tabungan (bunga " + bungaPersen + "%)");
    }
}