package by.hayel.data.structure.list.model;

import java.util.StringJoiner;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SortedLinkedList {
  SortedLink first;

  public boolean isEmpty() {
    return first == null;
  }

  public void insert(int data) {
    var link = new SortedLink(data);
    var current = first;
    SortedLink previous = null;
    while (current != null && current.getData() < data) {
      previous = current;
      current = current.getNext();
    }
    if (previous == null) first = link;
    else previous.setNext(link);
    link.setNext(current);
  }

  public SortedLink remove() {
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
    log.info(String.format("SortedLinkedList: [%s]", joiner));
  }
}
