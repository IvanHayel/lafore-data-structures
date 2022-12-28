package by.hayel.data.structure.queue.model;

import java.util.StringJoiner;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Queue {
  int[] queue;
  int capacity;
  int size;
  int front;
  int rear;

  public Queue(int capacity) {
    this.capacity = capacity;
    queue = new int[capacity];
    size = 0;
    front = 0;
    rear = -1;
  }

  public void insert(int value) {
    if(rear == capacity - 1) rear = -1;
    queue[++rear] = value;
    size++;
  }

  public int remove() {
    var temp = queue[front++];
    if(front == capacity) front = 0;
    size--;
    return temp;
  }

  public int peekFront() {
    return queue[front];
  }

  public boolean isEmpty() {
    return size == 0;
  }

  private boolean isFull() {
    return size == capacity;
  }

  public int size() {
    return size;
  }

  public void logQueue() {
    var joiner = new StringJoiner(", ");
    for(int i = 0; i < capacity; i++) joiner.add(String.valueOf(queue[i]));
    log.info(String.format("Queue: [%s]", joiner));
  }
}
