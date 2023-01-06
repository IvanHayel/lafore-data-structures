package by.hayel.data.structure.graph;

import by.hayel.data.structure.graph.model.Graph;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BfsApplication {
  public static void main(String[] args) {
    var graph = new Graph();
    addVertices(graph);
    addEdges(graph);
    log.info("BFS visits: ");
    graph.bfs();
  }

  private static void addVertices(Graph graph) {
    graph.addVertex('A');
    graph.addVertex('B');
    graph.addVertex('C');
    graph.addVertex('D');
    graph.addVertex('E');
  }

  private static void addEdges(Graph graph) {
    graph.addEdge(0, 1);
    graph.addEdge(1, 2);
    graph.addEdge(0, 3);
    graph.addEdge(3, 4);
  }
}
