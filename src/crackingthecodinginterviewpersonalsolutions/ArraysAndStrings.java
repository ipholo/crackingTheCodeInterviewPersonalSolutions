/*
 * Personal Solutions to the chapter 1 of Arrays of String.
 * Book: Cracking the Coding Interview.
 * The book is property of Gayle Laakmann McDowell.
 * The solutions are only educational.
 */
package crackingthecodinginterviewpersonalsolutions;

/**
 * @author Leopoldo Hernandez
 */
public class ArraysAndStrings {
    
    /*
    * Implement an algorithm to determine if a string has all unique characters.
    * What if you can not use additional data structures?
    */
    public static boolean hasAllUniqueCharacters(String word) {
        int numberOfAsciiCharacters = 256;
        int [] arrayMap = new int [numberOfAsciiCharacters];
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
    * Write code to reverse a C-Style String (C-String means that “abcd”
    * is represented as five characters, including the null character )
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
    
    /*
    * Design an algorithm and write code to remove the duplicate characters in
    * a string without using any additional buffer NOTE: One or two additional
    * variables are fine An extra copy of the array is not.
    */
    public static char [] removeDuplicates(char [] word) {
        int noRepeatedIndex = 0;
        for(int i = 0; i < word.length; i++) {
            if(word[i] == '\0'){
                continue;
            }
            for(int j = i + 1; j < word.length; j++) {
                if(word[j] == word[i]) {
                    word[j] = '\0';
                }   
            }
            if(noRepeatedIndex != i) {
                word[noRepeatedIndex] = word[i];
                word[i] = '\0';
            }
            noRepeatedIndex++;
        }
        return word;
    }
}
