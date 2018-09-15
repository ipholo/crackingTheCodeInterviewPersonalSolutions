/*
 * A circular linked list is a linked list in which a node’s next pointer points
 * to an earlier node, so as to make a loop in the linked list.
 */
package crackingthecodinginterviewpersonalsolutions.auxiliaryClassesToProblems;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://www.ipolo.hol.es
 */
public class CircularLinkedList extends SinglyLinkedList {
    
    private boolean isListOpened = true;
    
    public CircularLinkedList(int... elements) {
        super(elements);
    }
    
    @Override
    public void addElements(int... elements) {
        if(isListOpened) {
            super.addElements(elements);
        }
    }
    
    public void setLastNodeIntoCircularPosition(int position) {
        if(this.head == null) {
            return;
        }
        Node finalNode = this.head;
        Node nodeCircular = this.head;
        int positionCounter = 0;
        position = position < 0 ? 0 : position;
        while (finalNode.next != null) {
            positionCounter++;
            finalNode = finalNode.next;
            if(positionCounter <= position) {
                nodeCircular = finalNode;
            }
        }
        finalNode.next = nodeCircular;
        this.isListOpened = false;
    }
}
