package by.hayel.data.structure.list.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public class ListIterator {
  IteratorLink current;
  IteratorLink previous;
  IteratorLinkedList list;

  public ListIterator(IteratorLinkedList list) {
    this.list = list;
    reset();
  }

  public void reset() {
    current = list.getFirst();
    previous = null;
  }

  public boolean hasNext() {
    return current.getNext() != null;
  }

  public void next() {
    previous = current;
    current = current.getNext();
  }

  public void insertAfter(int data) {
    var link = new IteratorLink(data);
    if(list.isEmpty()) {
      list.setFirst(link);
      current = link;
    } else {
      link.setNext(current.getNext());
      current.setNext(link);
      next();
    }
  }

  public void insertBefore(int data) {
    var link = new IteratorLink(data);
    if(previous == null) {
      link.setNext(list.getFirst());
      list.setFirst(link);
      reset();
    } else {
      link.setNext(previous.getNext());
      previous.setNext(link);
      current = link;
    }
  }

  public IteratorLink deleteCurrent() {
    var deleted = current;
    if(previous == null) {
      list.setFirst(current.getNext());
      reset();
    } else {
      previous.setNext(current.getNext());
      if(!hasNext()) reset();
      else current = current.getNext();
    }
    return deleted;
  }
}
