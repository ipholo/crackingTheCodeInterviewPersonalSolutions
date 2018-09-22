/*
 * Tests to the Personal Solutions to Chapter 3: Stacks and Queues.
 * Book: Cracking the Coding Interview.
 * The book is property of Gayle Laakmann McDowell.
 * The solutions are only educational.
 */
package crackingthecodinginterviewpersonalsolutions.stacksAndQueues;

import static org.junit.Assert.assertEquals;
import static crackingthecodinginterviewpersonalsolutions.stacksAndQueues.StaticMethods.towersOfHanoi;

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
}
