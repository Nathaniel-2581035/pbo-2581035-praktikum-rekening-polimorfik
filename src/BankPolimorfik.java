public class BankPolimorfik {
    public static void main(String[] args) {
        Tabungan ani   = new Tabungan("101", "Ani",   1_000_000, 2.5);
        Tabungan citra = new Tabungan("102", "Citra",   300_000, 2.0);
        Giro budi      = new Giro("201", "Budi", 200_000, 500_000);

        Rekening[] semua = { ani, citra, budi };

        BerBunga[] berbunga = { ani, citra };

        System.out.println("=== Biaya Admin ===");
        for (Rekening r : semua) {
            int biaya = r.potongBiayaAdmin();
            System.out.println(r.getNomor() + " " + r.getPemilik()
                    + " -> biaya admin " + Rekening.formatRupiah(biaya));
        }

        System.out.println("\n=== Bunga ===");
        for (BerBunga b : berbunga) {
            int nilai = b.tambahBunga();
            System.out.println(b.getNomor() + " -> bunga " + Rekening.formatRupiah(nilai));
        }

        System.out.println("\n=== Saldo Akhir ===");
        int total = 0;
        for (Rekening r : semua) {
            r.cetakInfo();
            total += r.getSaldo();
        }
        System.out.println("Total dana bank: " + Rekening.formatRupiah(total));
    }
}