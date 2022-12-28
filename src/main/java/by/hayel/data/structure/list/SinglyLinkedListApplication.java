package by.hayel.data.structure.list;

import by.hayel.data.structure.list.model.SinglyLinkedList;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SinglyLinkedListApplication {
  public static void main(String[] args) {
    var list = new SinglyLinkedList();
    fillLinkedList(list);
    list.logList();
    tryFind(list, 44);
    tryDelete(list, 66);
    extractAll(list);
    list.logList();
  }

  private static void fillLinkedList(SinglyLinkedList list) {
    list.insertFirst(22, 2.99);
    list.insertFirst(44, 4.99);
    list.insertFirst(66, 6.99);
    list.insertFirst(88, 8.99);
  }

  private static void extractAll(SinglyLinkedList list) {
    var counter = 0;
    while (!list.isEmpty()) {
      var extracted = list.deleteFirst();
      log.info(String.format("%d. Extracted: %s", ++counter, extracted));
    }
  }

  private static void tryFind(SinglyLinkedList list, int key) {
    var link = list.find(key);
    if(link == null) log.warn(String.format("No link with key %d", key));
    else log.info(String.format("Found link with key %d: %s", key, link));
  }

  private static void tryDelete(SinglyLinkedList list, int key) {
    var link = list.delete(key);
    if(link == null) log.warn(String.format("Can't delete link with key %d", key));
    else log.info(String.format("Link with key %d successfully deleted", key));
  }
}
