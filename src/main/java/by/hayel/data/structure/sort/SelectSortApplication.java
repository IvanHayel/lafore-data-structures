package by.hayel.data.structure.sort;

import by.hayel.data.structure.sort.model.ArraySelect;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SelectSortApplication {
  private static final int MAX_SIZE = 30;

  public static void main(String[] args) {
    var array = new ArraySelect(MAX_SIZE);
    array.fillRandom();
    logArray(array);
    array.selectSort();
    logArray(array);
  }

  public static void logArray(ArraySelect array) {
    log.info(array.toString());
  }
}
