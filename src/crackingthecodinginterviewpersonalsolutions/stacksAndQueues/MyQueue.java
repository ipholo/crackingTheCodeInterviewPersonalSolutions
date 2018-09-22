/*
 * Implement a MyQueue class which implements a queue using two stacks.
 * SOLUTION: The first stack is used to enqueue values. To dequeue, all values
 * are popped from the first stack and pushed to the second one, after that, we
 * return the popped value from the second stack.
 * 
 */
package crackingthecodinginterviewpersonalsolutions.stacksAndQueues;

import java.util.Stack;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://www.ipolo.hol.es
 */
public class MyQueue<E> {
    
    private final Stack firstStack = new Stack();
    private final Stack secondStack = new Stack();
    
    public void enqueue(Object object) {
        firstStack.push(object);
    }
    
    public Object dequeue() {
        if(firstStack.isEmpty() && secondStack.isEmpty()) {
            return null;
        }
        if(secondStack.isEmpty()) {
            while(!firstStack.isEmpty()) {
                secondStack.push(firstStack.pop());
            }
        }
        return secondStack.pop();
    }
}
