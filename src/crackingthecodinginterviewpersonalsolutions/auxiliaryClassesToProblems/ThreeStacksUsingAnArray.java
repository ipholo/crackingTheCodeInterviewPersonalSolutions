/*
 * Three Stacks Using An Array Class.
 * The constructor requires a definied size of the stacks so the array can be
 * divided in three. The stacks size is limited to the array length.
 * The number of stacks in the array can be definied in NUMBER_OF_STACKS 
 * variable.
 */
package crackingthecodinginterviewpersonalsolutions.auxiliaryClassesToProblems;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://www.ipolo.hol.es
 */
public class ThreeStacksUsingAnArray {

    private final int NUMBER_OF_STACKS = 3;
    private final int numberOfValuesPerStack;
    private final int[] stackArray;
    private final int[] positions = new int[NUMBER_OF_STACKS];

    public ThreeStacksUsingAnArray(int numberOfValuesPerStack) {
        this.numberOfValuesPerStack = numberOfValuesPerStack;
        this.stackArray = new int[numberOfValuesPerStack * NUMBER_OF_STACKS];
        for(int i = 0; i < NUMBER_OF_STACKS; i++) {
            this.positions[i] = i * numberOfValuesPerStack;
        }
    }

    public boolean push(int stack, int value) {
        if(stack <= NUMBER_OF_STACKS && stack > 0) {
            return internalPush(stack - 1, value);
        }
        return false;
    }

    public int pop(int stack) {
        if(stack <= NUMBER_OF_STACKS && stack > 0) {
            return internalPop(stack - 1);
        }
        return -1;
    }
    
    public int peek(int stack) {
        if(stack <= NUMBER_OF_STACKS && stack > 0) {
            return internalPeek(stack - 1);
        }
        return -1;
    }

    private boolean internalPush(int numberOfStack, int value) {
        int endPosition = numberOfValuesPerStack * (numberOfStack + 1);
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
        int startPosition = numberOfValuesPerStack * numberOfStack;
        int stackIndex = this.positions[numberOfStack] - 1;
        if(stackIndex >= startPosition) {
            int topValue = this.stackArray[stackIndex];
            return topValue;
        }
        return -1;
    }
}
