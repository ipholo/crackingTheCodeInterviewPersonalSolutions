/*
 * Describe how you could use a single array to implement three stacks.
 * SOLUTION: We divide an array in three so each part is going to be a stack.
 * It is necessary to keep track of each pekk in the three stacks so we can push
 * or pop the values in each respective stack.
 */
package crackingthecodinginterviewpersonalsolutions.stacksAndQueues;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://www.ipolo.hol.es
 */
public class MultipleStacksUsingAnArray {

    // The array which is going to be used as stack.
    private final int[] stackArray;
    // This array keeps track of the peek in the stacks.
    private final int[] positions;
    private final int numberOfStacks;
    private final int numberOfValuesPerStack;

    /*
     * The constructor requires how many stacks are we going to create and what
     * is going the be the maximum number of values per stack, as it's an
     * array, we need a defined size.
     */
    public MultipleStacksUsingAnArray(
            int numberOfValuesPerStack, int numberOfStacks) {
        this.numberOfStacks = numberOfStacks;
        this.numberOfValuesPerStack = numberOfValuesPerStack;
        this.positions = new int[this.numberOfStacks];
        this.stackArray = new int[numberOfValuesPerStack * this.numberOfStacks];
        for(int i = 0; i < this.numberOfStacks; i++) {
            this.positions[i] = i * numberOfValuesPerStack;
        }
    }

    public boolean push(int stack, int value) {
        if(stack <= this.numberOfStacks && stack > 0) {
            return internalPush(stack - 1, value);
        }
        return false;
    }

    public int pop(int stack) {
        if(stack <= this.numberOfStacks && stack > 0) {
            return internalPop(stack - 1);
        }
        return -1;
    }
    
    public int peek(int stack) {
        if(stack <= this.numberOfStacks && stack > 0) {
            return internalPeek(stack - 1);
        }
        return -1;
    }

    private boolean internalPush(int numberOfStack, int value) {
        int endPosition = this.numberOfValuesPerStack * (numberOfStack + 1);
        if(this.positions[numberOfStack] < endPosition) {
            this.stackArray[this.positions[numberOfStack]] = value;
            this.positions[numberOfStack]++;
            return true;
        }
        return false;
    }

    private int internalPop(int numberOfStack) {
        int peekValue = internalPeek(numberOfStack);
        if(peekValue != -1) {
            this.positions[numberOfStack]--;
        }
        return peekValue;
    }
    
    private int internalPeek(int numberOfStack) {
        int startPosition = this.numberOfValuesPerStack * numberOfStack;
        int stackIndex = this.positions[numberOfStack] - 1;
        if(stackIndex >= startPosition) {
            int topValue = this.stackArray[stackIndex];
            return topValue;
        }
        return -1;
    }
}
