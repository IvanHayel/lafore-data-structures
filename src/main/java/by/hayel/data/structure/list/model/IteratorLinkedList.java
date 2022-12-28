package by.hayel.data.structure.list.model;

import java.util.StringJoiner;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class IteratorLinkedList {
  IteratorLink first;

  public boolean isEmpty() {
    return first == null;
  }

  public ListIterator getIterator() {
    return new ListIterator(this);
  }

  public void logList() {
    var joiner = new StringJoiner(", ");
    var current = first;
    while (current != null) {
      joiner.add(current.toString());
      current = current.getNext();
    }
    log.info(String.format("IteratorLinkedList [%s]", joiner));
  }
}
