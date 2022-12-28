package by.hayel.data.structure.list;

import by.hayel.data.structure.list.model.DoublyLinkedList;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DoublyLinkedListApplication {
  public static void main(String[] args) {
    var list = new DoublyLinkedList();
    fill(list);
    list.logListForward();
    list.logListBackward();
    testDelete(list);
    list.logListForward();
    testInsertAfter(list);
    list.logListForward();
  }

  private static void fill(DoublyLinkedList list) {
    list.insertFirst(22);
    list.insertFirst(44);
    list.insertFirst(66);
    list.insertLast(11);
    list.insertLast(33);
    list.insertLast(55);
  }

  private static void testDelete(DoublyLinkedList list) {
    var first = list.deleteFirst();
    log.info(String.format("Deleted from first position:  %s", first));
    var last = list.deleteLast();
    log.info(String.format("Deleted from last position:  %s", last));
    var byKey = list.delete(11);
    log.info(String.format("Deleted by key %d:  %s", 11, byKey));
  }

  private static void testInsertAfter(DoublyLinkedList list) {
    boolean flag;
    flag = list.insertAfter(22, 77);
    if(flag) log.info("Key 77 inserted after 22");
    flag = list.insertAfter(33, 88);
    if(flag) log.info("Key 88 inserted after 33");
  }
}
