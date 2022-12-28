package by.hayel.data.structure.sort.model;

import java.util.Random;
import java.util.StringJoiner;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ArraySelect {
  private static final Random GENERATOR = new Random();

  final int[] array;
  final int size;

  public ArraySelect(int size) {
    this.size = size;
    array = new int[size];
  }

  public void fillRandom() {
    for (int i = 0; i < size; i++) array[i] = GENERATOR.nextInt(100);
  }

  public void selectSort() {
    int min;
    for (int i = 0; i < size - 1; i++) {
      min = i;
      for (int j = i + 1; j < size; j++) {
        if (array[j] < array[min]) min = j;
      }
      var temp = array[min];
      array[min] = array[i];
      array[i] = temp;
    }
  }

  @Override
  public String toString() {
    var joiner = new StringJoiner(", ");
    for (var el : array) joiner.add(String.valueOf(el));
    return String.format("[%s]", joiner.toString());
  }
}
