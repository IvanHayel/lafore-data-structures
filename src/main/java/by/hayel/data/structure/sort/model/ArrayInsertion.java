package by.hayel.data.structure.sort.model;

import java.util.Random;
import java.util.StringJoiner;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ArrayInsertion {
  private static final Random GENERATOR = new Random();

  final int[] array;
  final int size;

  public ArrayInsertion(int size) {
    this.size = size;
    array = new int[size];
  }

  public void fillRandom() {
    for (int i = 0; i < size; i++) array[i] = GENERATOR.nextInt(100);
  }

  public void insertionSort() {
    for(int i  = 1; i < size; i++) {
      int temp = array[i];
      int j = i;
      while(j > 0 && array[j - 1] >= temp) {
        array[j] = array[j - 1];
        j--;
      }
      array[j] = temp;
    }
  }

  @Override
  public String toString() {
    var joiner = new StringJoiner(", ");
    for (var el : array) joiner.add(String.valueOf(el));
    return String.format("[%s]", joiner.toString());
  }
}
