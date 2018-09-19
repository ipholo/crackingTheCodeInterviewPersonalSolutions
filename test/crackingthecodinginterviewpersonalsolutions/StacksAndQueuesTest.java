/*
 * Tests to the Personal Solutions to Chapter 3: Stacks and Queues.
 * Book: Cracking the Coding Interview.
 * The book is property of Gayle Laakmann McDowell.
 * The solutions are only educational.
 */
package crackingthecodinginterviewpersonalsolutions;

import static crackingthecodinginterviewpersonalsolutions.StacksAndQueues.getSetOfStacks;
import static crackingthecodinginterviewpersonalsolutions.StacksAndQueues.stackWithMinOperation;
import static crackingthecodinginterviewpersonalsolutions.StacksAndQueues.threeStacksUsingAnArray;
import static org.junit.Assert.assertEquals;

import crackingthecodinginterviewpersonalsolutions.auxiliaryClassesToProblems.MultipleStacksUsingAnArray;
import crackingthecodinginterviewpersonalsolutions.auxiliaryClassesToProblems.SetOfStacks;
import crackingthecodinginterviewpersonalsolutions.auxiliaryClassesToProblems.StackWithMin;
import org.junit.Test;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://www.ipolo.hol.es
 */
public class StacksAndQueuesTest {
    
    @Test
    public void testTreeStacksUsingAnArray_assertOperations() {
        MultipleStacksUsingAnArray stack = threeStacksUsingAnArray(10);
        
        stack.push(1, 32);
        stack.push(1, 12);
        stack.push(1, 89);
        stack.push(2, 10);
        stack.push(3, 65);
        stack.push(3, 98);
        
        assertEquals(89, stack.peek(1));
        assertEquals(89, stack.pop(1));
        assertEquals(12, stack.pop(1));
        assertEquals(32, stack.pop(1));
        assertEquals(10, stack.pop(2));
        assertEquals(98, stack.peek(3));
        assertEquals(98, stack.pop(3));
        assertEquals(65, stack.pop(3));
    }
    
    @Test
    public void testStackWithMinOperation_assertMinOperation() {
        StackWithMin stack = stackWithMinOperation();
        
        stack.push(32);
        stack.push(12);
        stack.push(40);
        
        assertEquals(12, stack.min());
        
        stack.pop();
        stack.pop();
        
        assertEquals(32, stack.min());
        
        stack.push(1);
        
        assertEquals(1, stack.min());
    }
    
    @Test
    public void testGetSetOfStacks_assertStackFunctionality() {
        SetOfStacks stack = getSetOfStacks(3);
        
        stack.push(89); 
        
        assertEquals(89, stack.pop());
        
        stack.push(12);
        
        assertEquals(12, stack.pop());
        
        stack.push(32);
        stack.push(10);
        stack.push(98);
        
        assertEquals(98, stack.pop());
        assertEquals(10, stack.pop());
        assertEquals(32, stack.pop());
        
        stack.push(65);
        
        assertEquals(65, stack.pop());
    }
}
