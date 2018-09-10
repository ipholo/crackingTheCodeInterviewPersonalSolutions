/*
 * Personal Solutions to the chapter 2: Linked Lists.
 * Book: Cracking the Coding Interview.
 * The book is property of Gayle Laakmann McDowell.
 * The solutions are only educational.
 */
package crackingthecodinginterviewpersonalsolutions;

import crackingthecodinginterviewpersonalsolutions.auxiliaryClassesToProblems.Node;
import crackingthecodinginterviewpersonalsolutions.auxiliaryClassesToProblems.SinglyLinkedList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://www.ipolo.hol.es
 */
public class LinkedLists {
    
    /*
     * Write code to remove duplicates from an unsorted linked list.
     */
    public static LinkedList removeDuplicatesWithBuffer(LinkedList list) {
        HashSet hashSet = new HashSet();
        Iterator iterator = list.iterator();
        while(iterator.hasNext()) {
            if(!hashSet.add(iterator.next())) {
                iterator.remove();
            }
        }
        return list;
    }
    
    /*
     * FOLLOW UP.
     * How would you solve this problem if a temporary buffer is not allowed?
     */
    public static LinkedList removeDuplicatesWithoutBuffer(LinkedList list) {
        int firstPosition = 0;
        while(firstPosition < list.size()) {
            int secondPosition = firstPosition + 1;
            while(secondPosition < list.size()) {
                if(list.get(firstPosition).equals(list.get(secondPosition))) {
                    list.remove(secondPosition);
                }
                secondPosition++;
            }
            firstPosition++;
        }
        return list;
    }
    
    /*
     * Implement an algorithm to find the nth to last element of a
     * singly linked list
     */
    public static int findNthToLastElement (SinglyLinkedList list, int n) {
        Node node = list.head;
        Node nAux = list.head;
        int start = 1;
        while(node.next != null) {
            if(start >= n) {
                nAux = nAux.next;
            }
            start++;
            node = node.next;
        }
        return nAux.data;
    }
   
    /*
     * Implement an algorithm to delete a node in the middle of a single linked
     * list, given only access to that node
     */
    public static SinglyLinkedList deleteMiddleElementInSingleList(
            SinglyLinkedList list) {
        int counter = 0;
        Node node = list.head;
        Node nAux = list.head;
        while(node != null) {
            if(counter % 2 == 0 && counter < 3) {
                nAux = nAux.next;
            }
            node = node.next;
            counter++;
        }
        if(counter == 1 || counter == 2) {
            list.head = list.head.next;
        } else {
            nAux.next = nAux.next.next;
        }
        return list;
    }
    
    /* 
     * You have two numbers represented by a linked list, where each node
     * contains a single digit The digits are stored in reverse order, such that
     * the 1’s digit is at the head of the list. Write a function that adds the
     * two numbers and returns the sum as a linked list.
     */
    public static LinkedList<Integer> sumTwoLinkedListsContainingASingleDigit(
            LinkedList<Integer> list1, LinkedList<Integer> list2) {
        LinkedList<Integer> sumList = new LinkedList(); 
        Iterator<Integer> iterator1 = list1.iterator();
        Iterator<Integer> iterator2 = list2.iterator();
        int carrier = 0;
        while(iterator1.hasNext() || iterator2.hasNext() || carrier != 0) {
            int value1 = iterator1.hasNext() ? iterator1.next() : 0;
            int value2 = iterator2.hasNext() ? iterator2.next() : 0;
            int result = value1 + value2 + carrier;
            sumList.add(result % 10);
            carrier = result / 10;
        }
        return sumList;
    }
}
