package by.hayel.data.structure.array;

import by.hayel.data.structure.array.model.HighArray;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HighArrayApplication {
  private static final Random GENERATOR = new Random();

  private static final int INITIAL_CAPACITY = 100;
  private static final int DEFAULT_QUANTITY = 10;
  private static final int TEST_KEY = 12;

  public static void main(String[] args) {
    var highArray = new HighArray(INITIAL_CAPACITY);
    int quantity = DEFAULT_QUANTITY;
    insertRandomNumbers(highArray, quantity);
    logArray(highArray);
    search(highArray, TEST_KEY);
    delete(highArray, TEST_KEY);
    logArray(highArray);
    logMax(highArray);
    removeMax(highArray);
    sort(highArray);
    distinct(highArray);
  }

  private static void insertRandomNumbers(HighArray array, int quantity) {
    int q = Math.min(quantity, array.capacity());
    for (int i = 0; i < q; i++) array.insert(GENERATOR.nextInt(20));
  }

  private static void delete(HighArray array, int key) {
    if (array.delete(key)) log.info("Element {} was deleted", key);
    else log.info("Element {} wasn't found", key);
  }

  private static void logArray(HighArray array) {
    log.info(array.toString());
  }

  private static void search(HighArray array, int key) {
    if (array.contains(key)) log.info("Found " + key);
    else log.info("Can't find " + key);
  }

  private static void logMax(HighArray highArray) {
    log.info("Max element is {}", highArray.getMax());
  }

  private static void removeMax(HighArray highArray) {
    highArray.removeMax();
    logArray(highArray);
  }

  private static void sort(HighArray array) {
    array.sort();
    logArray(array);
  }

  private static void distinct(HighArray highArray) {
    highArray.distinct();
    logArray(highArray);
  }
}
