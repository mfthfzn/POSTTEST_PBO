package io.github.mfthfzn;

public class Main {

  public static void main(String[] args) {

    Util util = new Util();
    ProductRepository productRepository = new ProductRepository();
    ProductService productService = new ProductService(productRepository);
    ProductView productView = new ProductView(productService, util);
    productView.mainView();

  }

}
