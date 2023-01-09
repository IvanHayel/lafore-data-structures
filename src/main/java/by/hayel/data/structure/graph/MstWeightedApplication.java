package by.hayel.data.structure.graph;

import by.hayel.data.structure.graph.model.WeightedGraph;

public class MstWeightedApplication {
  public static void main(String[] args) {
    var weightedGraph = new WeightedGraph();
    addVertices(weightedGraph);
    addEdges(weightedGraph);
    weightedGraph.mstw();
  }

  private static void addVertices(WeightedGraph graph) {
    graph.addVertex('A');
    graph.addVertex('B');
    graph.addVertex('C');
    graph.addVertex('D');
    graph.addVertex('E');
    graph.addVertex('F');
  }

  private static void addEdges(WeightedGraph graph) {
    graph.addEdge(0, 1, 6);
    graph.addEdge(0, 3,4);
    graph.addEdge(1, 2, 10);
    graph.addEdge(1, 3, 7);
    graph.addEdge(1, 4, 7);
    graph.addEdge(2, 3, 8);
    graph.addEdge(2, 4, 5);
    graph.addEdge(2, 5, 6);
    graph.addEdge(3, 4, 12);
    graph.addEdge(4, 5, 7);
  }
}
