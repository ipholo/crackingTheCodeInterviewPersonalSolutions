package crackingthecodinginterviewpersonalsolutions.arraysAndStringsSolutions;

import java.util.HashSet;

/*
 * Implement an algorithm to determine if a string has all unique
 * characters. What if you can not use additional data structures?
 */
class Question1 {

  /*
   * SOLUTION 1: If an additional data structure can be used, a HashSet
   * can fit to check that no repeated characters exists.
   */
  static boolean hasAllUniqueCharactersDataStructure(String word) {
    HashSet<Character> hashSet = new HashSet<>();
    // Iterate the word.
    for (char letter : word.toCharArray()) {
      // If HashSet contains a letter that means it is repeated.
      if (hashSet.contains(letter)) {
        return false;
      }
      // Add letter to indicate letter exists in word.
      hashSet.add(letter);
    }
    return true;
  }

  /*
   * SOLUTION 2: As no additional data structure can be used, an array is
   * used to store the repeated characters using his ASCII code. It is assumed
   * that only 256 characters are used. Time complexity O(n).
   */
  static boolean hasAllUniqueCharacters(String word) {
    // Assuming only 256 ascii characters.
    // By default booleans are initialized in false.
    boolean[] hasLetter = new boolean[256];
    // Iterate the word.
    for (char letter : word.toCharArray()) {
      // If array boolean has letter that means it is repeated.
      if (hasLetter[letter]) {
        return false;
      }
      // Flag set to true to indicate letter exists in word.
      hasLetter[letter] = true;
    }
    return true;
  }

  /*
   * SOLUTION 3: Assuming only lowercase characters are allowed (26 letters)
   * a int (32 bits) can be used by using shift bitwise operator.
   */
  static boolean hasAllUniqueCharactersBitwise(String word) {
    // A variable initialized in zero is used to check if a variable exists or not.
    int checker = 0;
    for (char letter : word.toCharArray()) {
      // If checker and shift operator is 1, this means the letter already
      // exists in the word as it was already shifted.
      if ((checker & (1 << (letter - 'a'))) == 1) {
        return false;
      }
      // Using shift operator to move 1 across 32 bits.
      checker |= (1 << (letter - 'a'));
    }
    return true;
  }
}
