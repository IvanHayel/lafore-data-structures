package by.hayel.data.structure.sort.model;

import java.util.StringJoiner;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ArrayMerge {
  int[] array;
  int capacity;
  int size;

  public ArrayMerge(int capacity) {
    array = new int[capacity];
    this.capacity = capacity;
    size = 0;
  }

  public void insert(int value) {
    if (size == capacity) throw new IllegalStateException("Array is full");
    array[size++] = value;
  }

  public void log() {
    var joiner = new StringJoiner(", ");
    for (int i = 0; i < size; i++) joiner.add(String.valueOf(array[i]));
    log.info("Array: [{}]", joiner);
  }

  public void mergeSort() {
    var space = new int[size];
    recursionMergeSort(space, 0, size - 1);
  }

  private void recursionMergeSort(int[] space, int lowerBound, int upperBound) {
    if(lowerBound == upperBound) return;
    else {
      var mid = (lowerBound + upperBound) >> 1;
      recursionMergeSort(space, lowerBound, mid);
      recursionMergeSort(space, mid + 1, upperBound);
      merge(space, lowerBound, mid + 1, upperBound);
    }
  }

  private void merge(int[] space, int low, int high, int upperBound) {
    int j = 0;
    int lowerBound = low;
    int mid = high - 1;
    int n = upperBound - lowerBound + 1;
    while (low <= mid && high <= upperBound)
      if (array[low] < array[high]) space[j++] = array[low++];
      else space[j++] = array[high++];
    while (low <= mid) space[j++] = array[low++];
    while (high <= upperBound) space[j++] = array[high++];
    for (j = 0; j < n; j++) array[lowerBound + j] = space[j];
  }
}
