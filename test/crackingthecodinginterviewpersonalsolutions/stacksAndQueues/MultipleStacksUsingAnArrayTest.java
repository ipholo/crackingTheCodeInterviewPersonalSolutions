/*
 * Test to Multiple Stacks Using An Array Class.
 */
package crackingthecodinginterviewpersonalsolutions.stacksAndQueues;

import crackingthecodinginterviewpersonalsolutions.stacksAndQueues.MultipleStacksUsingAnArray;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://www.ipolo.hol.es
 */
public class MultipleStacksUsingAnArrayTest {
    
    MultipleStacksUsingAnArray stacks;
    int numberOfElementsInStack = 10;
    
    @Before
    public void setUp() {
        stacks = new MultipleStacksUsingAnArray(numberOfElementsInStack, 3);
    }

    @Test
    public void testPushPop() {
        for(int i = 1; i <= numberOfElementsInStack; i++) {
            assertTrue(stacks.push(1, i));
            assertTrue(stacks.push(2, i * 2));
            assertTrue(stacks.push(3, i * 3));
        }
        for(int i = 1; i <= 3; i++) {
            assertFalse(stacks.push(i, 100 + i));
        }
        for(int i = numberOfElementsInStack; i > 0; i--) {
            assertEquals(i, stacks.peek(1));
            assertEquals(i * 2, stacks.peek(2));
            assertEquals(i * 3, stacks.peek(3));
            assertEquals(i, stacks.pop(1));
            assertEquals(i * 2, stacks.pop(2));
            assertEquals(i * 3, stacks.pop(3));
        }
        for(int i = 1; i <= 3; i++) {
            assertEquals(stacks.pop(i), -1);
        }
        assertTrue(stacks.push(1, 11));
        assertTrue(stacks.push(2, 22));
        assertTrue(stacks.push(3, 33));
        assertEquals(11, stacks.peek(1));
        assertEquals(22, stacks.peek(2));
        assertEquals(33, stacks.peek(3));
        assertEquals(11, stacks.pop(1));
        assertEquals(22, stacks.pop(2));
        assertEquals(33, stacks.pop(3));
    }
    
    @Test
    public void testPop_assertNegative_incorrectStack() {
        assertEquals(-1, stacks.pop(1));
        assertEquals(-1, stacks.pop(2));
        assertEquals(-1, stacks.pop(3));
        assertEquals(-1, stacks.pop(5));
        assertEquals(-1, stacks.pop(7));
        assertEquals(-1, stacks.pop(10));
    }
    
    @Test
    public void testPush_assertFalse_incorrectStack() {
        assertFalse(stacks.push(5, 12));
        assertFalse(stacks.push(8, 34));
        assertFalse(stacks.push(4, 23));
    }
    
    @Test
    public void testPushPosh_fiveStacks_asserResutls() {
        MultipleStacksUsingAnArray stackFive = 
                new MultipleStacksUsingAnArray(5, 20);
        
        stackFive.push(1, 32);
        stackFive.push(1, 12);
        stackFive.push(4, 89);
        stackFive.push(2, 10);
        stackFive.push(3, 65);
        stackFive.push(5, 98);
        
        assertEquals(89, stackFive.peek(4));
        assertEquals(89, stackFive.pop(4));
        assertEquals(12, stackFive.pop(1));
        assertEquals(32, stackFive.pop(1));
        assertEquals(10, stackFive.pop(2));
        assertEquals(98, stackFive.peek(5));
        assertEquals(98, stackFive.pop(5));
        assertEquals(65, stackFive.pop(3));
    }
}
