package io.github.mfthfzn;

import io.github.mfthfzn.repository.ProductRepository;
import io.github.mfthfzn.repository.UserRepository;
import io.github.mfthfzn.service.LoginService;
import io.github.mfthfzn.service.ProductService;
import io.github.mfthfzn.util.ScannerUtil;
import io.github.mfthfzn.view.LoginView;
import io.github.mfthfzn.view.ProductView;

public class Main {

  public static void main(String[] args) {

    ScannerUtil scannerUtil = new ScannerUtil();

    ProductRepository productRepository = new ProductRepository();
    ProductService productService = new ProductService(productRepository);
    ProductView productView = new ProductView(productService, scannerUtil);

    UserRepository userRepository = new UserRepository();
    LoginService loginService = new LoginService(userRepository);
    LoginView loginView = new LoginView(loginService, scannerUtil, productView);
    loginView.mainView();

  }

}
