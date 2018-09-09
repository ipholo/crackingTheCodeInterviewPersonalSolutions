/*
 * Singly Linked List Class
 * A node points only to the the next node. The last node points null.
 */
package crackingthecodinginterviewpersonalsolutions.auxiliaryClassesToProblems;

/**
 * @author Leopoldo Hernandez
 * @linktourl http://www.ipolo.hol.es
 */
public class SinglyLinkedList {
    
    public Node head = null;
    
    public void addElement(int d) {
        Node end = new Node(d);
        if (this.head == null) {
            this.head = end;
        } else {
            Node n = this.head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = end;
        }
    }
    
    public void addElements(int... elements) {
        for(int element: elements) {
            addElement(element);
        }
    }
}
