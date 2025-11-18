package Model;

public class Voucher extends Barang {
    private double ppn;

    public Voucher(String id, String nama, int harga, int stock, double ppn) {
        super(id, nama, harga, stock);
        this.ppn = ppn;
    }

    public double getPpn() {
        return ppn;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("PPN   : " + ppn);
    }
}




