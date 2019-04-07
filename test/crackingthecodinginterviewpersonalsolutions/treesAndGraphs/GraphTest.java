/*
 * Test to Graph class.
 */
package crackingthecodinginterviewpersonalsolutions.treesAndGraphs;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://ipolo.tech
 * Test Graph:
 *
 * 1 -> 2, 9
 * 2 -> 4, 9
 * 3 -> 9, 4, 5, 6
 * 4 -> 3
 * 5 -> 8
 * 6 -> 7
 * 7 -> 6, 8, 9
 * 8 -> 1
 * 9 -> 4, 6
 *
 * ·-----→ 1 → 2 → 11
 * |       ↓   |
 * 8 ← 7 → 9 ←-|
 * ↑   ↕ ↙ ↑ ↘ ↓
 * |   6 ← 3   4
 * |       ↓ ↘
 * ·------ 5  10
 */

public class GraphTest {

  private Graph graph;

  @Before
  public void setUp() {
    this.graph = getTestGraph();
  }

  @Test
  public void testGraph_assertVerticesAndEdgesSize() {
    assertEquals(11, graph.getAdjVertices().size());
    assertEquals(2, graph.getVertex(1).size());
    assertEquals(3, graph.getVertex(2).size());
    assertEquals(4, graph.getVertex(3).size());
    assertEquals(0, graph.getVertex(4).size());
    assertEquals(1, graph.getVertex(5).size());
    assertEquals(1, graph.getVertex(6).size());
    assertEquals(3, graph.getVertex(7).size());
    assertEquals(1, graph.getVertex(8).size());
    assertEquals(2, graph.getVertex(9).size());
  }

  @Test
  public void testGraph_assertValuesInVertices() {
    assertEquals(createVertexList(2, 9), graph.getVertex(1));
    assertEquals(createVertexList(4, 9, 11), graph.getVertex(2));
    assertEquals(createVertexList(5, 6, 9, 10), graph.getVertex(3));
    assertEquals(createVertexList(8), graph.getVertex(5));
    assertEquals(createVertexList(7), graph.getVertex(6));
    assertEquals(createVertexList(6, 8, 9), graph.getVertex(7));
    assertEquals(createVertexList(1), graph.getVertex(8));
    assertEquals(createVertexList(4, 6), graph.getVertex(9));
  }

  @Test
  public void testGraph_depthFirstSearch_assertResult_startIndexOne() {
    ArrayList<Vertex> result = graph.depthFirstSearch(1);
    ArrayList<Vertex> expected = createVertexList(1, 9, 6, 7, 8, 4, 2, 11);

    assertEquals(expected, result);
  }

  @Test
  public void testGraph_depthFirstSearch_assertResult_startIndexTwo() {
    ArrayList<Vertex> result = graph.depthFirstSearch(2);
    ArrayList<Vertex> expected = createVertexList(2, 11, 9, 6, 7, 8, 1, 4);

    assertEquals(expected, result);
  }

  @Test
  public void testGraph_depthFirstSearch_assertResult_startIndexThree() {
    ArrayList<Vertex> result = graph.depthFirstSearch(3);
    ArrayList<Vertex> expected = createVertexList(3, 10, 9, 4, 6, 7, 8, 1, 2, 11, 5);

    assertEquals(expected, result);
  }

  @Test
  public void testGraph_breadthFirstSearch_assertResult_startIndexOne() {
    ArrayList<Vertex> result = graph.breadthFirstSearch(1);
    ArrayList<Vertex> expected = createVertexList(1, 2, 9, 4, 11, 6, 7, 8);

    assertEquals(expected, result);
  }

  @Test
  public void testGraph_breadthFirstSearch_assertResult_startIndexTwo() {
    ArrayList<Vertex> result = graph.breadthFirstSearch(2);
    ArrayList<Vertex> expected = createVertexList(2, 4, 9, 11, 6, 7, 8, 1);

    assertEquals(expected, result);
  }

  @Test
  public void testGraph_breadthFirstSearch_assertResult_startIndexThree() {
    ArrayList<Vertex> result = graph.breadthFirstSearch(3);
    ArrayList<Vertex> expected = createVertexList(3, 5, 6, 9, 10, 8, 7, 4, 1, 2, 11);

    assertEquals(expected, result);
  }

  static Graph getTestGraph() {
    Graph graph = new Graph();
    graph.addAllVertices(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
    graph.addEdges(1, 2, 9);
    graph.addEdges(2, 4, 9, 11);
    graph.addEdges(3, 5, 6, 9, 10);
    graph.addEdges(5, 8);
    graph.addEdges(6, 7);
    graph.addEdges(7, 6, 8, 9);
    graph.addEdges(8, 1);
    graph.addEdges(9, 4, 6);
    return graph;
  }

  private ArrayList<Vertex> createVertexList(int... labels) {
    ArrayList<Vertex> vertexList = new ArrayList<>();
    for (int label : labels) {
      vertexList.add(new Vertex(label));
    }
    return vertexList;
  }
}
