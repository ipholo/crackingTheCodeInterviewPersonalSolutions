/*
 * Tests to the Personal Solutions to Chapter 2: Linked Lists.
 * Book: Cracking the Coding Interview.
 * The book is property of Gayle Laakmann McDowell.
 * The solutions are only educational.
 */
package crackingthecodinginterviewpersonalsolutions.linkedLists;

import crackingthecodinginterviewpersonalsolutions.linkedLists.CircularLinkedList;
import crackingthecodinginterviewpersonalsolutions.linkedLists.SinglyLinkedList;
import static crackingthecodinginterviewpersonalsolutions.linkedLists.StaticMethods.deleteMiddleElementInSingleList;
import static crackingthecodinginterviewpersonalsolutions.linkedLists.StaticMethods.findNthToLastElement;
import static crackingthecodinginterviewpersonalsolutions.linkedLists.StaticMethods.getNodeAtLoopStartInCircularLinkedList;
import static crackingthecodinginterviewpersonalsolutions.linkedLists.StaticMethods.removeDuplicatesWithBuffer;
import static crackingthecodinginterviewpersonalsolutions.linkedLists.StaticMethods.removeDuplicatesWithoutBuffer;
import static crackingthecodinginterviewpersonalsolutions.linkedLists.StaticMethods.sumTwoLinkedListsContainingASingleDigit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import crackingthecodinginterviewpersonalsolutions.common.Node;
import java.util.Arrays;
import java.util.LinkedList;
import org.junit.Test;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://ipolo.tech
 */
public class StaticMethodsTest {

  @Test
  public void testRemoveDuplicatesWithBuffer_assertResult_listWithDuplicates() {
    SinglyLinkedList list = new SinglyLinkedList(8, 9, 7, 7, 9, 5, 10, 11, 17, 11, 10, 8);
    SinglyLinkedList expected = new SinglyLinkedList(8, 9, 7, 5, 10, 11, 17);

    SinglyLinkedList result = removeDuplicatesWithBuffer(list);

    assertSinglyLinkedListEquals(expected, result);
  }

  @Test
  public void testRemoveDuplicatesWithBuffer_assertResult_listWithOneDuplicate() {
    SinglyLinkedList list = new SinglyLinkedList(8, 8, 8, 8, 8);
    SinglyLinkedList expected = new SinglyLinkedList(8);

    SinglyLinkedList result = removeDuplicatesWithBuffer(list);

    assertSinglyLinkedListEquals(expected, result);
  }

  @Test
  public void testRemoveDuplicatesWithBuffer_assertResult_listWithoutDuplicates() {
    SinglyLinkedList list = new SinglyLinkedList(1, 9, 2, 8, 3, 7, 4, 6, 5);
    SinglyLinkedList expected = new SinglyLinkedList(1, 9, 2, 8, 3, 7, 4, 6, 5);

    SinglyLinkedList result = removeDuplicatesWithBuffer(list);

    assertSinglyLinkedListEquals(expected, result);
  }

  @Test
  public void testRemoveDuplicatesWithoutBuffer_assertResult_listWithDuplicates() {
    LinkedList list = new LinkedList(Arrays.asList(8, 9, 7, 7, 9, 5, 10, 11, 17, 11, 10, 8));
    LinkedList expected = new LinkedList(Arrays.asList(8, 9, 7, 5, 10, 11, 17));

    LinkedList result = removeDuplicatesWithoutBuffer(list);

    assertEquals(expected, result);
  }

  @Test
  public void testRemoveDuplicatesWithoutBuffer_assertResult_listWithoutDuplicates() {
    LinkedList list = new LinkedList(Arrays.asList(1, 9, 2, 8, 3, 7, 4, 6, 5));
    LinkedList expected = new LinkedList(Arrays.asList(1, 9, 2, 8, 3, 7, 4, 6, 5));

    LinkedList result = removeDuplicatesWithoutBuffer(list);

    assertEquals(expected, result);
  }

