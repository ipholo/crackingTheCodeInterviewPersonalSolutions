/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crackingthecodinginterviewpersonalsolutions.auxiliaryClassesToProblems;

/**
 *
 * @author leopoldohernandez
 */
public class CircularLinkedList extends SinglyLinkedList {
    
    private boolean isListOpened = true;
    
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
            if(positionCounter <= position) {
                nodeCircular = finalNode;
            }
            positionCounter++;
            finalNode = finalNode.next;
        }
        finalNode.next = nodeCircular;
        this.isListOpened = false;
    }
}
