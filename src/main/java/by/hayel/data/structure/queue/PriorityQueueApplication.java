package by.hayel.data.structure.queue;

import by.hayel.data.structure.queue.model.PriorityQueue;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PriorityQueueApplication {
  private static final int MAX_SIZE = 10;

  public static void main(String[] args) {
    var queue = new PriorityQueue(MAX_SIZE);
    queue.fillRandom();
    queue.logQueue();
    extractAll(queue);
    queue.logQueue();
  }

  private static void extractAll(PriorityQueue queue) {
    var counter = 0;
    while (!queue.isEmpty()) {
      log.info(String.format("%d. Extracted: %d", ++counter, queue.remove()));
    }
  }
}
