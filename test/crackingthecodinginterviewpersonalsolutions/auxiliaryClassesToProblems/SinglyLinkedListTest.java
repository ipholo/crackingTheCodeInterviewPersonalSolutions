/*
 * Test to Singly Linked List Class.
 */
package crackingthecodinginterviewpersonalsolutions.auxiliaryClassesToProblems;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * @author Leopoldo Hernandez
 * @linktourl http://www.ipolo.hol.es
 */
public class SinglyLinkedListTest {
    
    SinglyLinkedList testSingleList;
    
    @Test
    public void testAddElement() {
        testSingleList = getSinglyLinkedListToTest(10);
        
        assertSinglyLinkedListWithContinuousNumbersFromOne(testSingleList.head);
    }
    
    @Test
    public void testAddElements() {
        testSingleList = new SinglyLinkedList();
        testSingleList.addElements(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        assertSinglyLinkedListWithContinuousNumbersFromOne(testSingleList.head);
    }
    
    private static void assertSinglyLinkedListWithContinuousNumbersFromOne(Node head) {
        int elementValue = 1;
        Node node = head;
        while (node.next != null) {
            assertEquals(elementValue, node.data);
            elementValue++;
            node = node.next;
        }
    }
    
    private static SinglyLinkedList getSinglyLinkedListToTest (int n) {
        SinglyLinkedList singleList = new SinglyLinkedList();
        for(int i = 1; i <= n; i++) {
            singleList.addElement(i);
        }
        return singleList;
    }
}
