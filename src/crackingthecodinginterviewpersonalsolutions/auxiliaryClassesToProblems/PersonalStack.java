/*
 * A Stack implementation with push, pop and peek functions.
 */
package crackingthecodinginterviewpersonalsolutions.auxiliaryClassesToProblems;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://www.ipolo.hol.es
 */
public class PersonalStack {
    
    private Node top = null;
    
    public void push(int value) {
        Node node = new Node(value);
        node.next = this.top;
        this.top = node;
    }
    
    public int pop() {
        int value = privatePeek();
        this.top = value != -1 ? this.top.next : this.top;
        return value;
    }
    
    public int peek() {
        return privatePeek();
    }
    
    private int privatePeek() {
        if(this.top != null) {
            return this.top.data;
        }
        return -1;
    }
}
