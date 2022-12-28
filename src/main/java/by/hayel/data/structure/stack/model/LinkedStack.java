package by.hayel.data.structure.stack.model;

import by.hayel.data.structure.stack.model.util.SinglyLinkedList;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LinkedStack {
  SinglyLinkedList list;

  public LinkedStack() {
    list = new SinglyLinkedList();
  }

  public void push(int data) {
    list.insertFirst(data);
  }

  public int pop() {
    return list.deleteFirst().getData();
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }

  public void logStack() {
    log.info("LinkedStack: {}", list);
  }
}
