/*
 * Test to Set of Stacks class.
 */
package crackingthecodinginterviewpersonalsolutions.stacksAndQueues;

import crackingthecodinginterviewpersonalsolutions.stacksAndQueues.SetOfStacks;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://www.ipolo.hol.es
 */
public class SetOfStacksTest {
    
    @Test
    public void testSetOfStacks_assertPushPop_ThreeElements() {
        SetOfStacks stack = new SetOfStacks(3);
        
        stack.push(4);
        stack.push(5);
        
        assertEquals(5, stack.pop());
        assertEquals(4, stack.pop());
        assertNull(stack.pop());
    }
    
    @Test
    public void testSetOfStacks_assertPushPop_TwoElements() {
        SetOfStacks stack = new SetOfStacks(2);
        
        assertNull(stack.pop());
        
        stack.push(4);
        stack.push(5);
        stack.push(6);
        
        assertEquals(6, stack.pop());
        assertEquals(5, stack.pop());
        
        stack.push(9);
        stack.push(12);
        stack.push(15);
        
        assertEquals(15, stack.pop());
        assertEquals(12, stack.pop());
        assertEquals(9, stack.pop());
        assertEquals(4, stack.pop());
        assertNull(stack.pop());
    }
}
