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
        testSingleList.addElement(1);
        testSingleList.addElement(2);
        testSingleList.addElement(3);
        testSingleList.addElement(4);
        testSingleList.addElement(5);
        
        assertSinglyLinkedListWithContinuousNumbersFromOne(testSingleList.head);
    }
    
    @Test
    public void testAddElements() {
        testSingleList.addElements(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        assertSinglyLinkedListWithContinuousNumbersFromOne(testSingleList.head);
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
