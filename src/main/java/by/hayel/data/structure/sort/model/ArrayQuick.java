package by.hayel.data.structure.sort.model;

import java.util.Random;
import java.util.StringJoiner;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ArrayQuick {
  private static final Random GENERATOR = new Random();

  int[] array;
  int capacity;
  int size;

  public ArrayQuick(int capacity) {
    this.capacity = capacity;
    array = new int[capacity];
    size = 0;
  }

  public void insert(int value) {
    if (size == capacity) throw new IllegalStateException("Array is full!");
    array[size] = value;
    size++;
  }

  public void fillRandom() {
    for (int i = 0; i < capacity; i++) insert(GENERATOR.nextInt(100));
  }

  public void log() {
    var joiner = new StringJoiner(", ");
    for (int i = 0; i < size; i++) joiner.add(String.valueOf(array[i]));
    log.info("Array: {}", joiner);
  }

  public void quickSort() {
    recursionQuickSort(0, size - 1);
  }

  private void recursionQuickSort(int left, int right) {
    if (right - left <= 0) return;
    int pivot = array[right];
    int partitionIndex = partition(left, right, pivot);
    recursionQuickSort(left, partitionIndex - 1);
    recursionQuickSort(partitionIndex + 1, right);
  }

  public void medianQuickSort() {
    recursionMedianQuickSort(0, size - 1);
  }

  private void recursionMedianQuickSort(int left, int right) {
    if (right - left + 1 <= 3) manualSort(left, right);
    else {
      var median = medianOf(left, right);
      int partitionIndex = medianPartition(left, right, median);
      recursionMedianQuickSort(left, partitionIndex - 1);
      recursionMedianQuickSort(partitionIndex + 1, right);
    }
  }

  private int medianOf(int left, int right) {
    var center = (left + right) >> 1;
    if (array[left] > array[center]) swap(left, center);
    if (array[left] > array[right]) swap(left, right);
    if (array[center] > array[right]) swap(center, right);
    swap(center, right - 1);
    return array[right - 1];
  }

  private void manualSort(int left, int right) {
    int size = right - left + 1;
    if (size <= 1) return;
    if (size == 2) {
      if (array[left] > array[right]) swap(left, right);
    } else {
      if (array[left] > array[right - 1]) swap(left, right - 1);
      if (array[left] > array[right]) swap(left, right);
      if (array[left + 1] > array[right]) swap(left + 1, right);
    }
  }

  private int medianPartition(int left, int right, int pivot) {
    int leftPointer = left;
    int rightPointer = right - 1;
    while (true) {
      while (array[++leftPointer] < pivot)
        ;
      while (array[--rightPointer] > pivot)
        ;
      if (leftPointer >= rightPointer) break;
      swap(leftPointer, rightPointer);
    }
    swap(leftPointer, right - 1);
    return leftPointer;
  }

  private int partition(int left, int right, int pivot) {
    int leftPointer = left - 1;
    int rightPointer = right;
    while (true) {
      while (array[++leftPointer] < pivot)
        ;
      while (rightPointer > 0 && array[--rightPointer] > pivot)
        ;
      if (leftPointer >= rightPointer) break;
      swap(leftPointer, rightPointer);
    }
    swap(leftPointer, right);
    return leftPointer;
  }

  private void swap(int first, int second) {
    var temp = array[first];
    array[first] = array[second];
    array[second] = temp;
  }
}
