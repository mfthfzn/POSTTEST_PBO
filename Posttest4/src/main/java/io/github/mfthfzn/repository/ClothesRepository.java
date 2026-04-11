package io.github.mfthfzn.repository;

import io.github.mfthfzn.entity.Bottoms;
import io.github.mfthfzn.entity.Clothes;
import io.github.mfthfzn.entity.Tops;

import java.util.ArrayList;

public class ClothesRepository {

  private final ArrayList<Clothes> clothes = new ArrayList<>(100);

  public void insert(Bottoms bottoms) {
    this.clothes.add(bottoms);
  }

  public void insert(Tops tops) {
    this.clothes.add(tops);
  }

  public ArrayList<Clothes> getAll() {
    return clothes;
  }

  public Clothes get(int index) {
    return clothes.get(index);
  }

  public void edit(int index, Clothes clothes) {
    this.clothes.set(index, clothes);
  }

  public void delete(int index) {
    clothes.remove(index);
  }

}
