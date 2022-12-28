package by.hayel.data.structure.list;

import by.hayel.data.structure.list.model.FirstLastList;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FirstLastListApplication {
  public static void main(String[] args) {
    var list = new FirstLastList();
    fill(list);
    list.logList();
    extract(list, 2);
    list.logList();
  }

  private static void fill(FirstLastList list) {
    list.insertFirst(22);
    list.insertFirst(44);
    list.insertFirst(66);
    list.insertLast(11);
    list.insertLast(33);
    list.insertLast(55);
  }

  private static void extract(FirstLastList list, int count) {
    var counter = 0;
    while (!list.isEmpty() && count-- > 0) {
      var extracted = list.deleteFirst();
      log.info(String.format("%d. Extracted: %s", ++counter, extracted));
    }
  }
}
