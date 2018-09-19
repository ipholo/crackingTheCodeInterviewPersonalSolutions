/*
 * Set of Stacks class. This class are composed of several stacks working as a
 * single stack. Each time a stack exceeds a max capacity a new stack is
 * created. The stacks are arranged in an Array List. An instance of stack is
 * used to point to the current active stack to have easy access to it and it
 * changes if a new stack is added or removed to the array list.
 */
package crackingthecodinginterviewpersonalsolutions.auxiliaryClassesToProblems;

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
           this.activeStack.size() <= this.maxCapacityPerStack) {
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
