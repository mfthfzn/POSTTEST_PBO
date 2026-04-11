package io.github.mfthfzn.entity;

public class Clothes {

  private String SKU;

  private String name;

  private Integer stock;

  private Integer price;

  public Clothes(String SKU, String name, Integer stock, Integer price) {
    this.SKU = SKU;
    this.name = name;
    this.stock = stock;
    this.price = price;
  }

  public Clothes() {
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

  public String getLabel() {
    return "Pakaian";
  }
}
