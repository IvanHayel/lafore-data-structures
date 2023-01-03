package by.hayel.data.structure.sort.model;

import java.util.Random;
import java.util.StringJoiner;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ArrayPartition {
  private static final Random GENERATOR = new Random();

  int[] array;
  int capacity;
  int size;

  public ArrayPartition(int capacity) {
    this.capacity = capacity;
    array = new int[capacity];
    size = 0;
  }

  public void insert(int value) {
    if (size == capacity) throw new IllegalStateException("Array is full!");
    array[size++] = value;
  }

  public void fillRandom() {
    for (int i = 0; i < capacity; i++) insert(GENERATOR.nextInt(199));
  }

  public int size() {
    return size;
  }

  public void log() {
    var joiner = new StringJoiner(", ");
    for (int i = 0; i < size; i++) joiner.add(String.valueOf(array[i]));
    log.info("Array: {}", joiner);
  }

  public int partitionIt(int left, int right, int pivot) {
    int leftPtr = left - 1;
    int rightPtr = right + 1;
    while (true) {
      while (leftPtr < right && array[++leftPtr] < pivot)
        ;
      while (rightPtr > left && array[--rightPtr] > pivot)
        ;
      if (leftPtr >= rightPtr) break;
      else swap(leftPtr, rightPtr);
    }
    return leftPtr;
  }

  private void swap(int first, int second) {
    var temp = array[first];
    array[first] = array[second];
    array[second] = temp;
  }
}
