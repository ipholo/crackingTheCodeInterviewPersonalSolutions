/*
 * Tests to the Personal Solutions to Chapter 2: Linked Lists.
 * Book: Cracking the Coding Interview.
 * The book is property of Gayle Laakmann McDowell.
 * The solutions are only educational.
 */
package crackingthecodinginterviewpersonalsolutions;

import static crackingthecodinginterviewpersonalsolutions.LinkedLists.deleteMiddleElementInSingleList;
import static crackingthecodinginterviewpersonalsolutions.LinkedLists.findNthToLastElement;
import static crackingthecodinginterviewpersonalsolutions.LinkedLists.removeDuplicatesWithBuffer;
import static crackingthecodinginterviewpersonalsolutions.LinkedLists.removeDuplicatesWithoutBuffer;
import static crackingthecodinginterviewpersonalsolutions.LinkedLists.sumTwoLinkedListsContainingASingleDigit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import crackingthecodinginterviewpersonalsolutions.auxiliaryClassesToProblems.Node;
import crackingthecodinginterviewpersonalsolutions.auxiliaryClassesToProblems.SinglyLinkedList;
import java.util.Arrays;
import java.util.LinkedList;
import org.junit.Test;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://www.ipolo.hol.es
 */
public class LinkedListsTest {
    
    @Test
    public void testRemoveDuplicatesWithoutBuffer_assertResult_listWithDuplicates() {
        LinkedList list =
                new LinkedList(Arrays.asList(8, 9, 7, 7, 9, 5, 10, 11, 17, 11, 10, 8));
        LinkedList expected = 
                new LinkedList(Arrays.asList(8, 9, 7, 5, 10, 11, 17));
        
        LinkedList result = removeDuplicatesWithoutBuffer(list);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testRemoveDuplicatesWithoutBuffer_assertResult_listWithoutDuplicates() {
        LinkedList expected =
                new LinkedList(Arrays.asList(1, 9, 2, 8, 3, 7, 4, 6, 5));
        
        LinkedList result = removeDuplicatesWithoutBuffer(expected);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testRemoveDuplicatesWithBuffer_assertResult_listWithDuplicates() {
        LinkedList list =
                new LinkedList(Arrays.asList(8, 9, 7, 7, 9, 5, 10, 11, 17, 11, 10, 8));
        LinkedList expected =
                new LinkedList(Arrays.asList(8, 9, 7, 5, 10, 11, 17));
        
        LinkedList result = removeDuplicatesWithBuffer(list);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testRemoveDuplicatesWithBuffer_assertResult_listWithoutDuplicates() {
        LinkedList expected =
                new LinkedList(Arrays.asList(1, 9, 2, 8, 3, 7, 4, 6, 5));
        
        LinkedList result = removeDuplicatesWithBuffer(expected);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testFindNthToLastElement_assertResult() {
        int n = 10;
        SinglyLinkedList singleList =
                new SinglyLinkedList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        for(int i = 1; i <= n; i++) {
            int result = findNthToLastElement(singleList, i);
            assertEquals(n + 1 - i, result);
        }
    }
    
    @Test
    public void testDeleteMiddleElementInSingleList_assertResult_oneElement() {
        SinglyLinkedList singleList = new SinglyLinkedList(1);
        SinglyLinkedList expected = new SinglyLinkedList();
        
        SinglyLinkedList result = deleteMiddleElementInSingleList(singleList);
        
        assertSinglyLinkedListEquals(expected, result);
    }
    
    @Test
    public void testDeleteMiddleElementInSingleList_assertResult_twoElements() {
        SinglyLinkedList singleList = new SinglyLinkedList(5, 3);
        SinglyLinkedList expected = new SinglyLinkedList(3);
        
        SinglyLinkedList result = deleteMiddleElementInSingleList(singleList);
        
        assertSinglyLinkedListEquals(expected, result);
    }
    
    @Test
    public void testDeleteMiddleElementInSingleList_assertResult_sevenElements() {
        SinglyLinkedList singleList = new SinglyLinkedList(6, 9, 1, 2, 3, 8, 0);
        SinglyLinkedList expected = new SinglyLinkedList(6, 9, 1, 3, 8, 0);
        
        SinglyLinkedList result = deleteMiddleElementInSingleList(singleList);
        
        assertSinglyLinkedListEquals(expected, result);
    }
    
    @Test
    public void testDeleteMiddleElementInSingleList_assertResult_eightElements() {
        SinglyLinkedList singleList =
                new SinglyLinkedList(8, 2, 1, 0, 9, 3, 1, 8);
        SinglyLinkedList expected = new SinglyLinkedList(8, 2, 1, 9, 3, 1, 8);
        
        SinglyLinkedList result = deleteMiddleElementInSingleList(singleList);
        
        assertSinglyLinkedListEquals(expected, result);
    }
    
    @Test
    public void testSumTwoLinkedListsContainingASingleDigit_assertResult_simpleSum() {
        LinkedList list1 = new LinkedList(Arrays.asList(3, 2, 1));
        LinkedList list2 = new LinkedList(Arrays.asList(5, 4, 1));
        LinkedList expected = new LinkedList(Arrays.asList(8, 6, 2));
        
        LinkedList result =
                sumTwoLinkedListsContainingASingleDigit(list1, list2);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testSumTwoLinkedListsContainingASingleDigit_assertResult_complexSum() {
        LinkedList list1 = new LinkedList(Arrays.asList(8, 9, 9));
        LinkedList list2 = new LinkedList(Arrays.asList(8, 9, 8));
        LinkedList expected = new LinkedList(Arrays.asList(6, 9, 8, 1));
        
        LinkedList result =
                sumTwoLinkedListsContainingASingleDigit(list1, list2);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testSumTwoLinkedListsContainingASingleDigit_assertResult_smallLengthList() {
        LinkedList list1 = new LinkedList(Arrays.asList(5, 7));
        LinkedList list2 = new LinkedList(Arrays.asList(8, 9, 9));
        LinkedList expected = new LinkedList(Arrays.asList(3, 7, 0, 1));
        
        LinkedList result =
                sumTwoLinkedListsContainingASingleDigit(list1, list2);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testSumTwoLinkedListsContainingASingleDigit_assertResult_bigLengthList() {
        LinkedList list1 = new LinkedList(Arrays.asList(5, 7, 8, 9));
        LinkedList list2 = new LinkedList(Arrays.asList(8, 9, 9));
        LinkedList expected = new LinkedList(Arrays.asList(3, 7, 8, 0, 1));
        
        LinkedList result =
                sumTwoLinkedListsContainingASingleDigit(list1, list2);
        
        assertEquals(expected, result);
    }
    
    private static void assertSinglyLinkedListEquals(
            SinglyLinkedList expected, SinglyLinkedList actual) {
        Node expectedNode = expected.head;
        Node actualNode = actual.head;
        while(expectedNode != null) {
            assertEquals(expectedNode.data, actualNode.data);
            expectedNode = expectedNode.next;
            actualNode = actualNode.next;
        }
        assertNull(actualNode);
    }
}
