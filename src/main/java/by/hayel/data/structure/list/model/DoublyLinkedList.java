package by.hayel.data.structure.list.model;

import java.util.StringJoiner;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DoublyLinkedList {
  DoublyLink first;
  DoublyLink last;

  public boolean isEmpty() {
    return first == null;
  }

  public void insertFirst(int data) {
    var link = new DoublyLink(data);
    if (isEmpty()) last = link;
    else first.setPrevious(link);
    link.setNext(first);
    first = link;
  }

  public void insertLast(int data) {
    var link = new DoublyLink(data);
    if (isEmpty()) first = link;
    else {
      last.setNext(link);
      link.setPrevious(last);
    }
    last = link;
  }

  public DoublyLink deleteFirst() {
    var temp = first;
    if (first.getNext() == null) last = null;
    else first.getNext().setPrevious(null);
    first = first.getNext();
    return temp;
  }

  public DoublyLink deleteLast() {
    var temp = last;
    if (first.getNext() == null) first = null;
    else last.getPrevious().setNext(null);
    last = last.getPrevious();
    return temp;
  }

  public boolean insertAfter(int key, int data) {
    var current = first;
    while (current != null && current.getData() != key) {
      current = current.getNext();
    }
    if (current != null) {
      var link = new DoublyLink(data);
      if (current == last) {
        link.setNext(null);
        last = link;
      } else {
        link.setNext(current.getNext());
        current.getNext().setPrevious(link);
      }
      link.setPrevious(current);
      current.setNext(link);
      return true;
    }
    return false;
  }

  public DoublyLink delete(int key) {
    var current = first;
    while (current != null && current.getData() != key) {
      current = current.getNext();
    }
    if (current != null) {
      if(current == first) first = current.getNext();
      else current.getPrevious().setNext(current.getNext());
      if(current == last) last = current.getPrevious();
      else current.getNext().setPrevious(current.getPrevious());
      return current;
    }
    return null;
  }

  public void logListForward() {
    var joiner  = new StringJoiner(", ");
    var current = first;
    while(current != null) {
      joiner.add(current.toString());
      current = current.getNext();
    }
    log.info(String.format("DoublyLinkedList (forward): %s", joiner));
  }

  public void logListBackward() {
    var joiner = new StringJoiner(", ");
    var current = last;
    while(current != null) {
      joiner.add(current.toString());
      current = current.getPrevious();
    }
    log.info(String.format("DoublyLinkedList (backward): %s", joiner));
  }
}
