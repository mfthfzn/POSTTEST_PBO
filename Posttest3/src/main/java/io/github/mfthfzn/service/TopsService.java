package io.github.mfthfzn.service;

import io.github.mfthfzn.entity.Tops;
import io.github.mfthfzn.repository.TopsRepository;

import java.util.ArrayList;

public class TopsService {

  TopsRepository topsRepository;

  public TopsService(TopsRepository topsRepository) {
    this.topsRepository = topsRepository;
  }

  public void addProduct(Tops tops) {
    if (!tops.getSKU().isBlank() || !tops.getName().isBlank() || tops.getPrice() >= 0 || tops.getStock() >= 0) {
      topsRepository.insert(tops);
    } else {
      throw new NullPointerException("Product properties can not null!");
    }
  }

  public void showProducts() {
    ArrayList<Tops> tops = topsRepository.getAll();
    int no = 1;
    if (tops.isEmpty()) {
      System.out.println("--------------------------------------------------------------------------------------------------");
    } else {
      for (Tops top : tops) {
        System.out.printf("| %-2d | %-7s | %-50s | %-6s | %-7s | %-7s |\n",
                no++,
                top.getSKU(),
                top.getName(),
                top.getSize(),
                top.getPrice(),
                top.getStock());
      }
      System.out.println("--------------------------------------------------------------------------------------------------");
    }
  }

  public void checkProduct(int index) {
    if (index < 0 || topsRepository.get(index) == null) throw new IndexOutOfBoundsException();
  }

  public void editProduct(int index, Integer stock) {
    Tops tops = topsRepository.get(index);
    tops.setStock(stock);
    topsRepository.edit(index, tops);
  }

  public void removeProduct(int index) {
    topsRepository.delete(index);
  }
}