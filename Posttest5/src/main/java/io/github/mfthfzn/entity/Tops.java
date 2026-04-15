package io.github.mfthfzn.entity;

public class Tops extends Clothes {

  private String size;

  public Tops() {
  }

  public Tops(String SKU, String name, Integer stock, Integer price, String size) {
    super(SKU, name, stock, price);
    this.size = size;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  @Override
  public String getLabel() {
    return "Pakaian Atas";
  }
}
