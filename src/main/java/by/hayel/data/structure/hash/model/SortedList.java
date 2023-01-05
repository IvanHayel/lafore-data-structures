package by.hayel.data.structure.hash.model;

import java.util.StringJoiner;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class SortedList {
  Link root;

  public SortedList() {
    root = null;
  }

  public void insert(Link link) {
    var key = link.getKey();
    Link previous = null;
    var current = root;
    while(current != null && key > current.getKey()) {
      previous = current;
      current = current.getNext();
    }
    if(previous == null) root = link;
    else previous.setNext(link);
    link.setNext(current);
  }

  public void delete(int key) {
    Link previous = null;
    var current = root;
    while(current != null && key != current.getKey()) {
      previous = current;
      current = current.getNext();
    }
    if(previous == null) root = root.getNext();
    else previous.setNext(current.getNext());
  }

  public Link find(int key) {
    var current = root;
    while(current != null && key <= current.getKey()) {
      if(current.getKey() == key) return current;
      current = current.getNext();
    }
    return null;
  }

  @Override
  public String toString() {
    var joiner = new StringJoiner(", ");
    var current = root;
    while(current != null) {
      joiner.add(current.toString());
      current = current.getNext();
    }
    return "List (first --> last): [" + joiner + "]";
  }
}
