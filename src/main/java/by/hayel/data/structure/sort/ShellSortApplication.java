package by.hayel.data.structure.sort;

import by.hayel.data.structure.sort.model.ArrayShell;

public class ShellSortApplication {
  private static final int CAPACITY = 10;

  public static void main(String[] args) {
    var array = new ArrayShell(CAPACITY);
    array.fillRandom();
    array.log();
    array.shellSort();
    array.log();
  }
}
