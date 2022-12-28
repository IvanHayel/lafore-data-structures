package by.hayel.data.structure.queue.model;

import by.hayel.data.structure.queue.model.util.FirstLastList;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LinkedQueue {
  FirstLastList list;

  public LinkedQueue() {
    list = new FirstLastList();
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }

  public void insert(int data) {
    list.insertLast(data);
  }

  public int remove() {
    return list.deleteFirst().getData();
  }

  public void logQueue() {
    log.info("LinkedQueue: {}", list);
  }
}
