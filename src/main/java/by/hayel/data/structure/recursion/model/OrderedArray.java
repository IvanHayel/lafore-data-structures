package by.hayel.data.structure.recursion.model;

import java.util.StringJoiner;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderedArray {
  private final int[] ARRAY;
  private final int CAPACITY;

  int size;

  public OrderedArray(int capacity) {
    ARRAY = new int[capacity];
    CAPACITY = capacity;
    size = 0;
  }

  public int size() {
    return size;
  }

  public int capacity() {
    return CAPACITY;
  }

  public int find(int key) {
    return recFind(key, 0, size - 1);
  }

  private int recFind(int key, int lowerBound, int upperBound) {
    var mid = (lowerBound + upperBound) >> 1;
    if (ARRAY[mid] == key) return mid;
    if (lowerBound > upperBound) return -1;
    else {
      if (ARRAY[mid] < key) return recFind(key, mid + 1, upperBound);
      else return recFind(key, lowerBound, mid - 1);
    }
  }

  public void insert(int key) {
    int position;
    for (position = 0; position < size; position++) if (ARRAY[position] >= key) break;
    for (int i = size; i > position; i--) ARRAY[i] = ARRAY[i - 1];
    ARRAY[position] = key;
    size++;
  }

  public boolean delete(int key) {
    int position = find(key);
    if (position == -1) return false;
    for (int i = position; i < size - 1; i++) ARRAY[i] = ARRAY[i + 1];
    size--;
    return true;
  }

  @Override
  public String toString() {
    var joiner = new StringJoiner(" ");
    for (int i = 0; i < size; i++) joiner.add(String.valueOf(ARRAY[i]));
    return String.format("[%s]", joiner);
  }
}
