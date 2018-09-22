/*
 * How would you design a stack which, in addition to push and pop, also has
 * a function min which returns the minimum element? Push, pop and min
 * should all operate in O(1) time.
 * SOLUTION: Create an additional simple stack inside the stack that will have 
 * the min function. Each time a new value is pushed in the stack, we check this
 * additional stack and if the value in the top is higher or the same, the value
 * is pushed in this stack. Each time there is pop, we check the additional
 * stack and if the popped value is the same, it is popped.
 */
package crackingthecodinginterviewpersonalsolutions.stacksAndQueues;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://www.ipolo.hol.es
 */
public class StackWithMin extends SimpleStack {
    
    // Additional stack to push the min values so there is an O(1) access.
    private final SimpleStack minStackValues = new SimpleStack();
    
    @Override
    public void push(int value) {
        if(this.minStackValues.peek() == -1 ||
           this.minStackValues.peek() >= value) {
            this.minStackValues.push(value);
        }
        super.push(value);
    }
    
    @Override
    public int pop() {
        int value = super.pop();
        if(value == this.minStackValues.peek()) {
            this.minStackValues.pop();
        }
        return value;
    }
    
    public int min() {
        return this.minStackValues.peek();
    }
}
