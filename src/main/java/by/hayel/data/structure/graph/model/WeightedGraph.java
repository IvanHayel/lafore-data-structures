package by.hayel.data.structure.graph.model;

import java.util.StringJoiner;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WeightedGraph {
  private static final int MAX_VERTICES = 20;
  private static final int INFINITY = Integer.MAX_VALUE;

  Vertex[] vertices;
  int[][] adjacencyMatrix;
  int size;
  int current;
  PriorityQueue queue;
  int treeSize;

  public WeightedGraph() {
    vertices = new Vertex[MAX_VERTICES];
    adjacencyMatrix = new int[MAX_VERTICES][MAX_VERTICES];
    size = 0;
    for (int j = 0; j < MAX_VERTICES; j++)
      for (int k = 0; k < MAX_VERTICES; k++) adjacencyMatrix[j][k] = INFINITY;
    queue = new PriorityQueue();
  }

  public void addVertex(char label) {
    vertices[size++] = new Vertex(label);
  }

  public void addEdge(int start, int end, int weight) {
    adjacencyMatrix[start][end] = weight;
    adjacencyMatrix[end][start] = weight;
  }

  public void logVertex(int vertex) {
    log.info(vertices[vertex].toString());
  }

  public void mstw() {
    var joiner = new StringJoiner(" ");
    while (treeSize < size - 1) {
      vertices[current].setVisited(true);
      treeSize++;
      for (int j = 0; j < size; j++) {
        if (j == current) continue;
        if (vertices[j].isVisited()) continue;
        int distance = adjacencyMatrix[current][j];
        if (distance == INFINITY) continue;
        putInPriorityQueue(j, distance);
      }
      if (queue.isEmpty()) log.error("GRAPH NOT CONNECTED");
      else {
        var edge = queue.removeMin();
        int sourceVertex = edge.getSourceVertex();
        current = edge.getDestinationVertex();
        joiner.add(vertices[sourceVertex].getLabel() + "-" + vertices[current].getLabel());
      }
    }
    log.info("Minimum spanning tree (weighted): {}", joiner);
    resetFlags();
  }

  private void putInPriorityQueue(int vertex, int distance) {
    var queueIndex = queue.find(vertex);
    if (queueIndex != -1) {
      var tempEdge = queue.peek(queueIndex);
      var oldDistance = tempEdge.getDistance();
      if (oldDistance > distance) {
        queue.remove(queueIndex);
        var edge = new Edge(current, vertex, distance);
        queue.insert(edge);
      }
    } else {
      var edge = new Edge(current, vertex, distance);
      queue.insert(edge);
    }
  }

  private void resetFlags() {
    for (int j = 0; j < size; j++) vertices[j].setVisited(false);
  }
}
