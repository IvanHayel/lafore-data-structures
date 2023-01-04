package by.hayel.data.structure.tree.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BinaryNode {
  int key;
  BinaryNode left;
  BinaryNode right;

  public BinaryNode(int key) {
    this.key = key;
  }

  @Override
  public String toString() {
    return String.format("Node {%d}", key);
  }
}
