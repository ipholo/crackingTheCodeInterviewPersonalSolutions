/*
 * A stack with all the three basic stack operations (peek, push, pop) and a
 * min function which returns the current minimum value in the stack in
 * constant time (O(1)).
 */
package crackingthecodinginterviewpersonalsolutions.auxiliaryClassesToProblems;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://www.ipolo.hol.es
 */
public class StackWithMin extends PersonalStack{
    
    private final PersonalStack minStackValues = new PersonalStack();
    
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
