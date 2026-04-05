package io.github.mfthfzn.view;

import io.github.mfthfzn.service.LoginService;
import io.github.mfthfzn.util.ScannerUtil;

public class LoginView {

  private final LoginService loginService;

  private final ScannerUtil scannerUtil;

  private final ClothesView clothesView;

  public LoginView(LoginService loginService, ScannerUtil scannerUtil, ClothesView clothesView) {
    this.loginService = loginService;
    this.scannerUtil = scannerUtil;
    this.clothesView = clothesView;
  }

  public void mainView() {
    String choice;
    while (true) {

      System.out.println();
      System.out.println("================== MAIN MENU ====================");
      System.out.println("[1] Login");
      System.out.println("[2] Keluar");
      System.out.println("================================================");

      choice = scannerUtil.input("Pilih Menu");

      if (choice.equals("1")) {
        loginView();
      } else if (choice.equals("2")) {
        break;
      } else {
        System.out.println("Menu tidak tersedia");
      }
    }
    System.out.println("Keluar");
  }

  void loginView() {
    System.out.println("");
    System.out.println("================= LOGIN ==================");
    String username = scannerUtil.input("Masukkan username");
    String password = scannerUtil.input("Masukkan password");
    try {
      loginService.auth(username, password);
      System.out.println("==================================================");
      System.out.println("                 LOGIN BERHASIL");
      System.out.println("==================================================");
      clothesView.mainView();
    } catch (RuntimeException exception) {
      System.out.println("==================================================");
      System.out.println("           USERNAME ATAU PASSWORD SALAH");
      System.out.println("==================================================");
    }
  }

}
