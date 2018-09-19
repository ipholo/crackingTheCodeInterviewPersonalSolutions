/*
 * Test to Stack With Min class.
 */
package crackingthecodinginterviewpersonalsolutions.stacksAndQueues;

import crackingthecodinginterviewpersonalsolutions.stacksAndQueues.StackWithMin;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://www.ipolo.hol.es
 */
public class StackWithMinTest {
    
    StackWithMin stack;
    
    @Before
    public void setUp() {
        stack = new StackWithMin();
    }
    
    @Test
    public void testMin() {
        stack.push(78);
        
        assertEquals(78, stack.min());
        
        stack.push(67);
        stack.push(100);
        stack.push(54);
        
        assertEquals(54, stack.min());
        
        stack.pop();
        
        assertEquals(67, stack.min());
        
        stack.pop();
        stack.pop();
        
        assertEquals(78, stack.min());
        
        stack.push(12);
        stack.push(1);
        
        assertEquals(1, stack.min());
    }
    
    @Test
    public void testMin_assertEmptyStack() {
        assertEquals(-1, stack.min());
        assertEquals(-1, stack.min());
        assertEquals(-1, stack.min());
    }
}
