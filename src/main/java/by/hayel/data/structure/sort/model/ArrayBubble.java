package by.hayel.data.structure.sort.model;

import java.util.Random;
import java.util.StringJoiner;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ArrayBubble {
  private static final Random GENERATOR = new Random();

  final int[] array;
  final int size;

  public ArrayBubble(int size) {
    this.size = size;
    array = new int[size];
  }

  public void fillRandom() {
    for (int i = 0; i < size; i++)
      array[i] = GENERATOR.nextInt(100);
  }

  public void bubbleSort() {
    boolean isFinished = false;
    for(int i = 0; i < size && !isFinished; i++) {
      isFinished = true;
      for(int j = 0; j < size - 1 - i; j++) {
        if(array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j+1];
          array[j+1] = temp;
          isFinished = false;
        }
      }
    }
  }

  @Override
  public String toString() {
    var joiner = new StringJoiner(", ");
    for(var el : array) joiner.add(String.valueOf(el));
    return String.format("[%s]", joiner.toString());
  }
}
