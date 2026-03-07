package io.github.mfthfzn.service;

import io.github.mfthfzn.entity.Product;

import java.util.ArrayList;

public class ProductService {

  ArrayList<Product> products = new ArrayList<>(100);

  void addProduct(Product product) {
    if (product != null) {
      products.add(product);
    } else {
      throw new NullPointerException("Product can not null!");
    }
  }



}
