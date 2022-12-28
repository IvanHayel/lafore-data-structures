package by.hayel.data.structure.sort;

import by.hayel.data.structure.sort.model.ArrayInsertion;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InsertionSortApplication {
  private static final int MAX_SIZE = 30;

  public static void main(String[] args) {
    var array = new ArrayInsertion(MAX_SIZE);
    array.fillRandom();
    logArray(array);
    array.insertionSort();
    logArray(array);
  }

  public static void logArray(ArrayInsertion array) {
    log.info(array.toString());
  }
}
