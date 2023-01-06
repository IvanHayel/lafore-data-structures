package by.hayel.data.structure.heap.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Node {
  int key;

  @Override
  public String toString() {
    return String.valueOf(key);
  }
}
