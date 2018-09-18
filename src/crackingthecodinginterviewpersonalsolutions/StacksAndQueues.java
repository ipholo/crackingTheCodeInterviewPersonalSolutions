/*
 * Personal Solutions to Chapter 3: Stacks and Queues.
 * Book: Cracking the Coding Interview.
 * The book is property of Gayle Laakmann McDowell.
 * The solutions are only educational.
 */
package crackingthecodinginterviewpersonalsolutions;

import crackingthecodinginterviewpersonalsolutions.auxiliaryClassesToProblems.MultipleStacksUsingAnArray;
import crackingthecodinginterviewpersonalsolutions.auxiliaryClassesToProblems.StackWithMin;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://www.ipolo.hol.es
 */
public class StacksAndQueues {
    
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
        return new StackWithMin();
    }
}
