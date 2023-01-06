package by.hayel.data.structure.graph.model;

import java.util.StringJoiner;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DirectedGraph {
  private static final int MAX_VERTICES = 20;

  Vertex[] vertices;
  int[][] adjacencyMatrix;
  int vertexQuantity;
  char[] sorted;

  public DirectedGraph() {
    vertices = new Vertex[MAX_VERTICES];
    adjacencyMatrix = new int[MAX_VERTICES][MAX_VERTICES];
    vertexQuantity = 0;
    sorted = new char[MAX_VERTICES];
  }

  public void addVertex(char label) {
    vertices[vertexQuantity++] = new Vertex(label);
  }

  public void addEdge(int start, int end) {
    adjacencyMatrix[start][end] = 1;
  }

  public void logVertex(int index) {
    log.info(vertices[index].toString());
  }

  public void topo() {
    int originalVertexQuantity = vertexQuantity;
    while(vertexQuantity > 0) {
      var current = noSuccessors();
      if(current == -1) throw new IllegalStateException("Graph has cycle!");
      sorted[vertexQuantity - 1] = vertices[current].getLabel();
      deleteVertex(current);
    }
    var joiner = new StringJoiner(", ");
    for(int i = 0; i < originalVertexQuantity; i++)
      joiner.add(sorted[i] + "");
    log.info("Topologically sorted order: {}", joiner);
  }

  private int noSuccessors() {
    boolean isEdge;
    for(int row = 0; row < vertexQuantity; row++) {
      isEdge = false;
      for(int col = 0; col < vertexQuantity; col++) {
        if(adjacencyMatrix[row][col] > 0) {
          isEdge = true;
          break;
        }
      }
      if(!isEdge) return row;
    }
    return -1;
  }

  private void deleteVertex(int vertexToDelete) {
    if(vertexToDelete != vertexQuantity - 1) {
      for(int j = vertexToDelete; j < vertexQuantity - 1; j++)
        vertices[j] = vertices[j + 1];
      for(int row = vertexToDelete; row < vertexQuantity - 1; row++)
        moveRowUp(row, vertexQuantity);
      for(int col = vertexToDelete; col < vertexQuantity - 1; col++)
        moveColLeft(col, vertexQuantity - 1);
    }
    vertexQuantity--;
  }

  private void moveRowUp(int row, int length) {
    for(int col = 0; col < length; col++)
      adjacencyMatrix[row][col] = adjacencyMatrix[row + 1][col];
  }

  private void moveColLeft(int col, int length) {
    for(int row = 0; row < length; row++)
      adjacencyMatrix[row][col] = adjacencyMatrix[row][col + 1];
  }
}
