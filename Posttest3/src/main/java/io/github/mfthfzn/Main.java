package io.github.mfthfzn;

import io.github.mfthfzn.repository.BottomsRepository;
import io.github.mfthfzn.repository.TopsRepository;
import io.github.mfthfzn.repository.UserRepository;
import io.github.mfthfzn.service.BottomsService;
import io.github.mfthfzn.service.LoginService;
import io.github.mfthfzn.service.TopsService;
import io.github.mfthfzn.util.ScannerUtil;
import io.github.mfthfzn.view.LoginView;
import io.github.mfthfzn.view.ClothesView;

public class Main {

  public static void main(String[] args) {

    ScannerUtil scannerUtil = new ScannerUtil();

    TopsRepository topsRepository = new TopsRepository();
    BottomsRepository bottomsRepository = new BottomsRepository();
    TopsService topsService = new TopsService(topsRepository);
    BottomsService bottomsService = new BottomsService(bottomsRepository);

    ClothesView clothesView = new ClothesView(topsService, bottomsService, scannerUtil);

    UserRepository userRepository = new UserRepository();
    LoginService loginService = new LoginService(userRepository);
    LoginView loginView = new LoginView(loginService, scannerUtil, clothesView);
    loginView.mainView();

  }

}
