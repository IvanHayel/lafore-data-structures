package by.hayel.data.structure.recursion;

import by.hayel.data.structure.recursion.model.OrderedArray;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RecursionBinarySearchApplication {
  private static final int CAPACITY = 100;
  private static final int ELEMENT_TO_FIND = 27;

  public static void main(String[] args) {
    var array = new OrderedArray(CAPACITY);
    fill(array);
    logArray(array);
    var index = array.find(ELEMENT_TO_FIND);
    if(index > 0) log.info("Element {} is found at index {}", ELEMENT_TO_FIND, index);
    else log.info("Element {} isn't found", ELEMENT_TO_FIND);
  }

  private static void logArray(OrderedArray array) {
    log.info(String.format("OrderedArray %s", array.toString()));
  }

  private static void fill(OrderedArray array) {
    array.insert(72);
    array.insert(90);
    array.insert(45);
    array.insert(126);
    array.insert(54);
    array.insert(99);
    array.insert(144);
    array.insert(27);
    array.insert(135);
    array.insert(81);
    array.insert(18);
    array.insert(108);
    array.insert(9);
    array.insert(117);
    array.insert(63);
    array.insert(36);
  }
}
