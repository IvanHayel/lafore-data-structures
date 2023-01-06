package by.hayel.data.structure.sort.model;

import java.util.StringJoiner;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Heap {
  Node[] heap;
  int capacity;
  int size;

  public Heap(int capacity) {
    this.capacity = capacity;
    heap = new Node[capacity];
    size = 0;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean isFull() {
    return size == capacity;
  }

  public boolean insert(int key) {
    if(isFull()) return false;
    var node = new Node(key);
    heap[size] = node;
    trickleUp(size++);
    return true;
  }

  public void insertAt(int index, Node node) {
    heap[index] = node;
  }

  public void incrementSize() {
    size++;
  }

  public void trickleUp(int index) {
    int parent = (index - 1) / 2;
    var bottom = heap[index];
    while (index > 0 && heap[parent].getKey() < bottom.getKey()) {
      heap[index] = heap[parent];
      index = parent;
      parent = (parent - 1) / 2;
    }
    heap[index] = bottom;
  }

  public Node remove() {
    if(isEmpty()) return null;
    var root = heap[0];
    heap[0] = heap[--size];
    trickleDown(0);
    return root;
  }

  public void trickleDown(int index) {
    int largerChild;
    var top = heap[index];
    while (index < size / 2) {
      int leftChild = 2 * index + 1;
      int rightChild = leftChild + 1;
      if (rightChild < size && heap[leftChild].getKey() < heap[rightChild].getKey())
        largerChild = rightChild;
      else largerChild = leftChild;
      if (top.getKey() >= heap[largerChild].getKey()) break;
      heap[index] = heap[largerChild];
      index = largerChild;
    }
    heap[index] = top;
  }

  public boolean change(int index, int newKey) {
    if(index < 0 || index >= size) return false;
    var temp = heap[index].getKey();
    heap[index].setKey(newKey);
    if(temp < newKey) trickleUp(index);
    else trickleDown(index);
    return true;
  }

  public void logHeap() {
    var joiner = new StringJoiner(", ");
    for(int m = 0; m < size; m++)
      if(heap[m] != null) joiner.add(heap[m].toString());
      else joiner.add("--");
    log.info("Heap (array format): {}", joiner);
    var builder = new StringBuilder();
    var blanks = 32;
    var itemsPerRow = 1;
    var column = 0;
    int current = 0;
    log.info(".".repeat(62));
    while(size > 0) {
      if(column == 0)
        for(int k = 0; k < blanks; k++)
          builder.append(" ");
      builder.append(heap[current]);
      if(++current == size) break;
      if(++column == itemsPerRow) {
        blanks /= 2;
        itemsPerRow *= 2;
        column = 0;
        builder.append(System.lineSeparator());
      } else {
        for(int k = 0; k < blanks * 2 - 2; k++)
          builder.append(" ");
      }
    }
    log.info(String.format("%nHEAP%n%s", builder));
    log.info(".".repeat(62));
  }
}
