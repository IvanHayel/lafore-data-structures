package by.hayel.data.structure.list.model;

import java.util.StringJoiner;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class SinglyLinkedList {
  SinglyLink first;

  public void insertFirst(int iData, double dData) {
    var link = new SinglyLink(iData, dData);
    link.setNext(first);
    first = link;
  }

  public SinglyLink find(int key) {
    var current = first;
    while(current.getIntegerData() != key) {
      if (current.getNext() == null) return null;
      current = current.getNext();
    }
    return current;
  }

  public SinglyLink delete(int key) {
    if(isEmpty()) return null;
    var current = first;
    var previous = first;
    while (current.getIntegerData() != key) {
      if(current.getNext() == null) return null;
      else {
        previous = current;
        current = current.getNext();
      }
    }
    if(current == first) first = first.getNext();
    else previous.setNext(current.getNext());
    return current;
  }

  public SinglyLink deleteFirst() {
    var temp = first;
    first = first.getNext();
    return temp;
  }

  public void logList() {
    var current = first;
    var joiner = new StringJoiner(", ");
    while (current != null) {
      joiner.add(current.toString());
      current = current.getNext();
    }
    log.info(String.format("SinglyLinkedList: [%s]", joiner));
  }

  public boolean isEmpty() {
    return first == null;
  }
}
