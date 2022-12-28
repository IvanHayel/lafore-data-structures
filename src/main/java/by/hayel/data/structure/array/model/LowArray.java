package by.hayel.data.structure.array.model;

public class LowArray {
  private static final int DEFAULT_CAPACITY = 10;

  private final int[] ARRAY;

  public LowArray(int size) {
    if(size < 1) size = DEFAULT_CAPACITY;
    ARRAY = new int[size];
  }

  public void setElement(int index, int value) {
    if(index >= ARRAY.length) throw new IllegalArgumentException();
    ARRAY[index] = value;
  }

  public int getElement(int index) {
    if(index >= ARRAY.length) throw new IllegalArgumentException();
    return ARRAY[index];
  }

  public int size() {
    return ARRAY.length;
  }
}
