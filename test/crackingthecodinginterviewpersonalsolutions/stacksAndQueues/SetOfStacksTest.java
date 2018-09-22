/*
 * Test to Set of Stacks class.
 */
package crackingthecodinginterviewpersonalsolutions.stacksAndQueues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://www.ipolo.hol.es
 */
public class SetOfStacksTest {
    
    @Test
    public void testSetOfStacks_assertPushPop_threeElements() {
        SetOfStacks stack = new SetOfStacks(3);
        
        stack.push(4);
        stack.push(5);
        
        assertEquals(5, stack.pop());
        assertEquals(4, stack.pop());
        assertNull(stack.pop());
    }
    
    @Test
    public void testSetOfStacks_assertPushPop_twoElements() {
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
    
    @Test
    public void testSetOfStacks_assertPushPop_oneElement() {
        SetOfStacks stack = new SetOfStacks(1);
        
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
    
    @Test
    public void testSetOfStacks_assertPopAt_threeElements() {
        SetOfStacks stack = new SetOfStacks(3);
        
        stack.push(4);
        stack.push(2);
        stack.push(9);
        stack.push(8);
        stack.push(3);
        stack.push(1);
        stack.push(10);
        
        assertEquals(9, stack.popAt(0));
        assertEquals(1, stack.popAt(1));
        assertEquals(10, stack.popAt(2));
        assertNull(stack.popAt(3));
    }
    
    @Test
    public void testSetOfStacks_assertPopAt_nullValues() {
        SetOfStacks stack = new SetOfStacks(2);
        
        stack.push(4);
        stack.push(2);
        stack.push(9);
        stack.push(8);
        stack.push(3);
        stack.push(1);
        
        assertEquals(2, stack.popAt(0));
        assertEquals(4, stack.popAt(0));
        assertEquals(8, stack.popAt(0));
        assertEquals(9, stack.popAt(0));
        assertEquals(1, stack.popAt(0));
    }
}
