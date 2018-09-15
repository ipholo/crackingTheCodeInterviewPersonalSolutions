/*
 * A Singly Linked List where a node points only to the the next node.
 * The last node points null. The first elemente is called head.
 */
package crackingthecodinginterviewpersonalsolutions.auxiliaryClassesToProblems;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://www.ipolo.hol.es
 */
public class SinglyLinkedList {
    
    public Node head = null;

    public SinglyLinkedList() { }
    
    public SinglyLinkedList(int... elements) {
        addMultipleElements(elements);
    }
    
    public void addElements(int... elements) {
        addMultipleElements(elements);
    }
    
    private void addMultipleElements(int [] elements) {
        for(int element: elements) {
            addElement(element);
        }
    }
    
    private void addElement(int value) {
        Node end = new Node(value);
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
}
