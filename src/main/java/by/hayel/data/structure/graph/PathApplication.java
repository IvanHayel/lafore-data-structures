package by.hayel.data.structure.graph;

import by.hayel.data.structure.graph.model.GraphDijkstra;

public class PathApplication {
  public static void main(String[] args) {
    var graph = new GraphDijkstra();
    addVertices(graph);
    addEdges(graph);
    graph.path();
  }

  private static void addVertices(GraphDijkstra graph) {
    graph.addVertex('A');
    graph.addVertex('B');
    graph.addVertex('C');
    graph.addVertex('D');
    graph.addVertex('E');
  }

  private static void addEdges(GraphDijkstra graph) {
    graph.addEdge(0, 1, 50);
    graph.addEdge(0, 3, 80);
    graph.addEdge(1, 2, 60);
    graph.addEdge(1,3,90);
    graph.addEdge(2, 4, 40);
    graph.addEdge(3, 2, 20);
    graph.addEdge(3, 4, 70);
    graph.addEdge(4, 1, 50);
  }
}
