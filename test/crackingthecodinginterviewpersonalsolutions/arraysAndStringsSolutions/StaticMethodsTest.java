/*
 * Tests to the Personal Solutions to Chapter 1: Arrays and Strings.
 * Book: Cracking the Coding Interview.
 * The book is property of Gayle Laakmann McDowell.
 * The solutions are only educational.
 */
package crackingthecodinginterviewpersonalsolutions.arraysAndStringsSolutions;

import static crackingthecodinginterviewpersonalsolutions.arraysAndStringsSolutions.StaticMethods.hasAllUniqueCharacters;
import static crackingthecodinginterviewpersonalsolutions.arraysAndStringsSolutions.StaticMethods.isARotationUsingSubstring;
import static crackingthecodinginterviewpersonalsolutions.arraysAndStringsSolutions.StaticMethods.isAnagram;
import static crackingthecodinginterviewpersonalsolutions.arraysAndStringsSolutions.StaticMethods.removeDuplicates;
import static crackingthecodinginterviewpersonalsolutions.arraysAndStringsSolutions.StaticMethods.replaceSpacesWithPorcentage20;
import static crackingthecodinginterviewpersonalsolutions.arraysAndStringsSolutions.StaticMethods.reverseCStyleString;
import static crackingthecodinginterviewpersonalsolutions.arraysAndStringsSolutions.StaticMethods.rotateImage90Degrees;
import static crackingthecodinginterviewpersonalsolutions.arraysAndStringsSolutions.StaticMethods.setRowAndColumZeroWithElementZero;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import org.junit.Test;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://www.ipolo.hol.es
 */
public class StaticMethodsTest {
    
    @Test
    public void testHasAllUniqueCharacters_assertTrueWord() {
        String testWord = "qwertyuiop";
        
        boolean result = hasAllUniqueCharacters(testWord);
        
        assertTrue(result);
    }
    
    @Test
    public void testHasAllUniqueCharacters_assertFalseWord() {
        String testWord = "aaaabbbbcccc";
        
        boolean result = hasAllUniqueCharacters(testWord);
        
        assertFalse(result);
    }

