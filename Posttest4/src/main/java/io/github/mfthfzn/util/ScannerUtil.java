package io.github.mfthfzn.util;

import java.util.Scanner;

public class ScannerUtil {

  private final Scanner scanner = new Scanner(System.in);

  public String input(String info) {
    System.out.print(info + " : ");
    return scanner.nextLine();
  }

}
