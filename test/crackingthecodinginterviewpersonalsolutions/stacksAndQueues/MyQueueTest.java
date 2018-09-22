/*
 * Test to MyQueue class.
 */
package crackingthecodinginterviewpersonalsolutions.stacksAndQueues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Before;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://www.ipolo.hol.es
 */
public class MyQueueTest {
    
    MyQueue<Integer> myQueue;

    @Before
    public void setUp() {
        myQueue = new MyQueue();
    }

    @Test
    public void testEnqueueDequeue() {
        assertNull(myQueue.dequeue());
        
        myQueue.enqueue(2);
        myQueue.enqueue(4);
        myQueue.enqueue(5);
        
        assertEquals(2, myQueue.dequeue());
        assertEquals(4, myQueue.dequeue());
        
        myQueue.enqueue(8);
        myQueue.enqueue(9);
        
        assertEquals(5, myQueue.dequeue());
        assertEquals(8, myQueue.dequeue());
        assertEquals(9, myQueue.dequeue());
        assertNull(myQueue.dequeue());
    }
}
