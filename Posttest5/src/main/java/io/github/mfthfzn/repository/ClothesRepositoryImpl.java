package io.github.mfthfzn.repository;

import io.github.mfthfzn.entity.Bottoms;
import io.github.mfthfzn.entity.Clothes;
import io.github.mfthfzn.entity.Tops;

import java.util.ArrayList;

public class ClothesRepositoryImpl implements ClothesRepository {

  private final ArrayList<Clothes> clothes = new ArrayList<>(100);

  @Override
  public void insert(Bottoms bottoms) {
    this.clothes.add(bottoms);
  }

  @Override
  public void insert(Tops tops) {
    this.clothes.add(tops);
  }

  @Override
  public ArrayList<Clothes> getAll() {
    return clothes;
  }

  @Override
  public Clothes get(int index) {
    return clothes.get(index);
  }

  @Override
  public void edit(int index, Clothes clothes) {
    this.clothes.set(index, clothes);
  }

  @Override
  public void delete(int index) {
    clothes.remove(index);
  }

}
