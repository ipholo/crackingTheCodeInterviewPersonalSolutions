/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crackingthecodinginterviewpersonalsolutions;

import crackingthecodinginterviewpersonalsolutions.auxiliaryClassesToProblems.ThreeStacksUsingAnArray;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://www.ipolo.hol.es
 */
public class StacksAndQueues {
    
    /*
     * Describe how you could use a single array to implement three stacks.
     */
    public static ThreeStacksUsingAnArray treeStacksUsingAnArray(
            int numberOfValuesPerStack) {
        // Create a stack by dividing an array of size N in three:
        // [0, N / 3 - 1] [N / 3, 2N / 3 - 1] [2N / 3, N]
        // Create an array of three elements to point to respective peek so we 
        // can do the basic operations: push, pop and peek.
        // The stack is limited to the size of the array, because arrays have a
        // definied value.
        // The class is definied in package auxiliary classes to problems.
        return new ThreeStacksUsingAnArray(numberOfValuesPerStack);
    }
}
