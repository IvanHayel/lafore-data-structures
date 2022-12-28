package by.hayel.data.structure.queue.model.util;

import java.util.StringJoiner;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

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

  @Override
  public String toString() {var current = first;
    var joiner = new StringJoiner(", ");
    while (current != null) {
      joiner.add(current.toString());
      current = current.getNext();
    }
    return String.format("[%s]", joiner);
  }
}
