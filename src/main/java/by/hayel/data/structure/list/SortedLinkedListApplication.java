package by.hayel.data.structure.list;

import by.hayel.data.structure.list.model.SortedLinkedList;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SortedLinkedListApplication {
  public static void main(String[] args) {
    var list = new SortedLinkedList();
    fill(list);
    list.logList();
    extract(list, 1);
    list.logList();
  }

  private static void fill(SortedLinkedList list) {
    list.insert(20);
    list.insert(40);
    list.insert(10);
    list.insert(30);
    list.insert(50);
  }

  private static void extract(SortedLinkedList list, int count) {
    var counter = 0;
    while(!list.isEmpty() && count-- > 0) {
      var extracted = list.remove();
      log.info(String.format("%d. Extracted: %s", ++counter, extracted));
    }
  }
}
