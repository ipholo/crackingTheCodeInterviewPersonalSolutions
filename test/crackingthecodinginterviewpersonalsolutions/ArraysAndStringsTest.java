/*
 * Tests to the Personal Solutions to the chapter 1 of Arrays of String.
 * Book: Cracking the Coding Interview.
 * The book is property of Gayle Laakmann McDowell.
 * The solutions are only educational.
 */
package crackingthecodinginterviewpersonalsolutions;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

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
    public void testReverseCStyleString_assertResult() {
        char [] testword = {'k', 'a', 'r', 'l', 'i', 't', 'a', '\0'};
        char [] expected = {'a', 't', 'i', 'l', 'r', 'a', 'k', '\0'};
        
        char [] result = ArraysAndStrings.reverseCStyleString(testword);
        
        assertArrayEquals(expected, result);
    }

    @Test
    public void testRemoveDuplicates_assertResult() {
        char [] wordWithDuplicates =
                "aaaaabbbbcccccdddefggghhhiijjjklmmabbunohuj67AA".toCharArray();
        char [] wordWithoutDuplicates  = "abcdefghijklmuno67A".toCharArray();
        char [] expected = 
                Arrays.copyOf(wordWithoutDuplicates, wordWithDuplicates.length);
        
        char [] result = ArraysAndStrings.removeDuplicates(wordWithDuplicates);
        
        assertArrayEquals(expected, result);
    }
}
