package io.github.mfthfzn;

import java.util.Scanner;

public class Util {

  Scanner scanner = new Scanner(System.in);

  String input(String info) {
    System.out.print(info + " : ");
    return scanner.nextLine();
  }

}
