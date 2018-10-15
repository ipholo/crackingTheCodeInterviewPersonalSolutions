/*
 * Tests to the Personal Solutions to Chapter 4: Trees and Graphs.
 * Book: Cracking the Coding Interview.
 * The book is property of Gayle Laakmann McDowell.
 * The solutions are only educational.
 */
package crackingthecodinginterviewpersonalsolutions.treesAndGraphs;

import static crackingthecodinginterviewpersonalsolutions.treesAndGraphs.StaticMethods.isTreeBalanced;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

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
    BinaryTree tree = new BinaryTree(1, leftTree.root, rightTree.root);

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
    BinaryTree tree = new BinaryTree(1, leftTree.root, rightTree.root);

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
    BinaryTree tree = new BinaryTree(1, leftTree.root, null);

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
    BinaryTree leftLeftTree = new BinaryTree(4);
    leftLeftTree.addLeftLeaf(7);
    BinaryTree leftRightTree = new BinaryTree(5);
    BinaryTree leftTree = new BinaryTree(2, leftLeftTree.root, leftRightTree.root);
    BinaryTree rightTree = new BinaryTree(3);
    BinaryTree tree = new BinaryTree(1, leftTree.root, rightTree.root);

    boolean result = isTreeBalanced(tree);

    assertFalse(result);
  }
}
