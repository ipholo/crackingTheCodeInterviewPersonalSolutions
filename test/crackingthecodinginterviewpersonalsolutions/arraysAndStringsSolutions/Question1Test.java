package crackingthecodinginterviewpersonalsolutions.arraysAndStringsSolutions;

import org.junit.Test;

import static crackingthecodinginterviewpersonalsolutions.arraysAndStringsSolutions.Question1.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Question1Test {

  @Test
  public void testHasAllUniqueCharacters_useDataStructure_assertTrueWord() {
    String testWord = "qwertyuiop";

    boolean result = hasAllUniqueCharactersDataStructure(testWord);

    assertTrue(result);
  }

  @Test
  public void testHasAllUniqueCharacters_useDataStructure_assertFalseWord() {
    String testWord = "aaaabbbbcccc";

    boolean result = hasAllUniqueCharactersDataStructure(testWord);

    assertFalse(result);
  }

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
  public void testHasAllUniqueCharacters_bitwise_assertTrueWord() {
    String testWord = "qwertyuiop";

    boolean result = hasAllUniqueCharactersBitwise(testWord);

    assertTrue(result);
  }

  @Test
  public void testHasAllUniqueCharacters_bitwise_assertTrueWord2() {
    String testWord = "abcdefghijklmnopqrstuvwxyz";

    boolean result = hasAllUniqueCharactersBitwise(testWord);

    assertTrue(result);
  }

  @Test
  public void testHasAllUniqueCharacters_bitwise_assertFalseWord() {
    String testWord = "aaaabbbbcccc";

    boolean result = hasAllUniqueCharactersBitwise(testWord);

    assertFalse(result);
  }
}
