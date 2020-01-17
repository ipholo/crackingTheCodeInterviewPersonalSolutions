package crackingthecodinginterviewpersonalsolutions.arraysAndStringsSolutions;

import org.junit.Test;

import static crackingthecodinginterviewpersonalsolutions.arraysAndStringsSolutions.Question2.*;
import static org.junit.Assert.assertArrayEquals;

public class Question2Test {

    @Test
    public void testReverseCStyleString_assertResult_normalWordLength() {
        char[] testWord = {'l', 'e', 'o', 'p', 'o', 'l', 'd', '\0'};
        char[] expected = {'d', 'l', 'o', 'p', 'o', 'e', 'l', '\0'};

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
}
