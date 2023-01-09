package by.hayel.data.structure.graph.model;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class PriorityQueue {
  private static final int CAPACITY = 20;

  Edge[] queue;
  int size;

  public PriorityQueue() {
    queue = new Edge[CAPACITY];
    size = 0;
  }

  public void insert(Edge edge) {
    int j;
    for(j =0; j < size; j++)
      if(edge.getDistance() >= queue[j].getDistance())
        break;
    for(int k = size -1; k >= j; k--)
      queue[k+1] = queue[k];
    queue[j] = edge;
    size++;
  }

  public Edge removeMin() {
    return queue[--size];
  }

  public void remove(int position) {
    for(int j = 0; j < position; j++)
      queue[j] = queue[j+ position];
    size -= position;
  }

  public Edge peekMin() {
    return queue[size-1];
  }

  public Edge peek(int position) {
    return queue[position];
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int find(int destination) {
    for(int i = 0; i < size; i++)
      if(queue[i].getDestinationVertex() == destination)
        return i;
    return -1;
  }
}
