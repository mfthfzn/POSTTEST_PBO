package io.github.mfthfzn.service;

import io.github.mfthfzn.entity.Product;
import io.github.mfthfzn.repository.ProductRepository;

import java.util.ArrayList;

public class ProductService {

  ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public void addProduct(Product product) {
    if (!product.getSKU().isBlank() || !product.getName().isBlank() || !product.getSize().isBlank() || product.getPrice() >= 0 || product.getStock() >= 0) {
      productRepository.insert(product);
    } else {
      throw new NullPointerException("Product properties can not null!");
    }
  }

  public void showProducts() {
    ArrayList<Product> products = productRepository.getAll();
    int no = 1;
    if (products.isEmpty()) {
      System.out.println("--------------------------------------------------------------------------------------------------");
    } else {
      for (Product product : products) {
        System.out.printf("| %-2d | %-7s | %-50s | %-6s | %-7s | %-7s |\n",
                no++,
                product.getSKU(),
                product.getName(),
                product.getSize(),
                product.getPrice(),
                product.getStock());
      }
      System.out.println("--------------------------------------------------------------------------------------------------");
    }
  }

  public void checkProduct(int index) {
    if (index < 0 || productRepository.get(index) == null) throw new IndexOutOfBoundsException();
  }

  public void editProduct(int index, Integer stock) {
    Product product = productRepository.get(index);
    product.setStock(stock);

    productRepository.edit(index, product);
  }

  public void removeProduct(int index) {
    productRepository.delete(index);
  }
}
