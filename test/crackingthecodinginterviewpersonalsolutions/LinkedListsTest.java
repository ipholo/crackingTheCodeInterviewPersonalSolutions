/*
 * Tests to the Personal Solutions to Chapter 2: Linked Lists.
 * Book: Cracking the Coding Interview.
 * The book is property of Gayle Laakmann McDowell.
 * The solutions are only educational.
 */
package crackingthecodinginterviewpersonalsolutions;

import crackingthecodinginterviewpersonalsolutions.auxiliaryClassesToProblems.SinglyLinkedList;
import java.util.Arrays;
import java.util.LinkedList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Leopoldo Hernandez
 * @linktourl http://www.ipolo.hol.es
 */
public class LinkedListsTest {
    
    @Test
    public void testRemoveDuplicatesWithoutBuffer_assertResult_listWithDuplicates() {
        LinkedList list = new LinkedList();
        list.addAll(Arrays.asList(8, 9, 7, 7, 9, 5, 10, 11, 17, 11, 10, 8));
        LinkedList expected = new LinkedList();
        expected.addAll(Arrays.asList(8, 9, 7, 5, 10, 11, 17));
        
        LinkedList result = LinkedLists.removeDuplicatesWithoutBuffer(list);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testRemoveDuplicatesWithoutBuffer_assertResult_listWithoutDuplicates() {
        LinkedList expected = new LinkedList();
        expected.addAll(Arrays.asList(1, 9, 2, 8, 3, 7, 4, 6, 5));
        
        LinkedList result = LinkedLists.removeDuplicatesWithoutBuffer(expected);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testRemoveDuplicatesWithBuffer_assertResult_listWithDuplicates() {
        LinkedList list = new LinkedList();
        list.addAll(Arrays.asList(8, 9, 7, 7, 9, 5, 10, 11, 17, 11, 10, 8));
        LinkedList expected = new LinkedList();
        expected.addAll(Arrays.asList(8, 9, 7, 5, 10, 11, 17));
        
        LinkedList result = LinkedLists.removeDuplicatesWithBuffer(list);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testRemoveDuplicatesWithBuffer_assertResult_listWithoutDuplicates() {
        LinkedList expected = new LinkedList();
        expected.addAll(Arrays.asList(1, 9, 2, 8, 3, 7, 4, 6, 5));
        
        LinkedList result = LinkedLists.removeDuplicatesWithBuffer(expected);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testfindNthToLastElement_assertResult() {
        int n = 10;
        SinglyLinkedList singleList = getSinglyLinkedListToTest(n);
        
        for(int i = 1; i <= n; i++) {
            int result = LinkedLists.findNthToLastElement(singleList, i);
            assertEquals(n + 1 - i, result);
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
