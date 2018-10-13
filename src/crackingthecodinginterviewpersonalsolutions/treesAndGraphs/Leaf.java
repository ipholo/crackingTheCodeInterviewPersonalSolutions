/*
 * Leaf class with an int data, and a right and left node.
 */
package crackingthecodinginterviewpersonalsolutions.treesAndGraphs;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://www.ipolo.hol.es
 */
public class Leaf {

  public int data;
  public Leaf right = null;
  public Leaf left = null;

  public Leaf(int data) {
    this.data = data;
  }
}
