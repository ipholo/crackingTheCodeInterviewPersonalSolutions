/*
 * Binary Tree class with inorder, postorder and preorder methods.
 */
package crackingthecodinginterviewpersonalsolutions.treesAndGraphs;

import java.util.LinkedList;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://www.ipolo.hol.es
 */
public class BinaryTree {

  private int data;
  BinaryTree left = null;
  BinaryTree right = null;

  // Only used in next node problem.
  BinaryTree parent = null;

  BinaryTree(int data) {
    this.data = data;
  }

  BinaryTree(int rootData, int leftData, int rightData) {
    this.data = rootData;
    this.left = new BinaryTree(leftData);
    this.right = new BinaryTree(rightData);
  }

  BinaryTree(int rootData, BinaryTree leftBinaryTree, BinaryTree rightBinaryTree) {
    this.data = rootData;
    this.left = leftBinaryTree;
    this.right = rightBinaryTree;
  }

  public LinkedList<Integer> preorder() {
    LinkedList<Integer> list = new LinkedList<>();
    preorder(list, this);
    return list;
  }

  public LinkedList<Integer> inorder() {
    LinkedList<Integer> list = new LinkedList<>();
    inorder(list, this);
    return list;
  }

  public LinkedList<Integer> postorder() {
    LinkedList<Integer> list = new LinkedList<>();
    postorder(list, this);
    return list;
  }

  public int getHeight() {
    return getHeight(this, 0);
  }

  private int getHeight(BinaryTree binaryTree, int height) {
    if (binaryTree == null) {
      return height;
    }
    int heightLeft = getHeight(binaryTree.left, height) + 1;
    int heightRight = getHeight(binaryTree.right, height) + 1;
    return Math.max(heightLeft, heightRight);
  }

  private void preorder(LinkedList<Integer> list, BinaryTree binaryTree) {
    if (binaryTree == null) {
      return;
    }
    list.add(binaryTree.data);
    preorder(list, binaryTree.left);
    preorder(list, binaryTree.right);
  }

  private void inorder(LinkedList<Integer> list, BinaryTree binaryTree) {
    if (binaryTree == null) {
      return;
    }
    inorder(list, binaryTree.left);
    list.add(binaryTree.data);
    inorder(list, binaryTree.right);
  }

  private void postorder(LinkedList<Integer> list, BinaryTree binaryTree) {
    if (binaryTree == null) {
      return;
    }
    postorder(list, binaryTree.left);
    postorder(list, binaryTree.right);
    list.add(binaryTree.data);
  }

  // Override the equals() and hashCode() methods as these are necessary to work with
  // Java Collections.
  @Override
  public int hashCode() {
    return data;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof BinaryTree)) return false;

    BinaryTree _obj = (BinaryTree) obj;
    return _obj.data == data;
  }
}
