package io.github.mfthfzn.repository;

import io.github.mfthfzn.entity.Product;

import java.util.ArrayList;

public class ProductRepository {

  final ArrayList<Product> products = new ArrayList<>(100);

  public void insert(Product product) {
    products.add(product);
  }

  public ArrayList<Product> getAll() {
    return products;
  }

  public Product get(int index) {
    return products.get(index);
  }

  public void edit(int index, Product product) {
    products.set(index, product);
  }

  public void delete(int index) {
    products.remove(index);
  }

}
