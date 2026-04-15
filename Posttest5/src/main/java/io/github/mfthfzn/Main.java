package io.github.mfthfzn;

import io.github.mfthfzn.repository.UserRepositoryImpl;
import io.github.mfthfzn.service.ClothesServiceImpl;
import io.github.mfthfzn.service.LoginServiceImpl;
import io.github.mfthfzn.util.ScannerUtil;
import io.github.mfthfzn.view.LoginView;
import io.github.mfthfzn.view.ClothesView;

public class Main {

  public static void main(String[] args) {

    ScannerUtil scannerUtil = new ScannerUtil();

    io.github.mfthfzn.repository.ClothesRepositoryImpl clothesRepositoryImpl = new io.github.mfthfzn.repository.ClothesRepositoryImpl();
    ClothesServiceImpl clothesServiceImpl = new ClothesServiceImpl(clothesRepositoryImpl);
    ClothesView clothesView = new ClothesView(clothesServiceImpl, scannerUtil);

    UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl();
    LoginServiceImpl loginServiceImpl = new LoginServiceImpl(userRepositoryImpl);
    LoginView loginView = new LoginView(loginServiceImpl, scannerUtil, clothesView);
    loginView.mainView();

  }

}
