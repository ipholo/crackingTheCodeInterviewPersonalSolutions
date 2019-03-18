/*
 * Directed Graph class.
 */
package crackingthecodinginterviewpersonalsolutions.treesAndGraphs;

import java.util.*;
import java.util.stream.Collectors;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://ipolo.tech
 */
public class Graph {
  private Map<Vertex, List<Vertex>> adjVertices;

  Graph() {
    this.adjVertices = new HashMap<>();
  }

  public Map<Vertex, List<Vertex>> getAdjVertices() {
    return adjVertices;
  }

  public void addAllVertices(int... labels) {
    for (int label : labels) {
      addVertex(label);
    }
  }

  public List<Vertex> getVertex(int label) {
    Vertex vertex = new Vertex(label);
    if (this.adjVertices.containsKey(vertex)) {
      return this.adjVertices.get(vertex);
    }
    return new ArrayList<>();
  }

  public void removeVertex(int label) {
    Vertex v = new Vertex(label);
    adjVertices.values().stream().map(e -> e.remove(v)).collect(Collectors.toList());
    adjVertices.remove(new Vertex(label));
  }

  public void addEdges(int originLabel, int... destinationLabels) {
    Vertex originVertex = new Vertex(originLabel);
    for (int destinationLabel : destinationLabels) {
      Vertex destinationVertex = new Vertex(destinationLabel);
      adjVertices.get(originVertex).add(destinationVertex);
    }
  }

  public void removeEdge(int originLabel, int destinationLabel) {
    Vertex v1 = new Vertex(originLabel);
    Vertex v2 = new Vertex(destinationLabel);
    List<Vertex> eV1 = adjVertices.get(v1);
    if (eV1 != null) {
      eV1.remove(v2);
    }
  }

  public ArrayList<Vertex> depthFirstSearch(int startIndex) {
    HashSet<Vertex> visited = new HashSet<>();
    ArrayList<Vertex> resultVertex = new ArrayList<>();
    Stack<Vertex> stack = new Stack<>();
    Vertex startVertex = new Vertex(startIndex);
    stack.push(startVertex);
    visited.add(startVertex);
    while (!stack.isEmpty()) {
      Vertex currentVertex = stack.pop();
      resultVertex.add(currentVertex);
      List<Vertex> neightboursVertex = this.adjVertices.get(currentVertex);
      for (Vertex vertex : neightboursVertex) {
        if (!visited.contains(vertex)) {
          stack.push(vertex);
          visited.add(vertex);
        }
      }
    }
    return resultVertex;
  }

  /*
   * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
   */
  public boolean routeExistsBetweenNodes(int origin, int destiny) {
    Vertex originVertex = new Vertex(origin);
    Vertex destinyVertex = new Vertex(destiny);
    if (originVertex.equals(destinyVertex)) {
      return true;
    }
    if (!this.adjVertices.containsKey(originVertex)
        || !this.adjVertices.containsKey(destinyVertex)) {
      return false;
    }
    HashSet<Vertex> visited = new HashSet<>();
    Stack<Vertex> stack = new Stack<>();
    stack.push(originVertex);
    visited.add(originVertex);
    while (!stack.isEmpty()) {
      Vertex currentVertex = stack.pop();
      List<Vertex> neightboursVertex = this.adjVertices.get(currentVertex);
      for (Vertex vertex : neightboursVertex) {
        if (!visited.contains(vertex)) {
          if (vertex.equals(destinyVertex)) {
            return true;
          }
          stack.push(vertex);
          visited.add(vertex);
        }
      }
    }
    return false;
  }

  private void addVertex(int label) {
    adjVertices.computeIfAbsent(new Vertex(label), vertices -> new ArrayList<>());
  }
}
