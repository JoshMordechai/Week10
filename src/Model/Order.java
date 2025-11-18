package Model;

public class Order {
    private Barang barang;
    private int jumlah;

    public Order(Barang barang, int jumlah) {
        this.barang = barang;
        this.jumlah = jumlah;
    }

    public void displayOrder() {
        System.out.println("Nama   : " + barang.getNama());
        System.out.println("Jumlah : " + jumlah);
        System.out.println("Harga  : " + barang.getHarga());
        System.out.println("Total  : " + (barang.getHarga() * jumlah));
    }
}



