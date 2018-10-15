/*
 * Test to Binary Tree class.
 */
package crackingthecodinginterviewpersonalsolutions.treesAndGraphs;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.LinkedList;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://www.ipolo.hol.es
 * Test Tree:
 *      1
 *    /   \
 *   2     3
 *  / \   / \
 * 4  5  6  7
 */
public final class BinaryTreeTest {

  private BinaryTree binaryTree;

  @Before
  public void setup() {
    BinaryTree leftTree = new BinaryTree(2, 4, 5);
    BinaryTree rightTree = new BinaryTree(3, 6, 7);
    binaryTree = new BinaryTree(1, leftTree.root, rightTree.root);
  }

  @Test
  public void testPreorder() {
    LinkedList<Integer> expected = new LinkedList<>();
    expected.addAll(Arrays.asList(1, 2, 4, 5, 3, 6, 7));

    LinkedList<Integer> result = binaryTree.preorder();

    assertEquals(expected, result);
  }

  @Test
  public void testInorder() {
    LinkedList<Integer> expected = new LinkedList<>();
    expected.addAll(Arrays.asList(4, 2, 5, 1, 6, 3, 7));

    LinkedList<Integer> result = binaryTree.inorder();

    assertEquals(expected, result);
  }

  @Test
  public void testPostorder() {
    LinkedList<Integer> expected = new LinkedList<>();
    expected.addAll(Arrays.asList(4, 5, 2, 6, 7, 3, 1));

    LinkedList<Integer> result = binaryTree.postorder();

    assertEquals(expected, result);
  }
}
