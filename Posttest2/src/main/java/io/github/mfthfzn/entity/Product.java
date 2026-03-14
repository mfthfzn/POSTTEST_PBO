package io.github.mfthfzn.entity;

public class Product {

  private String SKU;

  private String name;

  private String size;

  private Integer stock;

  private Integer price;

  public Product(String SKU, String name, String size, Integer stock, Integer price) {
    this.SKU = SKU;
    this.name = name;
    this.size = size;
    this.stock = stock;
    this.price = price;
  }

  public Product() {
  }

  public String getSKU() {
    return SKU;
  }

  public void setSKU(String SKU) {
    this.SKU = SKU;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public Integer getStock() {
    return stock;
  }

  public void setStock(Integer stock) {
    this.stock = stock;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }
}
