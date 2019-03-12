/*
 * Undirected Graph class.
 */
package crackingthecodinginterviewpersonalsolutions.treesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

  public void addEdge(int label1, int label2) {
    Vertex v1 = new Vertex(label1);
    Vertex v2 = new Vertex(label2);
    adjVertices.get(v1).add(v2);
    adjVertices.get(v2).add(v1);
  }

  public void removeEdge(int label1, int label2) {
    Vertex v1 = new Vertex(label1);
    Vertex v2 = new Vertex(label2);
    List<Vertex> eV1 = adjVertices.get(v1);
    List<Vertex> eV2 = adjVertices.get(v2);
    if (eV1 != null) eV1.remove(v2);
    if (eV2 != null) eV2.remove(v1);
  }

  private void addVertex(int label) {
    adjVertices.computeIfAbsent(new Vertex(label), vertices -> new ArrayList<>());
  }
}
