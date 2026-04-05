package io.github.mfthfzn.entity;

public class Bottoms extends Clothes {

  private Integer size;

  public Bottoms() {
  }

  public Bottoms(String SKU, String name, Integer stock, Integer price, Integer size) {
    super(SKU, name, stock, price);
    this.size = size;
  }

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }
}
