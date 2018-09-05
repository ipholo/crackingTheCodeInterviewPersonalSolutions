/*
 * Tests to the Personal Solutions to the chapter 1 of Arrays of String.
 * Book: Cracking the Coding Interview.
 * The book is property of Gayle Laakmann McDowell.
 * The solutions are only educational.
 */
package crackingthecodinginterviewpersonalsolutions;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * @author Leopoldo Hernandez
 */
public class ArraysAndStringsTest {
    
    @Test
    public void testHasAllUniqueCharacters_assertTrueWord() {
        String testWord = "qwertyuiop";
        
        boolean result = ArraysAndStrings.hasAllUniqueCharacters(testWord);
        
        assertTrue(result);
    }
    
    @Test
    public void testHasAllUniqueCharacters_assertFalseWord() {
        String testWord = "aaaabbbbcccc";
        
        boolean result = ArraysAndStrings.hasAllUniqueCharacters(testWord);
        
        assertFalse(result);
    }

    @Test
    public void testReverseCStyleString_assertResult_normalWordLength() {
        char [] testword = {'k', 'a', 'r', 'l', 'i', 't', 'a', '\0'};
        char [] expected = {'a', 't', 'i', 'l', 'r', 'a', 'k', '\0'};
        
        char [] result = ArraysAndStrings.reverseCStyleString(testword);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testReverseCStyleString_assertResult_oneWordLength() {
        char [] testword = {'p', '\0'};
        char [] expected = {'p', '\0'};
        
        char [] result = ArraysAndStrings.reverseCStyleString(testword);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testReverseCStyleString_assertResult_zeroWordLength() {
        char [] testword = {'\0'};
        char [] expected = {'\0'};
        
        char [] result = ArraysAndStrings.reverseCStyleString(testword);
        
        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveDuplicates_assertResult_multipleDuplicatedLetters() {
        char [] wordWithDuplicates =
                "aaaaabbbbcccccdddefggghhhiijjjklmmabbunohuj67AA".toCharArray();
        char [] wordWithoutDuplicates  = "abcdefghijklmuno67A".toCharArray();
        char [] expected = 
                Arrays.copyOf(wordWithoutDuplicates, wordWithDuplicates.length);
        
        char [] result = ArraysAndStrings.removeDuplicates(wordWithDuplicates);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testRemoveDuplicates_assertResult_noDuplicatesWord() {
        char [] wordWithDuplicates = "abcdefghijklmnop".toCharArray();
        char [] expected = "abcdefghijklmnop".toCharArray();
        
        char [] result = ArraysAndStrings.removeDuplicates(wordWithDuplicates);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testRemoveDuplicates_assertResult_oneDuplicatedLetter() {
        char [] wordWithDuplicates = "aaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray();
        char [] wordWithoutDuplicates  = "a".toCharArray();
        char [] expected = 
                Arrays.copyOf(wordWithoutDuplicates, wordWithDuplicates.length);
        
        char [] result = ArraysAndStrings.removeDuplicates(wordWithDuplicates);
        
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testRemoveDuplicates_assertResult_oneLetter() {
        char [] wordWithDuplicates = "a".toCharArray();
        char [] expected  = "a".toCharArray();
        
        char [] result = ArraysAndStrings.removeDuplicates(wordWithDuplicates);
        
        assertArrayEquals(expected, result);
    }

    @Test
    public void testIsAnagram_assertTrueAnagram_normalWord() {
        String word1 = "leopoldo";
        String word2 = "epldoolo";
        
        boolean result = ArraysAndStrings.isAnagram(word1, word2);
        
        assertTrue(result);
    }
    
    @Test
    public void testIsAnagram_assertTrueAnagram_oneLetterWord() {
        String word = "p";
        
        boolean result = ArraysAndStrings.isAnagram(word, word);
        
        assertTrue(result);
    }
    
    @Test
    public void testIsAnagram_assertFalseAnagram_sameLengthWord() {
        String word1 = "leopoldo";
        String word2 = "jfkalsda";
        
        boolean result = ArraysAndStrings.isAnagram(word1, word2);
        
        assertFalse(result);
    }
    
    @Test
    public void testIsAnagram_assertFalseAnagram_differtenLengthWord() {
        String word1 = "leopoldofads";
        String word2 = "jfkalsda";
        
        boolean result = ArraysAndStrings.isAnagram(word1, word2);
        
        assertFalse(result);
    }
    
    @Test
    public void testIsAnagram_assertFalseAnagram_oneDifferentLetter() {
        String word1 = "leopollo";
        String word2 = "epldoolo";
        
        boolean result = ArraysAndStrings.isAnagram(word1, word2);
        
        assertFalse(result);
    }
    
    @Test
    public void testReplaceSpacesWithPorcentage20_assertResultWithSpaces() {
        String word = "l e o p o l d  o";
        String expected = "l%20e%20o%20p%20o%20l%20d%20%20o";
        
        String result = ArraysAndStrings.replaceSpacesWithPorcentage20(word);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testReplaceSpacesWithPorcentage20_assertResultWithOnlySpaces() {
        String word = "       ";
        String expected = "%20%20%20%20%20%20%20";
        
        String result = ArraysAndStrings.replaceSpacesWithPorcentage20(word);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testReplaceSpacesWithPorcentage20_assertResultWithoutSpaces() {
        String expected = "estoyenamoradodekarlayestoesunatortura";
        
        String result =
                ArraysAndStrings.replaceSpacesWithPorcentage20(expected);
        
        assertEquals(expected, result);
    }
}
