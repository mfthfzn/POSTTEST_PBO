package io.github.mfthfzn.view;

import io.github.mfthfzn.util.ScannerUtil;
import io.github.mfthfzn.entity.Product;
import io.github.mfthfzn.service.ProductService;

public class ProductView {

  private final ProductService productService;

  private final ScannerUtil scannerUtil;

  public ProductView(ProductService productService, ScannerUtil scannerUtil) {
    this.productService = productService;
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
        showProductView();
      } else if (choice.equals("2")) {
        addProductView();
      } else if (choice.equals("3")) {
        updateStockView();
      } else if (choice.equals("4")) {
        deleteProductView();
      } else if (choice.equals("5")) {
        break;
      } else {
        System.out.println("Menu tidak tersedia");
      }
    }
    System.out.println("Berhasil Log Out");
  }

  protected void addProductView() {
    System.out.println("");
    System.out.println("================= TAMBAH PAKAIAN =================");
    String SKU = scannerUtil.input("Masukkan SKU pakaian");
    String name = scannerUtil.input("Masukkan nama pakaian");
    String size = scannerUtil.input("Masukkan size pakaian");
    String inputPrice = scannerUtil.input("Masukkan harga pakaian");
    String inputStock = scannerUtil.input("Masukkan stok pakaian");
    try {
      Integer price = Integer.valueOf(inputPrice);
      Integer stock = Integer.valueOf(inputStock);
      productService.addProduct(
        new Product(SKU, name, size, price, stock)
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

  protected void showProductView() {
    System.out.println("");
    System.out.println("==================================================================================================");
    System.out.println("                                 DAFTAR PRODUK PAKAIAN");
    System.out.println("==================================================================================================");
    System.out.printf("| %-2s | %-7s | %-50s | %-6s | %-7s | %-7s |\n",
            "No", "SKU", "Nama Pakaian", "Ukuran", "Harga", "Stock");
    productService.showProducts();
  }

  protected void updateStockView() {
    System.out.println("");
    System.out.println("================== UPDATE STOK ===================");
    String inputIndex = scannerUtil.input("Masukkan no produk yang ingin diupdate, (x) untuk keluar");
    if (inputIndex.equals("x")) {

    } else {
      try {
        int index = Integer.parseInt(inputIndex) - 1;
        productService.checkProduct(index);
        String inputNewStock = scannerUtil.input("Masukkan stok baru");
        Integer newStock = Integer.valueOf(inputNewStock);
        productService.editProduct(index, newStock);
        System.out.println("==================================================");
        System.out.println("        STOK PAKAIAN BERHASIL DIUPDATE            ");
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

  protected void deleteProductView() {
    System.out.println("");
    System.out.println("================= HAPUS PAKAIAN ==================");
    String inputIndex = scannerUtil.input("Masukkan no produk yang ingin dihapus, (x) untuk keluar");
    if (inputIndex.equals("x")) {

    } else {
      try {
        int index = Integer.parseInt(inputIndex) - 1;
        productService.checkProduct(index);
        productService.removeProduct(index);
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
