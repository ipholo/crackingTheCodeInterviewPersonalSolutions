/*
 * Personal Solutions to Chapter 4: Trees and Graphs.
 * Book: Cracking the Coding Interview.
 * The book is property of Gayle Laakmann McDowell.
 * The solutions are only educational.
 */
package crackingthecodinginterviewpersonalsolutions.treesAndGraphs;

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
   * Given a sorted (increasing order) array, write an algorithm to create a binary tree with minimal height.
   */
  static BinaryTree convertArrayToBinaryTree(int[] array) {
    return convertArrayToBinaryTree(array, 0, array.length - 1);
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
