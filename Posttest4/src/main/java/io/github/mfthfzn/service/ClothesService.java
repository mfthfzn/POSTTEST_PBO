package io.github.mfthfzn.service;

import io.github.mfthfzn.entity.Bottoms;
import io.github.mfthfzn.entity.Clothes;
import io.github.mfthfzn.entity.Tops;
import io.github.mfthfzn.repository.ClothesRepository;

import java.util.ArrayList;

public class ClothesService {

  private final ClothesRepository clothesRepository;

  public ClothesService(ClothesRepository clothesRepository) {
    this.clothesRepository = clothesRepository;
  }

  public void addProduct(Bottoms bottoms) {
    if (!bottoms.getSKU().isBlank() || !bottoms.getName().isBlank() || bottoms.getPrice() >= 0 || bottoms.getStock() >= 0) {
      clothesRepository.insert(bottoms);
    } else {
      throw new NullPointerException("Product properties can not null!");
    }
  }

  public void addProduct(Tops tops) {
    if (!tops.getSKU().isBlank() || !tops.getName().isBlank() || tops.getPrice() >= 0 || tops.getStock() >= 0) {
      clothesRepository.insert(tops);
    } else {
      throw new NullPointerException("Product properties can not null!");
    }
  }

  public void showProducts() {
    ArrayList<Clothes> clothes = clothesRepository.getAll();
    int no = 1;
    if (clothes.isEmpty()) {
      System.out.println("------------------------------------------------------------------------------------------------------------------");
    } else {
      for (Clothes clothe : clothes) {
        if (clothe instanceof Tops) {
          Tops tops = (Tops) clothe;
          System.out.printf("| %-2d | %-7s | %-13s | %-50s | %-6s | %-7s | %-7s |\n",
                  no++,
                  tops.getSKU(),
                  tops.getLabel(),
                  tops.getName(),
                  tops.getSize(),
                  tops.getPrice(),
                  tops.getStock());
        } else if (clothe instanceof Bottoms) {
          Bottoms bottom = (Bottoms) clothe;
          System.out.printf("| %-2d | %-7s | %-13s | %-50s | %-6s | %-7s | %-7s |\n",
                  no++,
                  bottom.getSKU(),
                  bottom.getLabel(),
                  bottom.getName(),
                  bottom.getSize(),
                  bottom.getPrice(),
                  bottom.getStock());
        }
      }
      System.out.println("------------------------------------------------------------------------------------------------------------------");
    }
  }

  public void checkProduct(int index) {
    if (index < 0 || clothesRepository.get(index) == null) throw new IndexOutOfBoundsException();
  }

  public void editProduct(int index, Integer stock) {
    Clothes clothes = clothesRepository.get(index);
    clothes.setStock(stock);
    clothesRepository.edit(index, clothes);
  }

  public void removeProduct(int index) {
    clothesRepository.delete(index);
  }

}
