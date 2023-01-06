package by.hayel.data.structure.heap;

import by.hayel.data.structure.heap.model.Heap;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HeapApplication {
  private static final int HEAP_CAPACITY = 31;

  public static void main(String[] args) {
    var heap = new Heap(HEAP_CAPACITY);
    fill(heap);
    heap.logHeap();
    tryRemove(heap);
    heap.logHeap();
    tryChange(heap, 3, 100);
    heap.logHeap();
  }

  private static void fill(Heap heap) {
    heap.insert(70);
    heap.insert(40);
    heap.insert(50);
    heap.insert(20);
    heap.insert(60);
    heap.insert(100);
    heap.insert(80);
    heap.insert(30);
    heap.insert(10);
    heap.insert(90);
  }

  private static void tryRemove(Heap heap) {
    var removed = heap.remove();
    log.info("Removed: {}", removed);
  }

  private static void tryChange(Heap heap, int index, int newKey) {
    if(heap.change(index, newKey)) log.info("Changed index {} to key {}",index, newKey);
    else log.info("Index {} is not exist", index);
  }
}
