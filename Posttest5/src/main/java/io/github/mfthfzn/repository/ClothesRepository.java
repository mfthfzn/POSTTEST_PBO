package io.github.mfthfzn.repository;

import io.github.mfthfzn.entity.Bottoms;
import io.github.mfthfzn.entity.Clothes;
import io.github.mfthfzn.entity.Tops;

import java.util.ArrayList;

public interface ClothesRepository {

  void insert(Bottoms bottoms);

  void insert(Tops tops);

  ArrayList<Clothes> getAll();

  Clothes get(int index);

  void edit(int index, Clothes clothes);

  void delete(int index);

}
