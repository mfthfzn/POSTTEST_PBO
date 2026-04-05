package io.github.mfthfzn.repository;

import io.github.mfthfzn.entity.Bottoms;

import java.util.ArrayList;

public class BottomsRepository {

  final ArrayList<Bottoms> bottoms = new ArrayList<>(100);

  public void insert(Bottoms bottoms) {
    this.bottoms.add(bottoms);
  }

  public ArrayList<Bottoms> getAll() {
    return bottoms;
  }

  public Bottoms get(int index) {
    return bottoms.get(index);
  }

  public void edit(int index, Bottoms bottoms) {
    this.bottoms.set(index, bottoms);
  }

  public void delete(int index) {
    bottoms.remove(index);
  }
}