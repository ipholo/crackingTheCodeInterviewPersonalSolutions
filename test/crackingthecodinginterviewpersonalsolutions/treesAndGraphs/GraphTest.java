/*
 * Test to Graph class.
 */
package crackingthecodinginterviewpersonalsolutions.treesAndGraphs;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://ipolo.tech
 * Test Graph:
 * 1 -> 2, 9
 * 2 -> 1
 * 3 -> 9, 4, 5, 6
 * 4 -> 3
 * 5 -> 3, 8
 * 6 -> 3, 7
 * 7 -> 6, 8, 9
 * 8 -> 5, 7
 * 9 -> 1, 3, 7
 */

public class GraphTest {

  private Graph graph;

  @Before
  public void setUp() {
    graph = new Graph();

    graph.addAllVertices(1, 2, 3, 4, 5, 6, 7, 8, 9);
    graph.addEdge(1, 2);
    graph.addEdge(1, 9);
    graph.addEdge(3, 9);
    graph.addEdge(3, 4);
    graph.addEdge(3, 5);
    graph.addEdge(3, 6);
    graph.addEdge(5, 8);
    graph.addEdge(6, 7);
    graph.addEdge(7, 8);
    graph.addEdge(7, 9);
  }

  @Test
  public void testGraph_assertVerticesAndEdgesSize() {
    assertEquals(9, graph.getAdjVertices().size());
    assertEquals(2, graph.getVertex(1).size());
    assertEquals(1, graph.getVertex(2).size());
    assertEquals(4, graph.getVertex(3).size());
    assertEquals(1, graph.getVertex(4).size());
    assertEquals(2, graph.getVertex(5).size());
    assertEquals(2, graph.getVertex(6).size());
    assertEquals(3, graph.getVertex(7).size());
    assertEquals(2, graph.getVertex(8).size());
    assertEquals(3, graph.getVertex(9).size());
  }

  @Test
  public void testGraph_assertValuesInVertices() {
    assertEquals(createVertexList(2, 9), graph.getVertex(1));
    assertEquals(createVertexList(1), graph.getVertex(2));
    assertEquals(createVertexList(9, 4, 5, 6), graph.getVertex(3));
    assertEquals(createVertexList(3), graph.getVertex(4));
    assertEquals(createVertexList(3, 8), graph.getVertex(5));
    assertEquals(createVertexList(3, 7), graph.getVertex(6));
    assertEquals(createVertexList(6, 8, 9), graph.getVertex(7));
    assertEquals(createVertexList(5, 7), graph.getVertex(8));
    assertEquals(createVertexList(1, 3, 7), graph.getVertex(9));
  }

  private List<Vertex> createVertexList(int... labels) {
    List<Vertex> vertexList = new ArrayList<>();
    for (int label : labels) {
      vertexList.add(new Vertex(label));
    }
    return vertexList;
  }
}
