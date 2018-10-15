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

  Leaf root;

  BinaryTree(int data) {
    this.root = new Leaf(data);;
  }

  BinaryTree(int rootData, int leftData, int rightData) {
    this.root = new Leaf(rootData);
    this.root.left = new Leaf(leftData);
    this.root.right = new Leaf(rightData);
  }

  BinaryTree(int rootData, Leaf leftLeaf, Leaf rightLeaf) {
    this.root = new Leaf(rootData);
    this.root.left = leftLeaf;
    this.root.right = rightLeaf;
  }

  public void addRightLeaf(int data) {
    this.root.right = new Leaf(data);;
  }

  public void addLeftLeaf(int data) {
    this.root.left = new Leaf(data);;
  }

  public LinkedList<Integer> preorder() {
    LinkedList<Integer> list = new LinkedList<>();
    preorder(list, this.root);
    return list;
  }

  public LinkedList<Integer> inorder() {
    LinkedList<Integer> list = new LinkedList<>();
    inorder(list, this.root);
    return list;
  }

  public LinkedList<Integer> postorder() {
    LinkedList<Integer> list = new LinkedList<>();
    postorder(list, this.root);
    return list;
  }

  private void preorder(LinkedList<Integer> list, Leaf leaf) {
    if(leaf == null) {
      return;
    }
    list.add(leaf.data);
    preorder(list, leaf.left);
    preorder(list, leaf.right);
  }

  private void inorder(LinkedList<Integer> list, Leaf leaf) {
    if(leaf == null) {
      return;
    }
    inorder(list, leaf.left);
    list.add(leaf.data);
    inorder(list, leaf.right);
  }

  private void postorder(LinkedList<Integer> list, Leaf leaf) {
    if(leaf == null) {
      return;
    }
    postorder(list, leaf.left);
    postorder(list, leaf.right);
    list.add(leaf.data);
  }
}
