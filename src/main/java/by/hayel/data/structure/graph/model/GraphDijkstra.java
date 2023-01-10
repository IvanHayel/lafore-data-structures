package by.hayel.data.structure.graph.model;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GraphDijkstra {
  private static final int CAPACITY = 20;
  private static final int INFINITY = 1_000_000;

  Vertex[] vertices;
  int[][] matrix;
  int size;
  int treeSize;
  ParentDistance[] paths;
  int current;
  int distanceToCurrent;

  public GraphDijkstra() {
    vertices = new Vertex[CAPACITY];
    matrix = new int[CAPACITY][CAPACITY];
    size = 0;
    treeSize = 0;
    for (int i = 0; i < CAPACITY; i++) for (int j = 0; j < CAPACITY; j++) matrix[i][j] = INFINITY;
    paths = new ParentDistance[CAPACITY];
  }

  public void addVertex(char label) {
    vertices[size++] = new Vertex(label);
  }

  public void addEdge(int start, int end, int weight) {
    matrix[start][end] = weight;
  }

  public void path() {
    var startTree = 0;
    vertices[startTree].setVisited(true);
    treeSize++;
    for (int i = 0; i < size; i++) {
      var tempDistance = matrix[startTree][i];
      paths[i] = new ParentDistance(startTree, tempDistance);
    }
    while (treeSize < size) {
      var minIndex = getMin();
      var minDistance = paths[minIndex].getDistance();
      if (minDistance == INFINITY) {
        log.error("There are unreachable vertices!");
        break;
      } else {
        current = minIndex;
        distanceToCurrent = paths[minIndex].getDistance();
      }
      vertices[current].setVisited(true);
      treeSize++;
      adjustPaths();
    }
    logPaths();
    resetFlags();
  }

  private int getMin() {
    var minDistance = INFINITY;
    var minIndex = 0;
    for (int j = 1; j < size; j++) {
      if (!vertices[j].isVisited() && paths[j].getDistance() < minDistance) {
        minDistance = paths[j].getDistance();
        minIndex = j;
      }
    }
    return minIndex;
  }

  private void adjustPaths() {
    var column = 1;
    while (column < size) {
      if (vertices[column].isVisited()) {
        column++;
        continue;
      }
      var currentToFringe = matrix[current][column];
      var startToFringe = distanceToCurrent + currentToFringe;
      var pathDistance = paths[column].getDistance();
      if (startToFringe < pathDistance) {
        paths[column].setParent(current);
        paths[column].setDistance(startToFringe);
      }
      column++;
    }
  }

  private void logPaths() {
    var builder = new StringBuilder(System.lineSeparator());
    for(int j = 0; j < size; j++) {
      builder.append(vertices[j].getLabel()).append(" = ");
      if (paths[j].getDistance() == INFINITY) builder.append("INF");
      else builder.append(paths[j].getDistance());
      var parentLabel = vertices[paths[j].getParent()].getLabel();
      builder.append(" (through ").append(parentLabel).append("); ");
    }
    builder.append(System.lineSeparator());
    log.info(builder.toString());
  }

  private void resetFlags() {
    treeSize = 0;
    for (int i = 0; i < size; i++)
      vertices[i].setVisited(false);
  }
}
