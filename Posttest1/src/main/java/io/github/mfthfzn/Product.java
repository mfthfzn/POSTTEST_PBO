package io.github.mfthfzn;

public class Product {

  String SKU;

  String name;

  String size;

  Integer stock;

  Integer price;

  public Product(String SKU, String name, String size, Integer stock, Integer price) {
    this.SKU = SKU;
    this.name = name;
    this.size = size;
    this.stock = stock;
    this.price = price;
  }
}
