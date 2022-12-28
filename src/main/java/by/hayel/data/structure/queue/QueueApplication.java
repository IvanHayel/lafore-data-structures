package by.hayel.data.structure.queue;

import by.hayel.data.structure.queue.model.Queue;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QueueApplication {
  private static final int QUEUE_CAPACITY = 5;

  private static int next = 0;

  public static void main(String[] args) {
    var queue = new Queue(QUEUE_CAPACITY);
    fill(queue, 4);
    queue.logQueue();
    extract(queue, 3);
    fill(queue, 4);
    queue.logQueue();
    extractAll(queue);
    queue.logQueue();
  }

  private static void fill(Queue queue, int count) {
    for (int i = 0; i < count; i++) queue.insert(++next);
    log.info(String.format("Queue filled with %d elements", count));
  }

  private static void extract(Queue queue, int count) {
    for (int i = 0; i < count; i++) {
      int value = queue.remove();
      log.info(String.format("%d. Extracted: %d", i + 1, value));
    }
  }

  private static void extractAll(Queue queue) {
    int counter = 0;
    while(!queue.isEmpty()) {
      log.info(String.format("%d. Extracted: %d", ++counter, queue.remove()));
    }
  }
}
