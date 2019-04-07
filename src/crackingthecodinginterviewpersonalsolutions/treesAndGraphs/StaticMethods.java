/*
 * Personal Solutions to Chapter 4: Trees and Graphs.
 * Book: Cracking the Coding Interview.
 * The book is property of Gayle Laakmann McDowell.
 * The solutions are only educational.
 */
package crackingthecodinginterviewpersonalsolutions.treesAndGraphs;

import java.util.*;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://www.ipolo.hol.es
 */
public class StaticMethods {

  /*
   * Implement a function to check if a tree is balanced. For the purposes of this question,
   * a balanced tree is defined to be a tree such that no two leaf nodes differ in distance
   * from the root by more than one.
   */
  static boolean isTreeBalanced(BinaryTree binaryTree) {
    int maxHeight = getMaxHeight(binaryTree, 0);
    int minHeight = getMinHeight(binaryTree, 0);
    return maxHeight - minHeight < 2;
  }

  /*
   * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
   */
  static boolean routeExistsBetweenNodes(Graph graph, int origin, int destiny) {
    Vertex originVertex = new Vertex(origin);
    Vertex destinyVertex = new Vertex(destiny);
    if (originVertex.equals(destinyVertex)) {
      return true;
    }
    if (!graph.getAdjVertices().containsKey(originVertex)
        || !graph.getAdjVertices().containsKey(destinyVertex)) {
      return false;
    }
    HashSet<Vertex> visited = new HashSet<>();
    Stack<Vertex> stack = new Stack<>();
    stack.push(originVertex);
    visited.add(originVertex);
    while (!stack.isEmpty()) {
      Vertex currentVertex = stack.pop();
      List<Vertex> neighborsVertex = graph.getAdjVertices().get(currentVertex);
      for (Vertex vertex : neighborsVertex) {
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

  /*
   * Given a sorted (increasing order) array, write an algorithm to create a binary tree with minimal height.
   */
  static BinaryTree convertArrayToBinaryTree(int[] array) {
    return convertArrayToBinaryTree(array, 0, array.length - 1);
  }

  /*
   * Given a binary search tree, design an algorithm which creates a linked list of all the nodes at each depth (i e ,
   * if you have a tree with depth D, you’ll have D linked lists)
   */
  static List<List<BinaryTree>> createListOfEachDepthInATree(BinaryTree binaryTree) {
    List<BinaryTree> listATDepthZero = Collections.singletonList(binaryTree);
    List<List<BinaryTree>> listOfEachDepth =
        new LinkedList<>(Collections.singletonList(listATDepthZero));
    Queue<BinaryTree> queue = new LinkedList<>(listATDepthZero);
    while (!queue.isEmpty()) {
      Queue<BinaryTree> queuePerDepth = new LinkedList<>();
      LinkedList<BinaryTree> list = new LinkedList<>();
      for (BinaryTree tree : queue) {
        if (tree.left != null) {
          list.add(tree.left);
          queuePerDepth.add(tree.left);
        }
        if (tree.right != null) {
          list.add(tree.right);
          queuePerDepth.add(tree.right);
        }
      }
      if (!list.isEmpty()) {
        listOfEachDepth.add(list);
      }
      queue = queuePerDepth;
    }
    return listOfEachDepth;
  }

  private static BinaryTree convertArrayToBinaryTree(int[] array, int start, int end) {
    if (end < start) {
      return null;
    }
    int middle = (start + end) / 2;
    BinaryTree tree = new BinaryTree(array[middle]);
    tree.left = convertArrayToBinaryTree(array, start, middle - 1);
    tree.right = convertArrayToBinaryTree(array, middle + 1, end);
    return tree;
  }

  private static int getMaxHeight(BinaryTree binaryTree, int height) {
    if (binaryTree == null) {
      return height;
    }
    int heightLeft = getMaxHeight(binaryTree.left, height) + 1;
    int heightRight = getMaxHeight(binaryTree.right, height) + 1;
    return Math.max(heightLeft, heightRight);
  }

  private static int getMinHeight(BinaryTree binaryTree, int height) {
    if (binaryTree == null) {
      return height;
    }
    int heightLeft = getMinHeight(binaryTree.left, height) + 1;
    int heightRight = getMinHeight(binaryTree.right, height) + 1;
    return Math.min(heightLeft, heightRight);
  }
}
