package io.github.mfthfzn.service;

import io.github.mfthfzn.entity.Bottoms;
import io.github.mfthfzn.repository.BottomsRepository;

import java.util.ArrayList;

public class BottomsService {

  BottomsRepository bottomsRepository;

  public BottomsService(BottomsRepository bottomsRepository) {
    this.bottomsRepository = bottomsRepository;
  }

  public void addProduct(Bottoms bottoms) {
    if (!bottoms.getSKU().isBlank() || !bottoms.getName().isBlank() || bottoms.getPrice() >= 0 || bottoms.getStock() >= 0) {
      bottomsRepository.insert(bottoms);
    } else {
      throw new NullPointerException("Product properties can not null!");
    }
  }

  public void showProducts() {
    ArrayList<Bottoms> bottoms = bottomsRepository.getAll();
    int no = 1;
    if (bottoms.isEmpty()) {
      System.out.println("--------------------------------------------------------------------------------------------------");
    } else {
      for (Bottoms bottom : bottoms) {
        System.out.printf("| %-2d | %-7s | %-50s | %-6s | %-7s | %-7s |\n",
                no++,
                bottom.getSKU(),
                bottom.getName(),
                bottom.getSize(),
                bottom.getPrice(),
                bottom.getStock());
      }
      System.out.println("--------------------------------------------------------------------------------------------------");
    }
  }

  public void checkProduct(int index) {
    if (index < 0 || bottomsRepository.get(index) == null) throw new IndexOutOfBoundsException();
  }

  public void editProduct(int index, Integer stock) {
    Bottoms bottoms = bottomsRepository.get(index);
    bottoms.setStock(stock);
    bottomsRepository.edit(index, bottoms);
  }

  public void removeProduct(int index) {
    bottomsRepository.delete(index);
  }
}