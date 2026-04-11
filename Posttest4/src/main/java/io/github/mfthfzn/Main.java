package io.github.mfthfzn;

import io.github.mfthfzn.repository.ClothesRepository;
import io.github.mfthfzn.repository.UserRepository;
import io.github.mfthfzn.service.ClothesService;
import io.github.mfthfzn.service.LoginService;
import io.github.mfthfzn.util.ScannerUtil;
import io.github.mfthfzn.view.LoginView;
import io.github.mfthfzn.view.ClothesView;

public class Main {

  public static void main(String[] args) {

    ScannerUtil scannerUtil = new ScannerUtil();

    ClothesRepository clothesRepository = new ClothesRepository();
    ClothesService clothesService = new ClothesService(clothesRepository);
    ClothesView clothesView = new ClothesView(clothesService, scannerUtil);

    UserRepository userRepository = new UserRepository();
    LoginService loginService = new LoginService(userRepository);
    LoginView loginView = new LoginView(loginService, scannerUtil, clothesView);
    loginView.mainView();

  }

}
