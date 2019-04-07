/*
 * Tests to the Personal Solutions to Chapter 4: Trees and Graphs.
 * Book: Cracking the Coding Interview.
 * The book is property of Gayle Laakmann McDowell.
 * The solutions are only educational.
 */
package crackingthecodinginterviewpersonalsolutions.treesAndGraphs;

import static crackingthecodinginterviewpersonalsolutions.treesAndGraphs.GraphTest.getTestGraph;
import static crackingthecodinginterviewpersonalsolutions.treesAndGraphs.StaticMethods.*;
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public final class StaticMethodsTest {

  @Test
  public void isTreeBalanced_completeTree_assertTrue() {
    /*
     * Test Tree:
     *      1
     *    /   \
     *   2     3
     *  / \   / \
     * 4  5  6  7
     */
    BinaryTree leftTree = new BinaryTree(2, 4, 5);
    BinaryTree rightTree = new BinaryTree(3, 6, 7);
    BinaryTree tree = new BinaryTree(1, leftTree, rightTree);

    boolean result = isTreeBalanced(tree);

    assertTrue(result);
  }

  @Test
  public void isTreeBalanced_oneHeightDifferent_assertTrue() {
    /*
     * Test Tree:
     *      1
     *    /  \
     *   2   3
     *  / \
     * 4  5
     */
    BinaryTree leftTree = new BinaryTree(2, 4, 5);
    BinaryTree rightTree = new BinaryTree(3);
    BinaryTree tree = new BinaryTree(1, leftTree, rightTree);

    boolean result = isTreeBalanced(tree);

    assertTrue(result);
  }

  @Test
  public void isTreeBalanced_halfTree_assertFalse() {
    /*
     * Test Tree:
     *     1
     *    /
     *   2
     *  / \
     * 4  5
     */
    BinaryTree leftTree = new BinaryTree(2, 4, 5);
    BinaryTree tree = new BinaryTree(1, leftTree, null);

    boolean result = isTreeBalanced(tree);

    assertFalse(result);
  }

  @Test
  public void isTreeBalanced_twoHeightDifferent_assertFalse() {
    /*
     * Test Tree:
     *       1
     *      / \
     *     2  3
     *    / \
     *   4  5
     *  /
     * 7
     */
    BinaryTree leftLeftTree = new BinaryTree(4, new BinaryTree(7), null);
    BinaryTree leftRightTree = new BinaryTree(5);
    BinaryTree leftTree = new BinaryTree(2, leftLeftTree, leftRightTree);
    BinaryTree rightTree = new BinaryTree(3);
    BinaryTree tree = new BinaryTree(1, leftTree, rightTree);

    boolean result = isTreeBalanced(tree);

    assertFalse(result);
  }

  @Test
  public void routeExistsBetweenNodes_nodeDontExist() {
    /*
     * This graph is used throughout all tests.
     * ·-----→ 1 → 2 → 11
     * |       ↓   |
     * 8 ← 7 → 9 ←-|
     * ↑   ↕ ↙ ↑ ↘ ↓
     * |   6 ← 3   4
     * |       ↓ ↘
     * ·------ 5  10
     */
    Graph testGraph = getTestGraph();

    boolean result = routeExistsBetweenNodes(testGraph, 1, 12);

    assertFalse(result);
  }

  @Test
  public void routeExistsBetweenNodes_assertTrue() {
    Graph testGraph = getTestGraph();

    boolean result = routeExistsBetweenNodes(testGraph, 1, 6);

    assertTrue(result);
  }

  @Test
  public void routeExistsBetweenNodes_assertFalse_10to11() {
    Graph testGraph = getTestGraph();

    boolean result = routeExistsBetweenNodes(testGraph, 10, 11);

    assertFalse(result);
  }

  @Test
  public void routeExistsBetweenNodes_assertFalse_1to3() {
    Graph testGraph = getTestGraph();

    boolean result = routeExistsBetweenNodes(testGraph, 1, 3);

    assertFalse(result);
  }

  @Test
  public void convertArrayToBinaryTree_assertResult() {
    /*
     *        5
     *      /  \
     *     2   8
     *    /\  / \
     *   1 3 6  9
     *     \  \  \
     *     4  7  10
     */
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int expectedHeight = 4;

    BinaryTree tree = convertArrayToBinaryTree(array);

    assertEquals(expectedHeight, tree.getHeight());
  }

  @Test
  public void createListOfEachDepthInATree_assertResult() {
    /*
     *        5
     *      /  \
     *     2   8
     *    /\  / \
     *   1 3 6  9
     *     \  \  \
     *     4  7  10
     */
    BinaryTree tree = convertArrayToBinaryTree(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
    List<List> expected = new LinkedList<>();
    expected.add(getBinaryTreeListFromArray(5));
    expected.add(getBinaryTreeListFromArray(2, 8));
    expected.add(getBinaryTreeListFromArray(1, 3, 6, 9));
    expected.add(getBinaryTreeListFromArray(4, 7, 10));

    List<List<BinaryTree>> result = createListOfEachDepthInATree(tree);

    assertEquals(expected, result);
  }

  @Test
  public void getNextNodeInBinaryTree_assertResult_nodeOneToNine() {
    BinaryTree tree = convertArrayToBinaryTreeWithParent(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});

    for(int i = 1; i < 10; i++) {
      BinaryTree expected = new BinaryTree(i + 1);
      BinaryTree result = getNextNodeInBinaryTree(tree, new BinaryTree(i));

      assertEquals(expected, result);
    }
  }

  @Test
  public void getNextNodeInBinaryTree_assertResult_nodeTen() {
    BinaryTree tree = convertArrayToBinaryTreeWithParent(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});

    BinaryTree result = getNextNodeInBinaryTree(tree, new BinaryTree(10));

    assertNull(result);
  }

  private List<BinaryTree> getBinaryTreeListFromArray(int... elements) {
    List<BinaryTree> list = new LinkedList<>();
    for (int element : elements) {
      list.add(new BinaryTree(element));
    }
    return list;
  }

  private static BinaryTree convertArrayToBinaryTreeWithParent(int[] array) {
    return convertArrayToBinaryTreeWithParent(array, 0, array.length - 1);
  }

  private static BinaryTree convertArrayToBinaryTreeWithParent(int[] array, int start, int end) {
    if (end < start) {
      return null;
    }
    int middle = (start + end) / 2;
    BinaryTree tree = new BinaryTree(array[middle]);
    tree.left = convertArrayToBinaryTreeWithParent(array, start, middle - 1);
    tree.right = convertArrayToBinaryTreeWithParent(array, middle + 1, end);
    if(tree.left != null) {
      tree.left.parent = tree;
    }
    if(tree.right != null) {
      tree.right.parent = tree;
    }
    return tree;
  }
}
