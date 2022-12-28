package by.hayel.data.structure.list.model;

import java.util.StringJoiner;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FirstLastList {
  FirstLastLink first;
  FirstLastLink last;

  public boolean isEmpty() {
    return first == null;
  }

  public void insertFirst(int data) {
    var link = new FirstLastLink(data);
    if (isEmpty()) last = link;
    link.setNext(first);
    first = link;
  }

  public void insertLast(int data) {
    var link = new FirstLastLink(data);
    if (isEmpty()) first = link;
    else last.setNext(link);
    last = link;
  }

  public FirstLastLink deleteFirst() {
    var temp = first;
    if (first.getNext() == null) last = null;
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
    log.info(String.format("FirstLastList: [%s]", joiner));
  }
}
