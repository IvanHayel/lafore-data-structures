package by.hayel.data.structure.sort;

import by.hayel.data.structure.sort.model.ArrayBubble;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BubbleSortApplication {
  private static final int MAX_SIZE = 30;

  public static void main(String[] args) {
    var array = new ArrayBubble(MAX_SIZE);
    array.fillRandom();
    logArray(array);
    array.bubbleSort();
    logArray(array);
  }

  public static void logArray(ArrayBubble array) {
    log.info(array.toString());
  }
}
