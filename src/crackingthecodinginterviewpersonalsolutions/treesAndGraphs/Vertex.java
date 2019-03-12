/*
 * Vertex class to be used in Graph class.
 */
package crackingthecodinginterviewpersonalsolutions.treesAndGraphs;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://ipolo.tech
 */
public class Vertex {
  private int uniqueLabel;

  Vertex(int uniqueLabel) {
    this.uniqueLabel = uniqueLabel;
  }

  public int getLabel() {
    return uniqueLabel;
  }

  public void setLabel(int uniqueLabel) {
    this.uniqueLabel = uniqueLabel;
  }


  // Override the equals() and hashCode() methods as these are necessary to work with
  // Java Collections.
  @Override
  public int hashCode() {
    return uniqueLabel;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof Vertex)) return false;

    Vertex _obj = (Vertex) obj;
    return _obj.uniqueLabel == uniqueLabel;
  }
}
