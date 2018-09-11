/*
 * Test to Singly Linked List Class.
 */
package crackingthecodinginterviewpersonalsolutions.auxiliaryClassesToProblems;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://www.ipolo.hol.es
 */
public class SinglyLinkedListTest {
    
    SinglyLinkedList testSingleList;
    
    @Before
    public void setUp() {
        testSingleList = new SinglyLinkedList();
    }
    
    @Test
    public void testAddElement() {
        testSingleList.addElements(1);
        testSingleList.addElements(2);
        testSingleList.addElements(3);
        testSingleList.addElements(4);
        testSingleList.addElements(5);
        
        assertSinglyLinkedListWithContinuousNumbersFromOne(testSingleList.head);
        assertEquals(1, testSingleList.head.data);
    }
    
    @Test
    public void testAddElements() {
        testSingleList.addElements(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        assertSinglyLinkedListWithContinuousNumbersFromOne(testSingleList.head);
        assertEquals(1, testSingleList.head.data);
    }
    
    private static void assertSinglyLinkedListWithContinuousNumbersFromOne(
            Node head) {
        int elementValue = 1;
        Node node = head;
        while (node.next != null) {
            assertEquals(elementValue, node.data);
            elementValue++;
            node = node.next;
        }
    }
}
