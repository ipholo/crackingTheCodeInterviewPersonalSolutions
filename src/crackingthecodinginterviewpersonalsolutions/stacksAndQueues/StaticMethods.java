/*
 * Personal Solutions to Chapter 3: Stacks and Queues.
 * Book: Cracking the Coding Interview.
 * The book is property of Gayle Laakmann McDowell.
 * The solutions are only educational.
 */
package crackingthecodinginterviewpersonalsolutions.stacksAndQueues;

import java.util.Stack;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://www.ipolo.hol.es
 */
public class StaticMethods {
    
    /*
     * In the classic problem of the Towers of Hanoi, you have 3 rods and N
     * disks of different sizes which can slide on to any tower. The puzzle
     * starts with disks sorted in ascending order of size from top to bottom
     * (e g , each disk sits on top of an even larger one) You have the
     * following constraints:
     * (A) Only one disk can be moved at a time
     * (B) A disk is slid off the top of one rod onto the next rod
     * (C) A disk can only be placed on top of a larger disk
     * Write a program to move the disks from the first rod to the last using
     * Stacks
     */
    public static Stack towersOfHanoi(int numberOfDisks) {
        Stack<Integer> firstRod = new Stack();
        Stack<Integer> auxRod = new Stack();
        Stack<Integer> lastRod = new Stack();
        for(int size = numberOfDisks; size > 0; size--) {
            firstRod.push(size);
        }
        towersOfHanoi(numberOfDisks, firstRod, auxRod, lastRod);
        return lastRod;
    }
    
    /*
     * Write a program to sort a stack in ascending order You should not make
     * any assumptions about how the stack is implemented. The following are the
     * only functions that should be used to write this program:
     * push | pop | peek | isEmpty
     */
    public static Stack<Integer> sortStack(Stack<Integer> stack) {
        if(stack.isEmpty()) {
            return stack;
        }
        Stack<Integer> auxStack1 = new Stack();
        Stack<Integer> auxStack2 = new Stack();
        while(!stack.isEmpty()) {
            auxStack1.push(stack.pop());
        }
        while(!auxStack1.isEmpty() || !auxStack2.isEmpty()) {
            passValuesFromNotEmptyToEmpty(auxStack2, auxStack1, stack);
            passValuesFromNotEmptyToEmpty(auxStack1, auxStack2, stack);
        }
        return stack;
    }
    
    private static void towersOfHanoi(int N,
            Stack<Integer> firstRod, 
            Stack<Integer> auxRod, 
            Stack<Integer> lastRod) {
        if(N < 1) {
            return;
        }
        towersOfHanoi(N - 1, firstRod, lastRod, auxRod);
        lastRod.push(firstRod.pop());
        towersOfHanoi(N - 1, auxRod, firstRod, lastRod);
    }
    
    private static void passValuesFromNotEmptyToEmpty(
            Stack<Integer> emtpyStack,
            Stack<Integer> notEmptyStack,
            Stack<Integer> orderedStack) {
        if(notEmptyStack.isEmpty()) {
            return;
        }
        orderedStack.push(notEmptyStack.pop());
        while(!notEmptyStack.isEmpty()) {
            if(orderedStack.peek() < notEmptyStack.peek()) {
                emtpyStack.push(orderedStack.pop());
                orderedStack.push(notEmptyStack.pop());
            } else {
                emtpyStack.push(notEmptyStack.pop());
            }
        }
    }
}
