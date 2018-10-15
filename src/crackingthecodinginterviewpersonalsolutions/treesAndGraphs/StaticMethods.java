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
    int maxHeight = getMaxHeight(binaryTree.root, 0);
    int minHeight = getMinHeight(binaryTree.root, 0);
    return maxHeight - minHeight < 2;
  }

  private static int getMaxHeight(Leaf leaf, int height) {
    if (leaf == null) {
      return height;
    }
    int heightLeft = getMaxHeight(leaf.left, height) + 1;
    int heightRight = getMaxHeight(leaf.right, height) + 1;
    return Math.max(heightLeft, heightRight);
  }

  private static int getMinHeight(Leaf leaf, int height) {
    if (leaf == null) {
      return height;
    }
    int heightLeft = getMinHeight(leaf.left, height) + 1;
    int heightRight = getMinHeight(leaf.right, height) + 1;
    return Math.min(heightLeft, heightRight);
  }
}
