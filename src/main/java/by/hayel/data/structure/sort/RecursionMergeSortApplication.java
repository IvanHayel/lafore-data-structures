package by.hayel.data.structure.sort;

import by.hayel.data.structure.sort.model.ArrayMerge;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RecursionMergeSortApplication {
  private static final int CAPACITY = 100;

  public static void main(String[] args) {
    var array = new ArrayMerge(CAPACITY);
    fill(array);
    array.log();
    array.mergeSort();
    array.log();
  }

  private static void fill(ArrayMerge array) {
    array.insert(64);
    array.insert(21);
    array.insert(33);
    array.insert(70);
    array.insert(12);
    array.insert(85);
    array.insert(44);
    array.insert(3);
    array.insert(99);
    array.insert(0);
    array.insert(108);
    array.insert(36);
  }
}
