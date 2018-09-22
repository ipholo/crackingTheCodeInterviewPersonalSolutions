/*
 * Imagine a (literal) stack of plates. If the stack gets too high, it might
 * topple. Therefore, in real life, we would likely start a new stack when
 * the previous stack exceeds some threshold. Implement a data structure
 * SetOfStacks that mimics this. SetOfStacks should be composed of several
 * stacks, and should create a new stack once the previous one exceeds
 * capacity SetOfStacks push() and SetOfStacks pop() should behave
 * identically to a single stack (that is, pop() should return the same
 * values as it would if there were just a single stack).
 * SOLUTION: Set of Stacks class was created. This class are composed of several
 * stacks working as a single stack. Each time a stack exceeds a max capacity a 
 * new stack is created. The stacks are arranged in an Array List. An instance
 * of stack is used to point to the current active stack to have easy access to
 * it and it changes if a new stack is added or removed from the array list.
 */
package crackingthecodinginterviewpersonalsolutions.stacksAndQueues;

import java.util.ArrayList;
import java.util.Stack;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://www.ipolo.hol.es
 */
public class SetOfStacks<E> {
    
    private final ArrayList<Stack> arrayListOfStacks = new ArrayList();
    private final int maxCapacityPerStack;
    private Stack activeStack = null;

    public SetOfStacks(int maxCapacityPerStack) {
        this.maxCapacityPerStack = maxCapacityPerStack;
    }
    
    public void push(Object object) {
        if(this.activeStack == null ||
           this.activeStack.size() >= this.maxCapacityPerStack) {
            pushStackToArray(object);
            return;
        }
        this.activeStack.push(object);
    }
    
    public Object pop() {
        if(this.activeStack == null || this.activeStack.isEmpty()) {
            return null;
        }
        Object object = this.activeStack.pop();
        if(this.activeStack.isEmpty()) {
            this.arrayListOfStacks.remove(this.activeStack);
            setLastElementInArrayAsActiveStack();
        }
        return object;
    }
    
    /*
     * FOLLOW UP:
     * Implement a function popAt(int index) which performs a pop operation on a
     * specific sub-stack.
     */
    public Object popAt(int index) {
        if(index >= this.arrayListOfStacks.size() || index < 0) {
            return null;
        }
        if(index == this.arrayListOfStacks.size() - 1) {
            return pop();
        }
        Stack stackAtIndex = this.arrayListOfStacks.get(index);
        Object object = stackAtIndex.pop();
        if(stackAtIndex.isEmpty()) {
            this.arrayListOfStacks.remove(stackAtIndex);
            setLastElementInArrayAsActiveStack();
        }
        return object;
    }
    
    private void pushStackToArray(Object object) {
        Stack newStack = new Stack();
        newStack.push(object);
        this.arrayListOfStacks.add(newStack);
        setLastElementInArrayAsActiveStack();
    }
    
    private void setLastElementInArrayAsActiveStack() {
        if(this.arrayListOfStacks.isEmpty()) {
            this.activeStack = null;
            return;
        }
        int arraySize = this.arrayListOfStacks.size();
        this.activeStack = this.arrayListOfStacks.get(arraySize - 1);
    }
}
