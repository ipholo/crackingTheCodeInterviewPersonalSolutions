/*
 * Personal Solutions to the chapter 1 of Arrays of String.
 * Book: Cracking the Coding Interview.
 * The book is property of Gayle Laakmann McDowell.
 * The solutions are only educational.
 */
package crackingthecodinginterviewpersonalsolutions;

import java.util.HashMap;

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
    * is represented as five characters, including the null character).
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
        char nullChar = '\0';
        for(int i = 0; i < word.length; i++) {
            if(word[i] == nullChar){
                continue;
            }
            for(int j = i + 1; j < word.length; j++) {
                if(word[j] == word[i]) {
                    word[j] = nullChar;
                }   
            }
            if(noRepeatedIndex != i) {
                word[noRepeatedIndex] = word[i];
                word[i] = nullChar;
            }
            noRepeatedIndex++;
        }
        return word;
    }
    
    /* 
    * Write a method to decide if two strings are anagrams or not.
    */
    public static boolean isAnagram(String word1, String word2) {
        if(word1.length() != word2.length()) {
            return false;
        }
        HashMap<Character, Integer> mapLetterFrequency = new HashMap<>();
        char [] letters1 = word1.toCharArray();
        char [] letters2 = word2.toCharArray();
        for(char letter: letters1) {
            if(mapLetterFrequency.containsKey(letter)) {
                int value = mapLetterFrequency.get(letter) + 1;
                mapLetterFrequency.put(letter, value);
            } else {
                mapLetterFrequency.put(letter, 1);
            }
        }
        for(char letter: letters2) {
            if(mapLetterFrequency.containsKey(letter)) {
                int value = mapLetterFrequency.get(letter) - 1;
                if(value < 1) {
                    mapLetterFrequency.remove(letter);
                } else {
                    mapLetterFrequency.put(letter, value);
                }
            } else {
                return false;
            }
        }
        return mapLetterFrequency.isEmpty();
    };
    
    /*
    * Write a method to replace all spaces in a string with ‘%20’.
    */
    public static String replaceSpacesWithPorcentage20(String word) {
        char [] letters = word.toCharArray();
        StringBuilder result = new StringBuilder();
        for(char letter: letters) {
            if(letter == ' ') {
                result.append("%20");
            } else {
                result.append(letter);
            }
        }
        return result.toString();
    }
    
    /*
    * Given an image represented by an NxN matrix, where each pixel in the image
    * is 4 bytes, write a method to rotate the image by 90 degrees.
    * Can you do this in place?
    */
    public static int [][] rotateImage90Degrees(int [][] image) {
        int size = image.length;
        int [][] imageRotated = new int[size][size];
        int newRowRotated;
        int newColRotated = size - 1;
        for(int row = 0; row < size; row++) {
            newRowRotated = 0;
            for(int col = 0; col < size; col++) {
                imageRotated[newRowRotated][newColRotated] = image[row][col];
                newRowRotated++;
            }
            newColRotated--;
        }
        return imageRotated;
    }
}
