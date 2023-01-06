package by.hayel.data.structure.graph;

import by.hayel.data.structure.graph.model.DirectedGraph;

public class TopoApplication {
  public static void main(String[] args) {
    var graph = new DirectedGraph();
    addVertices(graph);
    addEdges(graph);
    graph.topo();
  }

  private static void addVertices(DirectedGraph graph) {
    graph.addVertex('A');
    graph.addVertex('B');
    graph.addVertex('C');
    graph.addVertex('D');
    graph.addVertex('E');
    graph.addVertex('F');
    graph.addVertex('G');
    graph.addVertex('H');
  }

  private static void addEdges(DirectedGraph graph) {
    graph.addEdge(0, 3);
    graph.addEdge(0, 4);
    graph.addEdge(1, 4);
    graph.addEdge(2, 5);
    graph.addEdge(3, 6);
    graph.addEdge(4, 6);
    graph.addEdge(5, 7);
    graph.addEdge(6, 7);
  }
}
