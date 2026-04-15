package io.github.mfthfzn.service;

import io.github.mfthfzn.entity.Bottoms;
import io.github.mfthfzn.entity.Tops;

public interface ClothesService {

  void addProduct(Bottoms bottoms);

  void addProduct(Tops tops);

  void showProducts();

  void checkProduct(int index);

  void editProduct(int index, Integer stock);

  void removeProduct(int index);
}