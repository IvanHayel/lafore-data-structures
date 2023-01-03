package by.hayel.data.structure.sort.model;

import java.util.Random;
import java.util.StringJoiner;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ArrayShell {
  private static final Random GENERATOR = new Random();

  int[] array;
  int capacity;
  int size;

  public ArrayShell(int capacity) {
    this.capacity = capacity;
    array = new int[capacity];
    size = 0;
  }

  public void insert(int value) {
    if (size == capacity) throw new IllegalStateException("Array is full!");
    array[size] = value;
    size++;
  }

  public void fillRandom() {
    for (int i = 0; i < capacity; i++)
      insert(GENERATOR.nextInt(100));
  }

  public void log() {
    var joiner = new StringJoiner(", ");
    for (int i = 0; i < size; i++) joiner.add(String.valueOf(array[i]));
    log.info(String.format("Array: [%s]", joiner));
  }

  public void shellSort() {
    int inner, outer, temp;
    int h = 1;
    while (h <= size / 3) h = h * 3 + 1;
    while (h > 0) {
      for (outer = h; outer < size; outer++) {
        temp = array[outer];
        inner = outer;
        while (inner > h - 1 && array[inner - h] >= temp) {
          array[inner] = array[inner - h];
          inner -= h;
        }
        array[inner] = temp;
      }
      h = (h - 1) / 3;
    }
  }
}
