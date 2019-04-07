/*
 * Tests to the Personal Solutions to Chapter 4: Trees and Graphs.
 * Book: Cracking the Coding Interview.
 * The book is property of Gayle Laakmann McDowell.
 * The solutions are only educational.
 */
package crackingthecodinginterviewpersonalsolutions.treesAndGraphs;

import static crackingthecodinginterviewpersonalsolutions.treesAndGraphs.StaticMethods.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import apple.laf.JRSUIUtils;
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
  public void convertArrayToBinaryTree_assertResult() {
    /*
     *        5
     *      /  \
     *     2    8
     *    /\   / \
     *   1 3  6  9
     *  /    /  /
     * 4    7  10
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
     *  /   /  /
     * 4   7  10
     */
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    BinaryTree tree = convertArrayToBinaryTree(array);
    List<List> expected = new LinkedList<>();
    expected.add(getBinaryTreeListFromArray(5));
    expected.add(getBinaryTreeListFromArray(2, 8));
    expected.add(getBinaryTreeListFromArray(1, 3, 6, 9));
    expected.add(getBinaryTreeListFromArray(4, 7, 10));

    List<List<BinaryTree>> result = createListOfEachDepthInATree(tree);

    assertEquals(expected, result);
  }

  private List<BinaryTree> getBinaryTreeListFromArray(int... elements) {
    List<BinaryTree> list = new LinkedList<>();
    for (int element : elements) {
      list.add(new BinaryTree(element));
    }
    return list;
  }
}