    @Test
    public void testReverseCStyleString_assertResult_normalWordLength() {
        char[] testWord = {'k', 'a', 'r', 'l', 'i', 't', 'a', '\0'};
        char[] expected = {'a', 't', 'i', 'l', 'r', 'a', 'k', '\0'};
        
        char[] result = reverseCStyleString(testWord);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testReverseCStyleString_assertResult_oneWordLength() {
        char[] testWord = {'p', '\0'};
        char[] expected = {'p', '\0'};
        
        char[] result = reverseCStyleString(testWord);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testReverseCStyleString_assertResult_zeroWordLength() {
        char[] testWord = {'\0'};
        char[] expected = {'\0'};
        
        char[] result = reverseCStyleString(testWord);
        
        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveDuplicates_assertResult_multipleDuplicatedLetters() {
        char[] wordWithDuplicates =
                "aaaaabbbbcccccdddefggghhhiijjjklmmabbunohuj67AA".toCharArray();
        char[] wordWithoutDuplicates  = "abcdefghijklmuno67A".toCharArray();
        char[] expected = 
                Arrays.copyOf(wordWithoutDuplicates, wordWithDuplicates.length);
        
        char[] result = removeDuplicates(wordWithDuplicates);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testRemoveDuplicates_assertResult_noDuplicatesWord() {
        char[] wordWithDuplicates = "abcdefghijklmnop".toCharArray();
        char[] expected = "abcdefghijklmnop".toCharArray();
        
        char[] result = removeDuplicates(wordWithDuplicates);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testRemoveDuplicates_assertResult_oneDuplicatedLetter() {
        char[] wordWithDuplicates = "aaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray();
        char[] wordWithoutDuplicates  = "a".toCharArray();
        char[] expected = 
                Arrays.copyOf(wordWithoutDuplicates, wordWithDuplicates.length);
        
        char[] result = removeDuplicates(wordWithDuplicates);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testRemoveDuplicates_assertResult_oneLetter() {
        char[] wordWithDuplicates = "a".toCharArray();
        char[] expected  = "a".toCharArray();
        
        char[] result = removeDuplicates(wordWithDuplicates);
        
        assertArrayEquals(expected, result);
    }

    @Test
    public void testIsAnagram_assertTrueAnagram_normalWord() {
        String word1 = "leopoldo";
        String word2 = "epldoolo";
        
        boolean result = isAnagram(word1, word2);
        
        assertTrue(result);
    }
    
    @Test
    public void testIsAnagram_assertTrueAnagram_oneLetterWord() {
        String word = "p";
        
        boolean result = isAnagram(word, word);
        
        assertTrue(result);
    }
    
    @Test
    public void testIsAnagram_assertFalseAnagram_sameLengthWord() {
        String word1 = "leopoldo";
        String word2 = "jfkalsda";
        
        boolean result = isAnagram(word1, word2);
        
        assertFalse(result);
    }
    
    @Test
    public void testIsAnagram_assertFalseAnagram_differtenLengthWord() {
        String word1 = "leopoldofads";
        String word2 = "jfkalsda";
        
        boolean result = isAnagram(word1, word2);
        
        assertFalse(result);
    }
    
    @Test
    public void testIsAnagram_assertFalseAnagram_oneDifferentLetter() {
        String word1 = "leopollo";
        String word2 = "epldoolo";
        
        boolean result = isAnagram(word1, word2);
        
        assertFalse(result);
    }
    
    @Test
    public void testReplaceSpacesWithPorcentage20_assertResultWithSpaces() {
        String word = "l e o p o l d  o";
        String expected = "l%20e%20o%20p%20o%20l%20d%20%20o";
        
        String result = replaceSpacesWithPorcentage20(word);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testReplaceSpacesWithPorcentage20_assertResultWithOnlySpaces() {
        String word = "       ";
        String expected = "%20%20%20%20%20%20%20";
        
        String result = replaceSpacesWithPorcentage20(word);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testReplaceSpacesWithPorcentage20_assertResultWithoutSpaces() {
        String word = "estoyenamoradodekarlayestoesunatortura";
        String expected = "estoyenamoradodekarlayestoesunatortura";
        
        String result = replaceSpacesWithPorcentage20(word);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testRotateImage90Degrees_assertResult_3x3Matrix() {
        int[][] matrix =
            {{1, 2, 3},
             {4, 5, 6},
             {7, 8, 9}};
        int[][] expected = 
            {{7, 4, 1},
             {8, 5, 2},
             {9, 6, 3}};
        
        int[][] result = rotateImage90Degrees(matrix);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testRotateImage90Degrees_assertResult_4x4Matrix() {
        int[][] matrix =
            {{1,   2,  3,  4},
             {5,   6,  7,  8},
             {9,  10, 11, 12},
             {13, 14, 15, 16}};
        int[][] expected =
            {{13,  9, 5, 1},
             {14, 10, 6, 2},
             {15, 11, 7, 3},
             {16, 12, 8, 4}};
        
        int[][] result = rotateImage90Degrees(matrix);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testRotateImage90Degrees_assertResult_5x5Matrix() {
        int[][] matrix = 
            {{1,   2,  3,  4,  5},
             {6,   7,  8,  9, 10},
             {11, 12, 13, 14, 15},
             {16, 17, 18, 19, 20},
             {21, 22, 23, 24, 25}};
        int[][] expected =
            {{21, 16, 11,  6, 1},
             {22, 17, 12,  7, 2},
             {23, 18, 13,  8, 3},
             {24, 19, 14,  9, 4},
             {25, 20, 15, 10, 5}};
        
        int[][] result = rotateImage90Degrees(matrix);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testSetRowAndColumZeroWithElementZero_assertResult_3x3Matrix() {
        int[][] matrix =
            {{1, 2, 3},
             {4, 5, 0},
             {0, 8, 9}};
        int[][] expected = 
            {{0, 2, 0},
             {0, 0, 0},
             {0, 0, 0}};
        
        int[][] result = setRowAndColumZeroWithElementZero(matrix);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testSetRowAndColumZeroWithElementZero_assertResult_5x5Matrix() {
        int[][] matrix = 
            {{ 1,  2,  3,  4,  5},
             { 6,  0,  8,  9, 10},
             {11, 12, 13, 14, 15},
             {16, 17, 18, 19, 20},
             { 0, 22, 23, 24, 25}};
        int[][] expected =
            {{0, 0,  3,  4,  5},
             {0, 0,  0,  0,  0},
             {0, 0, 13, 14, 15},
             {0, 0, 18, 19, 20},
             {0, 0,  0,  0,  0}};
        
        int[][] result = setRowAndColumZeroWithElementZero(matrix);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testSetRowAndColumZeroWithElementZero_assertResult_4x4NoZerosMatrix() {
        int[][] expected =
            {{1,   2,  3,  4},
             {5,   6,  7,  8},
             {9,  10, 11, 12},
             {13, 14, 15, 16}};
        
        int[][] result = setRowAndColumZeroWithElementZero(expected);
        
        assertArrayEquals(expected, result);
    }
        
    @Test
    public void testIsARotationUsingSubstring_assertResult_rotatedWord() {
        String word = "waterbottle";
        String wordRotated = "erbottlewat";
        
        boolean result = isARotationUsingSubstring(word, wordRotated);
        
        assertTrue(result);
    }
    
    @Test
    public void testIsARotationUsingSubstring_assertResult_noRotatedWord() {
        String word = "waterbottle";
        String wordRotated = "erbottaewat";
        
        boolean result = isARotationUsingSubstring(word, wordRotated);
        
        assertFalse(result);
    }
}
