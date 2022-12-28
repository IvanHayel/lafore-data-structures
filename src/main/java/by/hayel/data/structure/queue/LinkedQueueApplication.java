package by.hayel.data.structure.queue;

import by.hayel.data.structure.queue.model.LinkedQueue;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LinkedQueueApplication {
  public static void main(String[] args) {
    var queue = new LinkedQueue();
    fill(queue);
    queue.logQueue();
    extract(queue, 2);
    queue.logQueue();
  }

  private static void fill(LinkedQueue queue) {
    queue.insert(20);
    queue.insert(40);
    queue.insert(60);
    queue.insert(80);
  }

  private static void extract(LinkedQueue queue, int count) {
    var counter = 0;
    while(!queue.isEmpty() && count-- > 0) {
      var extracted = queue.remove();
      log.info(String.format("%d. Extracted: %s", ++counter, extracted));
    }
  }
}
