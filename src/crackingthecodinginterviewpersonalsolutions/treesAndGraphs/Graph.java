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
      List<Vertex> neighboringVertices = this.adjVertices.get(currentVertex);
      for (Vertex vertex : neighboringVertices) {
        if (!visited.contains(vertex)) {
          stack.push(vertex);
          visited.add(vertex);
        }
      }
    }
    return resultVertex;
  }

  public ArrayList<Vertex> breadthFirstSearch(int startIndex) {
    HashSet<Vertex> visited = new HashSet<>();
    ArrayList<Vertex> resultVertex = new ArrayList<>();
    Queue<Vertex> queue = new LinkedList<>();
    Vertex startVertex = new Vertex(startIndex);
    queue.add(startVertex);
    visited.add(startVertex);
    while (!queue.isEmpty()) {
      Vertex currentVertex = queue.remove();
      resultVertex.add(currentVertex);
      List<Vertex> neighboringVertices = this.adjVertices.get(currentVertex);
      for (Vertex vertex : neighboringVertices) {
        if (!visited.contains(vertex)) {
          queue.add(vertex);
          visited.add(vertex);
        }
      }
    }
    return resultVertex;
  }

  private void addVertex(int label) {
    adjVertices.computeIfAbsent(new Vertex(label), vertices -> new ArrayList<>());
  }
}
