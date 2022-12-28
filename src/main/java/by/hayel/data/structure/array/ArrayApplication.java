package by.hayel.data.structure.array;

import java.util.Arrays;
import java.util.Random;
import java.util.StringJoiner;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArrayApplication {
  private static final Random GENERATOR = new Random();

  private static final int INITIAL_CAPACITY = 100;
  private static final int DEFAULT_QUANTITY = 10;
  private static final int TEST_INDEX = 1;
  private static final int TEST_KEY = 12;

  public static void main(String[] args){
    int[] numbers = new int[INITIAL_CAPACITY];
    int quantity = DEFAULT_QUANTITY;
    insertRandomNumbers(numbers, quantity);
    logArray(numbers, quantity);
    search(numbers[TEST_INDEX], numbers);
    search(TEST_KEY, numbers);
    delete(numbers[TEST_INDEX], numbers, quantity);
    delete(TEST_KEY, numbers, quantity);
  }

  private static void insertRandomNumbers(int[] array, int quantity) {
    int q = Math.min(array.length, quantity);
    for(int i = 0; i < q; i++) array[i] = GENERATOR.nextInt(100);
  }

  private static void logArray(int[] array, int quantity) {
    int q = Math.min(array.length, quantity);
    var joiner = new StringJoiner(" ");
    Arrays.stream(array).limit(q).forEach(num -> joiner.add(String.valueOf(num)));
    log.info(String.format("[%s]", joiner));
  }

  private static void search(int key, int[] array) {
    for(int i = 0; i < array.length; i++)
      if(array[i] == key) {
        log.info(String.format("Found %d at index %d", key, i));
        return;
      }
    log.info(String.format("Not found %d", key));
  }

  private static void delete(int key, int[] array, int quantity) {
    int q = Math.min(array.length, quantity);
    for(int i = 0; i < q; i++)
      if(array[i] == key) {
        log.info(String.format("Deleted %d at index %d", key, i));
        shift(array, i, q - 1);
        return;
      }
    log.info(String.format("Not found %d", key));
  }

  private static void shift(int[] array, int from, int to) {
    for(int i = from; i < to; i++) array[i] = array[i + 1];
    array[to] = 0;
    logArray(array, to);
    }
}
