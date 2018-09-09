/*
 * Tests to the Personal Solutions to Chapter 2: Linked Lists.
 * Book: Cracking the Coding Interview.
 * The book is property of Gayle Laakmann McDowell.
 * The solutions are only educational.
 */
package crackingthecodinginterviewpersonalsolutions;

import crackingthecodinginterviewpersonalsolutions.auxiliaryClassesToProblems.Node;
import crackingthecodinginterviewpersonalsolutions.auxiliaryClassesToProblems.SinglyLinkedList;

import java.util.Arrays;
import java.util.LinkedList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
    public void testFindNthToLastElement_assertResult() {
        int n = 10;
        SinglyLinkedList singleList = getSinglyLinkedListToTest(n);
        
        for(int i = 1; i <= n; i++) {
            int result = LinkedLists.findNthToLastElement(singleList, i);
            assertEquals(n + 1 - i, result);
        }
    }
    
    @Test
    public void testDeleteMiddleElementInSingleList_assertResult_oneElement() {
        SinglyLinkedList singleList = getSinglyLinkedListToTest(1);
        SinglyLinkedList expected = new SinglyLinkedList();
        
        SinglyLinkedList result = LinkedLists.deleteMiddleElementInSingleList(singleList);
        
        assertSinglyLinkedListEquals(expected, result);
    }
    
    @Test
    public void testDeleteMiddleElementInSingleList_assertResult_twoElements() {
        SinglyLinkedList singleList = getSinglyLinkedListToTest(2);
        SinglyLinkedList expected = new SinglyLinkedList();
        expected.addElement(2);
        
        SinglyLinkedList result = LinkedLists.deleteMiddleElementInSingleList(singleList);
        
        assertSinglyLinkedListEquals(expected, result);
    }
    
    @Test
    public void testDeleteMiddleElementInSingleList_assertResult_sevenElements() {
        SinglyLinkedList singleList = getSinglyLinkedListToTest(7);
        SinglyLinkedList expected = new SinglyLinkedList();
        expected.addElements(1, 2, 3, 5, 6, 7);
        
        SinglyLinkedList result = LinkedLists.deleteMiddleElementInSingleList(singleList);
        
        assertSinglyLinkedListEquals(expected, result);
    }
    
    @Test
    public void testDeleteMiddleElementInSingleList_assertResult_eightElements() {
        SinglyLinkedList singleList = getSinglyLinkedListToTest(8);
        SinglyLinkedList expected = new SinglyLinkedList();
        expected.addElements(1, 2, 3, 5, 6, 7, 8);
        
        SinglyLinkedList result = LinkedLists.deleteMiddleElementInSingleList(singleList);
        
        assertSinglyLinkedListEquals(expected, result);
    }
    
    private static void assertSinglyLinkedListEquals(SinglyLinkedList expected, SinglyLinkedList actual) {
        Node expectedNode = expected.head;
        Node actualNode = actual.head;
        while(expectedNode != null) {
            assertEquals(expectedNode.data, actualNode.data);
            expectedNode = expectedNode.next;
            actualNode = actualNode.next;
        }
        assertNull(actualNode);
    }
    
    private static SinglyLinkedList getSinglyLinkedListToTest (int n) {
        SinglyLinkedList singleList = new SinglyLinkedList();
        for(int i = 1; i <= n; i++) {
            singleList.addElement(i);
        }
        return singleList;
    }
}
