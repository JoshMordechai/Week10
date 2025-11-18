package kontrol;

import Model.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // - upcast
        Barang[] daftar = new Barang[50];
        int jumlah = 0;

        daftar[jumlah] = new Handphone("H01", "Samsung A15", 2500000, 10, "Hitam", 6);
        jumlah++;
        daftar[jumlah] = new Handphone("H02", "iPhone 12", 9000000, 5, "Putih", 4);
        jumlah++;
        daftar[jumlah] = new Voucher("V01", "Voucher Google Play", 100000, 20, 0.1);
        jumlah++;
        daftar[jumlah] = new Voucher("V02", "Voucher Steam", 120000, 15, 0.1);
        jumlah++;

        Order[] pesanan = new Order[100];
        int jumOrder = 0;

        int pilihan = 0;

        while (pilihan != 4) {
            System.out.println("\n----------------Menu Toko Voucher & HP----------------");
            System.out.println("1. Pesan Barang");
            System.out.println("2. Lihat Pesanan");
            System.out.println("3. Barang Baru");
            System.out.println("4. Keluar");
            System.out.print("Pilihan: ");
            pilihan = in.nextInt();
            in.nextLine(); // buang newline

            switch (pilihan) {

                case 1:
                    System.out.println("\n==== Daftar Barang ====");
                    for (int i = 0; i < jumlah; i++) {
                        System.out.println("----------------------");
                        daftar[i].displayInfo();

                        if (daftar[i] instanceof Handphone) {
                            Handphone hp = (Handphone) daftar[i];
                            System.out.println("[TYPE] Handphone | Warna: " + hp.getWarna());
                        } else if (daftar[i] instanceof Voucher) {
                            Voucher v = (Voucher) daftar[i];
                            System.out.println("[TYPE] Voucher   | PPN: " + v.getPpn());
                        }
                    }

                    System.out.print("\nMasukkan ID barang: ");
                    String id = in.nextLine();

                    Barang dipilih = null;
                    for (int i = 0; i < jumlah; i++) {
                        if (daftar[i].getId().equalsIgnoreCase(id)) {
                            dipilih = daftar[i];
                            break;
                        }
                    }

                    if (dipilih == null) {
                        System.out.println("ID tidak ditemukan.");
                        break;
                    }

                    System.out.print("Jumlah: ");
                    int jml = in.nextInt();
                    in.nextLine();

                    if (jml > dipilih.getStock()) {
                        System.out.println("Stock tidak mencukupi.");
                        break;
                    }

                    dipilih.kurangiStock(jml);
                    pesanan[jumOrder] = new Order(dipilih, jml);
                    jumOrder++;
                    System.out.println("Berhasil dipesan!");
                    break;

                case 2:
                    System.out.println("\n==== Daftar Pesanan ====");
                    if (jumOrder == 0) {
                        System.out.println("Belum ada pesanan.");
                    }
                    for (int i = 0; i < jumOrder; i++) {
                        System.out.println("----------------------");
                        pesanan[i].displayOrder();
                    }
                    break;

                case 3:
                    System.out.print("Voucher / Handphone (V/H): ");
                    String tipe = in.nextLine().trim().toLowerCase();

                    System.out.print("Nama : ");
                    String nama = in.nextLine();

                    System.out.print("Harga : ");
                    double harga = in.nextDouble();

                    System.out.print("Stok : ");
                    int stok = in.nextInt();
                    in.nextLine();

                    String newId = "B" + (jumlah + 1);

                    if (tipe.equals("h")) {
                        System.out.print("Warna: ");
                        String warna = in.nextLine();

                        System.out.print("RAM (GB): ");
                        int ram = in.nextInt();
                        in.nextLine();

                        daftar[jumlah] = new Handphone(newId, nama, (int) harga, stok, warna, ram);
                        jumlah++;
                        System.out.println("Handphone telah berhasil di input");
                    } else if (tipe.equals("v")) {
                        System.out.print("PPN : ");
                        double ppn = in.nextDouble();
                        in.nextLine();

                        daftar[jumlah] = new Voucher(newId, nama, (int) harga, stok, ppn);
                        jumlah++;
                        System.out.println("Voucher telah berhasil di input");
                    } else {
                        System.out.println("Input tipe tidak valid. Masuk ke menu utama.");
                    }
                    break;

                case 4:
                    System.out.println("Keluar...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            } 
        } 

        in.close();
    }
}
