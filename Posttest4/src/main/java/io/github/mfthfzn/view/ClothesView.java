package io.github.mfthfzn.view;

import io.github.mfthfzn.entity.Bottoms;
import io.github.mfthfzn.entity.Tops;
import io.github.mfthfzn.service.ClothesService;
import io.github.mfthfzn.util.ScannerUtil;

public class ClothesView {

  private final ClothesService clothesService;

  private final ScannerUtil scannerUtil;

  public ClothesView(ClothesService clothesService, ScannerUtil scannerUtil) {
    this.clothesService = clothesService;
    this.scannerUtil = scannerUtil;
  }

  public void mainView() {
    String choice;
    while (true) {

      System.out.println();
      System.out.println("================== USER MENU ====================");
      System.out.println("[1] Tampilkan Data Pakaian");
      System.out.println("[2] Tambah Data Pakaian");
      System.out.println("[3] Update Stok Pakaian");
      System.out.println("[4] Hapus Data Pakaian");
      System.out.println("[5] Logout");
      System.out.println("================================================");

      choice = scannerUtil.input("Pilih Menu");

      if (choice.equals("1")) {
        showClothesView();
      } else if (choice.equals("2")) {
        addClothesMainView();
      } else if (choice.equals("3")) {
        updateStockView();
      } else if (choice.equals("4")) {
        deleteClothesView();
      } else if (choice.equals("5")) {
        break;
      } else {
        System.out.println("Menu tidak tersedia");
      }
    }
    System.out.println("Berhasil Log Out");
  }

  protected void addClothesMainView() {
    System.out.println();
    System.out.println("================= TAMBAH PAKAIAN =================");
    System.out.println("[1] Pakaian Atas");
    System.out.println("[2] Pakaian Bawah");
    System.out.println("[3] Batal");

    String addChoice = scannerUtil.input("Pilih Menu");

    if (addChoice.equals("1")) {
      addClothesTopView();
    } else if (addChoice.equals("2")) {
      addClothesBottomView();
    } else if (addChoice.equals("3")) {
      return;
    } else {
      System.out.println("Menu tidak tersedia");
    }
  }

  protected void addClothesTopView() {
    System.out.println();
    System.out.println("============== TAMBAH PAKAIAN ATAS ===============");
    String SKU = scannerUtil.input("Masukkan SKU pakaian");
    String name = scannerUtil.input("Masukkan nama pakaian");
    String size = scannerUtil.input("Masukkan size pakaian (S, M, L, ...)");
    String inputPrice = scannerUtil.input("Masukkan harga pakaian");
    String inputStock = scannerUtil.input("Masukkan stok pakaian");
    try {
      Integer price = Integer.valueOf(inputPrice);
      Integer stock = Integer.valueOf(inputStock);
      clothesService.addProduct(
        new Tops(SKU, name, stock, price, size)
      );
      System.out.println("==================================================");
      System.out.println("        DATA PAKAIAN BERHASIL DITAMBAHKAN         ");
      System.out.println("==================================================");
    } catch (NumberFormatException | NullPointerException exception) {
      System.out.println("==================================================");
      System.out.println("     GAGAL MENAMBAHKAN DATA, DATA HARUS VALID     ");
      System.out.println("==================================================");
    }
  }

  protected void addClothesBottomView() {
    System.out.println();
    System.out.println("================= TAMBAH PAKAIAN =================");
    String SKU = scannerUtil.input("Masukkan SKU pakaian");
    String name = scannerUtil.input("Masukkan nama pakaian");
    String sizeOfString = scannerUtil.input("Masukkan size pakaian (26, 27, 28, ...)");
    String inputPrice = scannerUtil.input("Masukkan harga pakaian");
    String inputStock = scannerUtil.input("Masukkan stok pakaian");
    try {
      Integer price = Integer.valueOf(inputPrice);
      Integer stock = Integer.valueOf(inputStock);
      Integer size = Integer.valueOf(sizeOfString);
      clothesService.addProduct(
              new Bottoms(SKU, name, stock, price, size)
      );
      System.out.println("==================================================");
      System.out.println("        DATA PAKAIAN BERHASIL DITAMBAHKAN         ");
      System.out.println("==================================================");
    } catch (NumberFormatException | NullPointerException exception) {
      System.out.println("==================================================");
      System.out.println("     GAGAL MENAMBAHKAN DATA, DATA HARUS VALID     ");
      System.out.println("==================================================");
    }
  }

  protected void showClothesView() {
    System.out.println();
    System.out.println("==================================================================================================================");
    System.out.println("                                 DAFTAR PRODUK PAKAIAN");
    System.out.println("==================================================================================================================");
    System.out.printf("| %-2s | %-7s | %-13s | %-50s | %-6s | %-7s | %-7s |\n",
            "No", "SKU", "Jenis","Nama Pakaian", "Ukuran", "Harga", "Stock");
    clothesService.showProducts();
  }

  protected void updateStockView() {
    System.out.println();
    System.out.println("================== UPDATE STOK ===================");
    String inputIndex = scannerUtil.input("Masukkan no yang ingin diupdate, (x) untuk keluar");
    if (inputIndex.equals("x")) {
      return;
    } else {
      try {
        int index = Integer.parseInt(inputIndex) - 1;
        clothesService.checkProduct(index);
        String inputNewStock = scannerUtil.input("Masukkan stok baru");
        Integer newStock = Integer.valueOf(inputNewStock);
        clothesService.editProduct(index, newStock);
        System.out.println("==================================================");
        System.out.println("        STOK PAKAIAN ATAS BERHASIL DIUPDATE       ");
        System.out.println("==================================================");
      } catch (NumberFormatException numberFormatException) {
        System.out.println("==================================================");
        System.out.println("                 HARAP MASUKKAN ANGKA             ");
        System.out.println("==================================================");
      } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        System.out.println("==================================================");
        System.out.println("          HARAP MASUKKAN ANGKA YANG VALID         ");
        System.out.println("==================================================");
      }
    }
  }

  protected void deleteClothesView() {
    System.out.println();
    System.out.println("================= HAPUS PAKAIAN ==================");
    String inputIndex = scannerUtil.input("Masukkan no produk yang ingin dihapus, (x) untuk keluar");
    if (inputIndex.equals("x")) {
      return;
    } else {
      try {
        int index = Integer.parseInt(inputIndex) - 1;
        clothesService.checkProduct(index);
        clothesService.removeProduct(index);
        System.out.println("==================================================");
        System.out.println("        DATA PAKAIAN BERHASIL DIHAPUS             ");
        System.out.println("==================================================");
      } catch (NumberFormatException numberFormatException) {
        System.out.println("==================================================");
        System.out.println("                 HARAP MASUKKAN ANGKA             ");
        System.out.println("==================================================");
      } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
        System.out.println("==================================================");
        System.out.println("          HARAP MASUKKAN ANGKA YANG VALID         ");
        System.out.println("==================================================");
      }
    }
  }
}
