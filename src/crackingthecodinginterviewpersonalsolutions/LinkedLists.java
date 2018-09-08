/*
 * Personal Solutions to the chapter 2: Arrays of String.
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

/**
 *
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
}
