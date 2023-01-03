package by.hayel.data.structure.sort;

import by.hayel.data.structure.sort.model.ArrayQuick;

public class QuickSortApplication {
  private static final int CAPACITY = 16;

  public static void main(String[] args) {
    var array = new ArrayQuick(CAPACITY);
    array.fillRandom();
    array.log();
    array.quickSort();
    array.log();
  }
}
