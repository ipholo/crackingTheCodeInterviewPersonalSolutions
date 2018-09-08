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
    
    int numberOfElements = 10;
    SinglyLinkedList testSingleList = getSinglyLinkedListToTest(numberOfElements);
    
    @Test
    public void testAddElement() {
        Node n = this.testSingleList.head;
        int comp = 1;
        
        while (n.next != null) {
            assertEquals(comp, n.data);
            comp++;
            n = n.next;
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
