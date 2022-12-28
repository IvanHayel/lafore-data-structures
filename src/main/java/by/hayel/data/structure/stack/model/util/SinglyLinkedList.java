package by.hayel.data.structure.stack.model.util;

import java.util.StringJoiner;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class SinglyLinkedList {
  SinglyLink first;

  public boolean isEmpty() {
    return first == null;
  }

  public void insertFirst(int data) {
    var link = new SinglyLink(data);
    link.setNext(first);
    first = link;
  }

  public SinglyLink deleteFirst() {
    var temp = first;
    first = first.getNext();
    return temp;
  }

  @Override
  public String toString() {
    var current = first;
    var joiner = new StringJoiner(", ");
    while (current != null) {
      joiner.add(current.toString());
      current = current.getNext();
    }
    return String.format("[%s]", joiner);
  }
}
