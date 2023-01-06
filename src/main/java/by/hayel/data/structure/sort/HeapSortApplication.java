package by.hayel.data.structure.sort;

import by.hayel.data.structure.sort.model.Heap;
import by.hayel.data.structure.sort.model.Node;
import java.util.Random;
import java.util.StringJoiner;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HeapSortApplication {
  private static final Random GENERATOR = new Random();
  private static final int HEAP_CAPACITY = 10;

  public static void main(String[] args) {
    var size = HEAP_CAPACITY;
    var heap = new Heap(size);
    fill(heap, size);
    heap.logHeap();
    toPyramid(heap, size);
    heap.logHeap();
    showSorted(heap, size);
  }

  private static void fill(Heap heap, int size) {
    for (int i = 0; i < size; i++) {
      var random = GENERATOR.nextInt(100);
      var node = new Node(random);
      heap.insertAt(i, node);
      heap.incrementSize();
    }
  }

  private static void toPyramid(Heap heap, int size) {
    for (int j = size - 1; j >= 0; j--) heap.trickleDown(j);
  }

  private static void showSorted(Heap heap, int size) {
    var joiner = new StringJoiner(", ");
    for (int i = 0; i < size; i++) {
      joiner.add(heap.remove().toString());
    }
    log.info("Sorted: {}", joiner);
  }
}
