package by.hayel.data.structure.array;

import by.hayel.data.structure.array.model.OrderedArray;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderedArrayApplication {
  private static final Random GENERATOR = new Random();

  private static final int INITIAL_CAPACITY = 100;
  private static final int DEFAULT_QUANTITY = 10;
  private static final int TEST_KEY = 12;

  public static void main(String[] args){
    OrderedArray orderedArray = new OrderedArray(INITIAL_CAPACITY);
    int quantity = DEFAULT_QUANTITY;
    insertRandomNumbers(orderedArray, quantity);
    logArray(orderedArray);
    search(orderedArray, TEST_KEY);
    delete(orderedArray, TEST_KEY);
    logArray(orderedArray);
  }

  private static void insertRandomNumbers(OrderedArray array, int quantity) {
    int q = Math.min(quantity, array.capacity());
    for (int i = 0; i < q; i++)
      array.insert(GENERATOR.nextInt(20));
  }

  private static void delete(OrderedArray array, int key) {
    if(array.delete(key)) log.info("Element {} was deleted", key);
    else log.info("Element {} wasn't found", key);
  }

  private static void logArray(OrderedArray array) {
    log.info(array.toString());
  }

  private static void search(OrderedArray array, int key) {
    int position = array.find(key);
    if (position >= 0) log.info("Element {} was found at index {}", key, position);
    else log.info("Can't find " + key);
  }
}
