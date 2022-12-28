package by.hayel.data.structure.queue.model;

import java.util.Random;
import java.util.StringJoiner;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PriorityQueue {
  private static final Random GENERATOR = new Random();
  private static final String QUEUE_IS_FULL = "Queue is full!";

  int[] queue;
  int capacity;
  int size;

  public PriorityQueue(int capacity) {
    this.capacity = capacity;
    queue = new int[capacity];
    size = 0;
  }

  public void insert(int element) {
    if (isFull()) throw new IllegalStateException(QUEUE_IS_FULL);
    if (isEmpty()) queue[size++] = element;
    else {
      int i;
      for (i = size-1; i >= 0; i--) {
        if (element > queue[i]) queue[i + 1] = queue[i];
        else break;
      }
      queue[i + 1] = element;
      size++;
    }
  }

  public int remove() {
    return queue[--size];
  }

  public int peekMin() {
    return queue[size - 1];
  }

  public boolean isFull() {
    return size == capacity;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void fillRandom() {
    for (int i = 0; i < capacity; i++) insert(GENERATOR.nextInt(100));
  }

  public void logQueue() {
    var joiner = new StringJoiner(", ");
    for (int i = 0; i < capacity; i++) joiner.add(String.valueOf(queue[i]));
    log.info(String.format("Queue: [%s]", joiner));
  }
}
