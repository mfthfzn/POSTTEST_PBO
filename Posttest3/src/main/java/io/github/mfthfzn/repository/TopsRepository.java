package io.github.mfthfzn.repository;

import io.github.mfthfzn.entity.Tops;

import java.util.ArrayList;

public class TopsRepository {

  final ArrayList<Tops> tops = new ArrayList<>(100);

  public void insert(Tops tops) {
    this.tops.add(tops);
  }

  public ArrayList<Tops> getAll() {
    return tops;
  }

  public Tops get(int index) {
    return tops.get(index);
  }

  public void edit(int index, Tops tops) {
    this.tops.set(index, tops);
  }

  public void delete(int index) {
    tops.remove(index);
  }
}