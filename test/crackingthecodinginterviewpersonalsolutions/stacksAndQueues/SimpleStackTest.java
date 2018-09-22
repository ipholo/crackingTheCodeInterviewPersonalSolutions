/*
 * Test to Simple Stack class.
 */
package crackingthecodinginterviewpersonalsolutions.stacksAndQueues;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://www.ipolo.hol.es
 */
public class SimpleStackTest {
    
    SimpleStack stack;
    
    @Before
    public void setUp() {
        stack = new SimpleStack();
    }

    @Test
    public void testPushPopPeek() {
        stack.push(99);
        stack.push(32);
        
        assertEquals(32, stack.peek());
        assertEquals(32, stack.pop());
        
        stack.push(12);
        stack.push(89);
        
        assertEquals(89, stack.peek());
        assertEquals(89, stack.pop());
        assertEquals(12, stack.pop());
        
        stack.push(10);
        stack.push(65);
        stack.push(98);
        
        assertEquals(98, stack.peek());
        assertEquals(98, stack.pop());
        assertEquals(65, stack.pop()); 
        assertEquals(10, stack.pop());  
        assertEquals(99, stack.pop());
    }
    
    @Test
    public void testPop_assertEmptyStack() {
        assertEquals(-1, stack.pop());
        assertEquals(-1, stack.peek());
    }
}
