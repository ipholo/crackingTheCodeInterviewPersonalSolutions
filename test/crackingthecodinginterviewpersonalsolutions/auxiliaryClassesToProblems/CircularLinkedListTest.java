/*
 * Test to Circula Linked List Çlass.
 */
package crackingthecodinginterviewpersonalsolutions.auxiliaryClassesToProblems;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://www.ipolo.hol.es
 */
public class CircularLinkedListTest {
    
    CircularLinkedList testCircularLinkedList;
    Node tail;
    
    @Before
    public void setUp() {
        testCircularLinkedList = new CircularLinkedList();
        testCircularLinkedList.addElements(2, 4, 6, 8, 10, 12);
        tail = testCircularLinkedList.head;
        while(tail.next != null) {
            tail = tail.next;
        }
    }
    
    @Test
    public void testSetLastNodeIntoCircularPosition_assertInFirstPosition() {
        testCircularLinkedList.setLastNodeIntoCircularPosition(0);
        
        assertTrue(tail.next == testCircularLinkedList.head);
    }
    
    @Test
    public void testSetLastNodeIntoCircularPosition_assertInThirdPosition() {
        testCircularLinkedList.setLastNodeIntoCircularPosition(2);
        Node n = testCircularLinkedList.head;
        for(int i = 0; i < 2; i++) {
            n = n.next;
        }
        
        assertTrue(tail.next == n);
    }
    
    @Test
    public void testSetLastNodeIntoCircularPosition_assertInLastPosition() {
        testCircularLinkedList.setLastNodeIntoCircularPosition(10);
        
        assertTrue(tail.next.data == tail.data);
    }
    
    @Test
    public void testSetLastNodeIntoCircularPosition_assertInfinteLoop() {
        Node n = testCircularLinkedList.head;
        int numberOfNodesInList = 6;
        int temp = 0;
        int initialValueInList = 2;
        
        testCircularLinkedList.setLastNodeIntoCircularPosition(0);
        while(temp < numberOfNodesInList * 2) {
            n = n.next;
            temp++; 
        }
        
        for(int i = 0; i < numberOfNodesInList; i++) {
            assertTrue(initialValueInList == n.data);
            initialValueInList += 2;
            n = n.next;
        }
    }
    
    @Test
    public void testSetLastNodeIntoCircularPosition_assertNotNewAddedElement() {
        Node n = testCircularLinkedList.head;
        int numberOfNodesInList = 6;
        int temp = 0;
        
        testCircularLinkedList.setLastNodeIntoCircularPosition(0);
        testCircularLinkedList.addElements(14);
        
        while(temp < numberOfNodesInList * 2) {
            assertTrue(n.data != 14);
            n = n.next;
            temp++; 
        }
    }
}
