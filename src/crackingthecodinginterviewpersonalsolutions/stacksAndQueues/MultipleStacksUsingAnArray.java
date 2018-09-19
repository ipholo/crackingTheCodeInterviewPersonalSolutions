/*
 * Multiple Stacks Using An Array Class.
 * The constructor requires a definied size of the stacks so the array can be
 * divided in three. The stacks size is limited to the array length.
 * The number of stacks in the array can be definied in NUMBER_OF_STACKS 
 * variable.
 */
package crackingthecodinginterviewpersonalsolutions.stacksAndQueues;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://www.ipolo.hol.es
 */
public class MultipleStacksUsingAnArray {

    private final int numberOfStacks;
    private final int numberOfValuesPerStack;
    private final int[] stackArray;
    private final int[] positions;

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
