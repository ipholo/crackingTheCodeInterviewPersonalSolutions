/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crackingthecodinginterviewpersonalsolutions;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author leopoldohernandez
 */
public class ArraysAndStringsTest {
    
    @Test
    public void testHasAllUniqueCharacters_assertTrueWord() {
        String testWord = "qwertyuiop";
        boolean expected = true;
        
        boolean result = ArraysAndStrings.hasAllUniqueCharacters(testWord);
        
        assertEquals(result, expected);
    }
    
    @Test
    public void testHasAllUniqueCharacters_assertFalseWord() {
        String testWord = "aaaabbbbcccc";
        boolean expected = false;
        
        boolean result = ArraysAndStrings.hasAllUniqueCharacters(testWord);
        
        assertEquals(result, expected);
    }

    @Test
    public void testHasAllUniqueCharacters() {
        char [] testword = {'k', 'a', 'r', 'l', 'i', 't', 'a', '\0'};
        char [] expected = {'a', 't', 'i', 'l', 'r', 'a', 'k', '\0'};
        
        char [] result = ArraysAndStrings.reverseCStyleString(testword);
        
        assertArrayEquals(result, expected);
    }
    
}
