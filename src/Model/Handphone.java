package Model;

public class Handphone extends Barang {
    private String warna;
    private int ram;

    public Handphone(String id, String nama, int harga, int stock, String warna, int ram) {
        super(id, nama, harga, stock);
        this.warna = warna;
        this.ram = ram;
    }

    public String getWarna() {
        return warna;
    }

    public int getRam() {
        return ram;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Warna : " + warna);
        System.out.println("RAM   : " + ram + " GB");
    }
}
