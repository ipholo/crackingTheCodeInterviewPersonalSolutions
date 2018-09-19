/*
 * Personal Solutions to Chapter 3: Stacks and Queues.
 * Book: Cracking the Coding Interview.
 * The book is property of Gayle Laakmann McDowell.
 * The solutions are only educational.
 */
package crackingthecodinginterviewpersonalsolutions.stacksAndQueues;

import crackingthecodinginterviewpersonalsolutions.stacksAndQueues.MultipleStacksUsingAnArray;
import crackingthecodinginterviewpersonalsolutions.stacksAndQueues.SetOfStacks;
import crackingthecodinginterviewpersonalsolutions.stacksAndQueues.StackWithMin;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://www.ipolo.hol.es
 */
public class StaticMethods {
    
    /*
     * Describe how you could use a single array to implement three stacks.
     */
    public static MultipleStacksUsingAnArray threeStacksUsingAnArray(
            int numberOfValuesPerStack) {
        // Create a stack by dividing an array of size N in three:
        // [0, N / 3 - 1] [N / 3, 2N / 3 - 1] [2N / 3, N]
        // Create an array of three elements to point to respective peek so we 
        // can do the basic operations: push, pop and peek.
        // The stack is limited to the size of the array, because arrays have a
        // definied value.
        // The class is definied in package auxiliary classes to problems.
        return new MultipleStacksUsingAnArray(numberOfValuesPerStack, 3);
    }
    
    /*
     * How would you design a stack which, in addition to push and pop, also has
     * a function min which returns the minimum element? Push, pop and min
     * should all operate in O(1) time.
     */
    public static StackWithMin stackWithMinOperation() {
        // Create an additional simple stack inside the stack that will have
        // the min function. Each time a new value is put in the stack, we
        // check this additional stack and if the value in the top is higher or
        // the same, the value is pushed in this stack. Each time there is pop,
        // we check the additional stack and if it the popped value is the same,
        // it is popped.
        // The class is definied in package auxiliary classes to problems.
        return new StackWithMin();
    }
    
    /*
     * Imagine a (literal) stack of plates. If the stack gets too high, it might
     * topple. Therefore, in real life, we would likely start a new stack when
     * the previous stack exceeds some threshold. Implement a data structure
     * SetOfStacks that mimics this. SetOfStacks should be composed of several
     * stacks, and should create a new stack once the previous one exceeds
     * capacity SetOfStacks push() and SetOfStacks pop() should behave
     * identically to a single stack (that is, pop() should return the same
     * values as it would if there were just a single stack).
     */
    public static SetOfStacks getSetOfStacks(int maxCapacityPerStack) {
        // A SetOfStacks class was created that used an ArrayList to arrange
        // multiple stacks to work as one.
        // The class is definied in package auxiliary classes to problems.
        return new SetOfStacks(maxCapacityPerStack);
    }
    
    /*
    * Implement a function popAt(int index) which performs a pop operation on a
    * specific sub-stack.
    */
    public static SetOfStacks getSetOfStacksWithPopAt(int maxCapacityPerStack) {
        // The class in the previous problem is used here.
        // popAt function is added to the class and it returns the stack in
        // order of creation, being zero the first stack created and the last 
        // index being the currect active stack.
        return new SetOfStacks(maxCapacityPerStack);
    }
}
