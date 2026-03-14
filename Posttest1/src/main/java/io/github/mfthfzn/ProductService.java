package io.github.mfthfzn;

import java.util.ArrayList;

public class ProductService {

  ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  void addProduct(Product product) {
    if (!product.SKU.isBlank() || !product.name.isBlank() || !product.size.isBlank() || product.price >= 0 || product.stock >= 0) {
      productRepository.insert(product);
    } else {
      throw new NullPointerException("Product properties can not null!");
    }
  }

  void showProducts() {
    ArrayList<Product> products = productRepository.getAll();
    int no = 1;
    if (products.isEmpty()) {
      System.out.println("--------------------------------------------------------------------------------------------------");
    } else {
      for (Product product : products) {
        System.out.printf("| %-2d | %-7s | %-50s | %-6s | %-7s | %-7s |\n",
                no++,
                product.SKU,
                product.name,
                product.size,
                product.price,
                product.stock);
      }
      System.out.println("--------------------------------------------------------------------------------------------------");
    }
  }

  void checkProduct(int index) {
    if (index < 0 || productRepository.get(index) == null) throw new IndexOutOfBoundsException();
  }

  void editProduct(int index, Integer stock) {
    Product product = productRepository.get(index);
    product.stock = stock;

    productRepository.edit(index, product);
  }

  void removeProduct(int index) {
    productRepository.delete(index);
  }
}
