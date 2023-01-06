package by.hayel.data.structure.graph.model;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Graph {
  private static final int MAX_VERTICES = 20;

  Vertex[] vertices;
  int[][] adjacencyMatrix;
  int vertexQuantity;

  public Graph() {
    vertices = new Vertex[MAX_VERTICES];
    adjacencyMatrix = new int[MAX_VERTICES][MAX_VERTICES];
    vertexQuantity = 0;
  }

  public void addVertex(char label) {
    vertices[vertexQuantity++] = new Vertex(label);
  }

  public void addEdge(int start, int end) {
    adjacencyMatrix[start][end] = 1;
    adjacencyMatrix[end][start] = 1;
  }

  public void logVertex(int index) {
    log.info(vertices[index].toString());
  }

  public int getAdjUnvisitedVertex(int vertex) {
    for (int i = 0; i < vertexQuantity; i++)
      if (adjacencyMatrix[vertex][i] == 1 && !vertices[i].isVisited()) return i;
    return -1;
  }

  public void dfs() {
    Deque<Integer> stack = new ArrayDeque<>();
    vertices[0].setVisited(true);
    logVertex(0);
    stack.push(0);
    while (!stack.isEmpty()) {
      var vertex = getAdjUnvisitedVertex(stack.peek());
      if (vertex == -1) stack.pop();
      else {
        vertices[vertex].setVisited(true);
        logVertex(vertex);
        stack.push(vertex);
      }
    }
    resetFlags();
  }

  public void bfs() {
    Queue<Integer> queue = new ArrayDeque<>();
    vertices[0].setVisited(true);
    logVertex(0);
    queue.add(0);
    while (!queue.isEmpty()) {
      int v1 = queue.remove();
      int v2 = getAdjUnvisitedVertex(v1);
      while(v2 != -1) {
        vertices[v2].setVisited(true);
        logVertex(v2);
        queue.add(v2);
        v2 = getAdjUnvisitedVertex(v1);
      }
    }
    resetFlags();
  }

  public void mst() {
    vertices[0].setVisited(true);
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(0);
    while (!stack.isEmpty()) {
      var current = stack.peek();
      var vertex = getAdjUnvisitedVertex(current);
      if (vertex == -1) stack.pop();
      else {
        vertices[vertex].setVisited(true);
        stack.push(vertex);
        log.info("From {} to {}", vertices[current], vertices[vertex]);
      }
    }
    resetFlags();
  }

  private void resetFlags() {
    for(int j=0; j < vertexQuantity; j++)
      vertices[j].setVisited(false);
  }
}
