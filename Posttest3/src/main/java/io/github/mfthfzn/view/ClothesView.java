package io.github.mfthfzn.view;

import io.github.mfthfzn.entity.Bottoms;
import io.github.mfthfzn.entity.Tops;
import io.github.mfthfzn.service.BottomsService;
import io.github.mfthfzn.service.TopsService;
import io.github.mfthfzn.util.ScannerUtil;

public class ClothesView {

  private final TopsService topsService;

  private final BottomsService bottomsService;

  private final ScannerUtil scannerUtil;

  public ClothesView(TopsService topsService, BottomsService bottomsService, ScannerUtil scannerUtil) {
    this.topsService = topsService;
    this.bottomsService = bottomsService;
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
        updateStockMainView();
      } else if (choice.equals("4")) {
        deleteClothesMainView();
      } else if (choice.equals("5")) {
        break;
      } else {
        System.out.println("Menu tidak tersedia");
      }
    }
    System.out.println("Berhasil Log Out");
  }

  protected void addClothesMainView() {
    System.out.println("");
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

    } else {
      System.out.println("Menu tidak tersedia");
    }
  }

  protected void addClothesTopView() {
    System.out.println("");
    System.out.println("============== TAMBAH PAKAIAN ATAS ===============");
    String SKU = scannerUtil.input("Masukkan SKU pakaian");
    String name = scannerUtil.input("Masukkan nama pakaian");
    String size = scannerUtil.input("Masukkan size pakaian (S, M, L, ...)");
    String inputPrice = scannerUtil.input("Masukkan harga pakaian");
    String inputStock = scannerUtil.input("Masukkan stok pakaian");
    try {
      Integer price = Integer.valueOf(inputPrice);
      Integer stock = Integer.valueOf(inputStock);
      topsService.addProduct(
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
    System.out.println("");
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
      bottomsService.addProduct(
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
    System.out.println("");
    System.out.println("==================================================================================================");
    System.out.println("                                 DAFTAR PRODUK PAKAIAN ATAS");
    System.out.println("==================================================================================================");
    System.out.printf("| %-2s | %-7s | %-50s | %-6s | %-7s | %-7s |\n",
            "No", "SKU", "Nama Pakaian", "Ukuran", "Harga", "Stock");
    topsService.showProducts();

    System.out.println("");
    System.out.println("==================================================================================================");
    System.out.println("                                 DAFTAR PRODUK PAKAIAN BAWAH");
    System.out.println("==================================================================================================");
    System.out.printf("| %-2s | %-7s | %-50s | %-6s | %-7s | %-7s |\n",
            "No", "SKU", "Nama Pakaian", "Ukuran", "Harga", "Stock");
    bottomsService.showProducts();
  }

  protected void updateStockMainView() {
    System.out.println("");
    System.out.println("================== UPDATE STOK ===================");
    System.out.println("[1] Pakaian Atas");
    System.out.println("[2] Pakaian Bawah");
    System.out.println("[3] Batal");

    String editChoice = scannerUtil.input("Pilih Menu");

    if (editChoice.equals("1")) {
      updateStockTopsView();
    } else if (editChoice.equals("2")) {
      updateStockBottomsView();
    } else if (editChoice.equals("3")) {

    } else {
      System.out.println("Menu tidak tersedia");
    }
  }

  protected void updateStockTopsView() {
    System.out.println("");
    System.out.println("================== UPDATE STOK ===================");
    String inputIndex = scannerUtil.input("Masukkan no produk (Pakaian atas) yang ingin diupdate, (x) untuk keluar");
    if (inputIndex.equals("x")) {

    } else {
      try {
        int index = Integer.parseInt(inputIndex) - 1;
        topsService.checkProduct(index);
        String inputNewStock = scannerUtil.input("Masukkan stok baru");
        Integer newStock = Integer.valueOf(inputNewStock);
        topsService.editProduct(index, newStock);
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

  protected void updateStockBottomsView() {
    System.out.println("");
    System.out.println("================== UPDATE STOK ===================");
    String inputIndex = scannerUtil.input("Masukkan no produk (Pakaian Bawah) yang ingin diupdate, (x) untuk keluar");
    if (inputIndex.equals("x")) {

    } else {
      try {
        int index = Integer.parseInt(inputIndex) - 1;
        bottomsService.checkProduct(index);
        String inputNewStock = scannerUtil.input("Masukkan stok baru");
        Integer newStock = Integer.valueOf(inputNewStock);
        bottomsService.editProduct(index, newStock);
        System.out.println("==================================================");
        System.out.println("        STOK PAKAIAN BAWAH BERHASIL DIUPDATE      ");
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

  protected void deleteClothesMainView() {
    System.out.println("");
    System.out.println("================== HAPUS PAKAIAN ===================");
    System.out.println("[1] Pakaian Atas");
    System.out.println("[2] Pakaian Bawah");
    System.out.println("[3] Batal");

    String deleteChoice = scannerUtil.input("Pilih Menu");

    if (deleteChoice.equals("1")) {
      deleteClothesTopsView();
    } else if (deleteChoice.equals("2")) {
      deleteClothesBottomsView();
    } else if (deleteChoice.equals("3")) {

    } else {
      System.out.println("Menu tidak tersedia");
    }
  }

  protected void deleteClothesTopsView() {
    System.out.println("");
    System.out.println("================= HAPUS PAKAIAN ==================");
    String inputIndex = scannerUtil.input("Masukkan no produk (Pakaian Atas) yang ingin dihapus, (x) untuk keluar");
    if (inputIndex.equals("x")) {

    } else {
      try {
        int index = Integer.parseInt(inputIndex) - 1;
        topsService.checkProduct(index);
        topsService.removeProduct(index);
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

  protected void deleteClothesBottomsView() {
    System.out.println("");
    System.out.println("================= HAPUS PAKAIAN ==================");
    String inputIndex = scannerUtil.input("Masukkan no produk (Pakaian Bawah) yang ingin dihapus, (x) untuk keluar");
    if (inputIndex.equals("x")) {

    } else {
      try {
        int index = Integer.parseInt(inputIndex) - 1;
        bottomsService.checkProduct(index);
        bottomsService.removeProduct(index);
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
