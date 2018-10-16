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

  private MyQueue<Integer> myQueue;

  @Before
  public void setUp() {
    myQueue = new MyQueue<>();
  }

  @Test
  public void testEnqueueDequeue() {
    assertNull(myQueue.dequeue());

    myQueue.enqueueAll(2, 4, 5);

    assertEquals(2, myQueue.dequeue());
    assertEquals(4, myQueue.dequeue());

    myQueue.enqueueAll(8, 9);

    assertEquals(5, myQueue.dequeue());
    assertEquals(8, myQueue.dequeue());
    assertEquals(9, myQueue.dequeue());

    myQueue.enqueue(1);

    assertEquals(1, myQueue.dequeue());
    assertNull(myQueue.dequeue());
  }
}