  @Test
  public void testFindNthToLastElement_assertResult() {
    int n = 10;
    SinglyLinkedList singleList = new SinglyLinkedList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    for (int i = 1; i <= n; i++) {
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
    SinglyLinkedList singleList = new SinglyLinkedList(8, 2, 1, 0, 9, 3, 1, 8);
    SinglyLinkedList expected = new SinglyLinkedList(8, 2, 1, 9, 3, 1, 8);

    SinglyLinkedList result = deleteMiddleElementInSingleList(singleList);

    assertSinglyLinkedListEquals(expected, result);
  }

  @Test
  public void testSumTwoLinkedListsContainingASingleDigit_assertResult_simpleSum() {
    LinkedList list1 = new LinkedList(Arrays.asList(3, 2, 1));
    LinkedList list2 = new LinkedList(Arrays.asList(5, 4, 1));
    LinkedList expected = new LinkedList(Arrays.asList(8, 6, 2));

    LinkedList result = sumTwoLinkedListsContainingASingleDigit(list1, list2);

    assertEquals(expected, result);
  }

  @Test
  public void testSumTwoLinkedListsContainingASingleDigit_assertResult_complexSum() {
    LinkedList list1 = new LinkedList(Arrays.asList(8, 9, 9));
    LinkedList list2 = new LinkedList(Arrays.asList(8, 9, 8));
    LinkedList expected = new LinkedList(Arrays.asList(6, 9, 8, 1));

    LinkedList result = sumTwoLinkedListsContainingASingleDigit(list1, list2);

    assertEquals(expected, result);
  }

  @Test
  public void testSumTwoLinkedListsContainingASingleDigit_assertResult_smallLengthList() {
    LinkedList list1 = new LinkedList(Arrays.asList(5, 7));
    LinkedList list2 = new LinkedList(Arrays.asList(8, 9, 9));
    LinkedList expected = new LinkedList(Arrays.asList(3, 7, 0, 1));

    LinkedList result = sumTwoLinkedListsContainingASingleDigit(list1, list2);

    assertEquals(expected, result);
  }

  @Test
  public void testSumTwoLinkedListsContainingASingleDigit_assertResult_bigLengthList() {
    LinkedList list1 = new LinkedList(Arrays.asList(5, 7, 8, 9));
    LinkedList list2 = new LinkedList(Arrays.asList(8, 9, 9));
    LinkedList expected = new LinkedList(Arrays.asList(3, 7, 8, 0, 1));

    LinkedList result = sumTwoLinkedListsContainingASingleDigit(list1, list2);

    assertEquals(expected, result);
  }

  @Test
  public void testGetNodeAtLoopStartInCircularLinkedList_assertResult_firstPosition() {
    CircularLinkedList list = new CircularLinkedList(5, 9, 1, 3, 2);
    list.setLastNodeIntoCircularPosition(0);
    Node expected = list.head;

    Node result = getNodeAtLoopStartInCircularLinkedList(list);

    assertEquals(expected, result);
  }

  @Test
  public void testGetNodeAtLoopStartInCircularLinkedList_assertResult_thirdPosition() {
    CircularLinkedList list = new CircularLinkedList(5, 9, 1, 3, 2);
    list.setLastNodeIntoCircularPosition(2);
    Node expected = list.head.next.next;

    Node result = getNodeAtLoopStartInCircularLinkedList(list);

    assertEquals(expected, result);
  }

  @Test
  public void testGetNodeAtLoopStartInCircularLinkedList_assertResult_lastPosition() {
    CircularLinkedList list = new CircularLinkedList(5, 9, 1, 3, 2);
    list.setLastNodeIntoCircularPosition(4);
    Node expected = list.head.next.next.next.next;

    Node result = getNodeAtLoopStartInCircularLinkedList(list);

    assertEquals(expected, result);
  }

  @Test
  public void testGetNodeAtLoopStartInCircularLinkedList_assertResult_noPosition() {
    CircularLinkedList list = new CircularLinkedList(5, 9, 1, 3, 2);

    Node result = getNodeAtLoopStartInCircularLinkedList(list);

    assertNull(result);
  }

  private static void assertSinglyLinkedListEquals(
      SinglyLinkedList expected, SinglyLinkedList actual) {
    Node expectedNode = expected.head;
    Node actualNode = actual.head;
    while (expectedNode != null) {
      assertEquals(expectedNode.data, actualNode.data);
      expectedNode = expectedNode.next;
      actualNode = actualNode.next;
    }
    assertNull(actualNode);
  }
}
