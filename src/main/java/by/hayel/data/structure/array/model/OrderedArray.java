package by.hayel.data.structure.array.model;

import java.util.StringJoiner;

public class OrderedArray {
  private final int[] ARRAY;
  private final int CAPACITY;

  private int size;

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
    int low = 0;
    int high = size - 1;
    int mid;
    while (low <= high) {
      mid = (low + high) >> 1;
      if(ARRAY[mid] == key) return mid;
      if(ARRAY[mid] < key) low = mid + 1;
      else high = mid - 1;
    }
    return -1;
  }

  public void insert(int key) {
    int position;
    for(position = 0; position < size; position++)
      if(ARRAY[position] >= key) break;
    for(int i = size; i > position; i--)
      ARRAY[i] = ARRAY[i - 1];
    ARRAY[position] = key;
    size++;
  }

  public boolean delete(int key) {
    int position = find(key);
    if(position == -1) return false;
    for(int i = position; i < size - 1; i++)
      ARRAY[i] = ARRAY[i + 1];
    size--;
    return true;
  }

  @Override
  public String toString() {
    var joiner = new StringJoiner(" ");
    for (int i = 0; i < size; i++)
      joiner.add(String.valueOf(ARRAY[i]));
    return String.format("[%s]", joiner);
  }
}
