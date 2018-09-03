/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crackingthecodinginterviewpersonalsolutions;

/**
 *
 * @author leopoldohernandez
 */
public class ArraysAndStrings {
    
    /*
    Implement an algorithm to determine if a string has all unique characters.
    What if you can not use additional data structures?
    */
    public static boolean hasAllUniqueCharacters(String word) {
        int [] arrayMap = new int [256];
        char [] letters = word.toCharArray();
        for(char letter: letters) {
            if(arrayMap[letter] != 0) {
                return false;
            }
            arrayMap[letter] = 1;
        }
        return true;
    }
    
    /*
    Write code to reverse a C-Style String (C-String means that “abcd”
    is represented as five characters, including the null character )
    */
    public static char[] reverseCStyleString(char [] word) {
        int endIndexWithoutNull = word.length - 2;
        int startIndex = 0;
        while(startIndex < endIndexWithoutNull) {
            word[startIndex] ^= word[endIndexWithoutNull];
            word[endIndexWithoutNull] ^= word[startIndex];
            word[startIndex] ^= word[endIndexWithoutNull];
            startIndex++;
            endIndexWithoutNull--;
        }
        return word;
    }
    
}
