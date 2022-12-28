package by.hayel.data.structure.array.model;

import java.util.StringJoiner;

public class HighArray {
  private int[] ARRAY;

  private int size;

  public HighArray(final int capacity) {
    if(capacity < 1) throw new IllegalArgumentException();
    size = 0;
    ARRAY = new int[capacity];
  }

  public boolean contains(final int key) {
    for(int element: ARRAY)
      if(element == key)
        return true;
    return false;
  }

  public void insert(final int key) {
    if(size < ARRAY.length) {
      ARRAY[size] = key;
      size++;
    }
  }

  public boolean delete(final int key) {
    for(int i = 0; i < size; i++) {
      if(ARRAY[i] == key) {
        shift(i);
        return true;
      }
    }
    return false;
  }

  private void shift(int from) {
    for(int i = from; i < size - 1; i++)
      ARRAY[i] = ARRAY[i + 1];
    ARRAY[size - 1] = 0;
    size--;
  }

  public int size() {
    return size;
  }

  public int capacity() {
    return ARRAY.length;
  }

  public int getMax() {
    if(size == 0) return -1;
    var max = 0;
    for(int i = 0; i < size; i++)
      if(ARRAY[i] > ARRAY[max])
        max = i;
    return ARRAY[max];
  }

  public void removeMax() {
    if(size == 0) return;
    delete(getMax());
  }

  public void sort() {
    var sortedArray = new HighArray(capacity());
    while (size() > 0){
      int max = getMax();
      removeMax();
      sortedArray.insert(max);
    }
    this.size = sortedArray.size;
    this.ARRAY = sortedArray.ARRAY.clone();
    if (size >= 0)
      System.arraycopy(sortedArray.ARRAY, 0, ARRAY, 0, size);
  }

  public void distinct() {
    for(int i = 0; i < size; i++)
      for(int j = i + 1; j < size; j++)
        if(ARRAY[i] == ARRAY[j])
          delete(ARRAY[j]);
  }

  @Override
  public String toString() {
    var joiner = new StringJoiner(" ");
    for (int i = 0; i < size; i++)
      joiner.add(String.valueOf(ARRAY[i]));
    return String.format("[%s]", joiner);
  }
}
