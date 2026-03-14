package io.github.mfthfzn;

import java.util.ArrayList;

public class ProductRepository {

  ArrayList<Product> products = new ArrayList<>(100);

  void insert(Product product) {
    if (!product.SKU.isBlank() || !product.name.isBlank() || product.price >= 0) {
      products.add(product);
    } else {
      throw new NullPointerException("Product properties can not null!");
    }
  }

  ArrayList<Product> getAll() {
    return products;
  }

  Product get(int index) {
    return products.get(index);
  }

  void edit(int index, Product product) {
    products.set(index, product);
  }

  void delete(int index) {
    products.remove(index);
  }

}
