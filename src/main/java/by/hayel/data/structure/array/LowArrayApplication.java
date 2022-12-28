package by.hayel.data.structure.array;

import by.hayel.data.structure.array.model.LowArray;
import java.util.Random;
import java.util.StringJoiner;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LowArrayApplication {
  private static final Random GENERATOR = new Random();

  private static final int INITIAL_CAPACITY = 100;
  private static final int DEFAULT_QUANTITY = 10;
  private static final int TEST_INDEX = 1;
  private static final int TEST_KEY = 12;

  public static void main(String[] args){
    LowArray lowArray = new LowArray(INITIAL_CAPACITY);
    int quantity = DEFAULT_QUANTITY;
    insertRandomNumbers(lowArray, quantity);
    logArray(lowArray, quantity);
    search(lowArray, lowArray.getElement(TEST_INDEX));
    search(lowArray, TEST_KEY);
    delete(lowArray, lowArray.getElement(TEST_INDEX), quantity);
    delete(lowArray, TEST_KEY, quantity);
  }

  private static void insertRandomNumbers(LowArray array, int quantity) {
    int q = Math.min(quantity, array.size());
    for (int i = 0; i < q; i++)
      array.setElement(i, GENERATOR.nextInt(100));
  }

  private static void logArray(LowArray array, int quantity) {
    int q = Math.min(quantity, array.size());
    var joiner = new StringJoiner(" ");
    for (int i = 0; i < q; i++)
      joiner.add(String.valueOf(array.getElement(i)));
    log.info(String.format("[%s]", joiner));
  }

  private static void search(LowArray array, int key) {
    for(int i = 0; i < array.size(); i++)
      if(array.getElement(i) == key) {
        log.info(String.format("Found %d at index %d", key, i));
        return;
      }
    log.info(String.format("Not found %d", key));
  }

  private static void delete(LowArray array, int key, int quantity) {
    int q = Math.min(array.size(), quantity);
    for(int i = 0; i < q; i++)
      if(array.getElement(i) == key) {
        log.info(String.format("Deleted %d at index %d", key, i));
        shift(array, i, q - 1);
        return;
      }
    log.info(String.format("Not found %d", key));
  }

  private static void shift(LowArray array, int from, int to) {
    for(int i = from; i < to; i++) array.setElement(i, array.getElement(i+1));
    array.setElement(to, 0);
    logArray(array, to);
  }
}
