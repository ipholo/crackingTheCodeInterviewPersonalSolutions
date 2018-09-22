/*
 * Tests to the Personal Solutions to Chapter 3: Stacks and Queues.
 * Book: Cracking the Coding Interview.
 * The book is property of Gayle Laakmann McDowell.
 * The solutions are only educational.
 */
package crackingthecodinginterviewpersonalsolutions.stacksAndQueues;

import static crackingthecodinginterviewpersonalsolutions.stacksAndQueues.StaticMethods.sortStack;
import static crackingthecodinginterviewpersonalsolutions.stacksAndQueues.StaticMethods.towersOfHanoi;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Stack;
import org.junit.Test;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://www.ipolo.hol.es
 */
public class StaticMethodsTest {
    
    @Test
    public void testTowersOfHanoi_assertResult() {
        for(int numberOfDisks = 1; numberOfDisks <= 5; numberOfDisks++) {
            Stack<Integer> expected = new Stack();
            
            for(int i = numberOfDisks; i > 0; i--) {
                expected.push(i);
            }
            Stack result = towersOfHanoi(numberOfDisks);

            assertEquals(expected, result);
        }
    }
    
    @Test
    public void testSortStack_assertSort() {
        Stack<Integer> stack = new Stack();
        Stack<Integer> expected = new Stack();
        stack.addAll(Arrays.asList(2, 6, 1, 5, 4, 7 , 3));
        expected.addAll(Arrays.asList(7, 6, 5, 4, 3, 2, 1));
        
        Stack<Integer> result = sortStack(stack);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testSortStack_assertSort_emptyStack() {
        Stack<Integer> expected = new Stack();
        
        Stack<Integer> result = sortStack(expected);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testSortStack_assertSort_oneElement() {
        Stack<Integer> expected = new Stack();
        expected.addAll(Arrays.asList(2));
        
        Stack<Integer> result = sortStack(expected);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testSortStack_assertSort_twoElements() {
        Stack<Integer> stack = new Stack();
        Stack<Integer> expected = new Stack();
        stack.addAll(Arrays.asList(2, 6));
        expected.addAll(Arrays.asList(6, 2));
        
        Stack<Integer> result = sortStack(stack);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testSortStack_assertSort_orderedElements() {
        Stack<Integer> expected = new Stack();
        expected.addAll(Arrays.asList(7, 6, 5, 4, 3, 2, 1));
        
        Stack<Integer> result = sortStack(expected);
        
        assertEquals(expected, result);
    }
}
