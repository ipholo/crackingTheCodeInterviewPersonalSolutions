/*
 * A simple node containing an int element and a pointer to another node.
 */
package crackingthecodinginterviewpersonalsolutions.auxiliaryClassesToProblems;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://www.ipolo.hol.es
 */
public class Node {
    
    public Node next = null;
    public int data;

    public Node(int data) {
        this.data = data;
    }
}
