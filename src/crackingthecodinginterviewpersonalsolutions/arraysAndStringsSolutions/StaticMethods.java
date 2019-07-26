/*
 * Personal Solutions to Chapter 1: Arrays and Strings.
 * Book: Cracking the Coding Interview.
 * The book is property of Gayle Laakmann McDowell.
 * The solutions are only educational.
 */
package crackingthecodinginterviewpersonalsolutions.arraysAndStringsSolutions;

import java.util.Arrays;
import java.util.HashMap;

/*
 * @author Leopoldo Hernandez
 * @linktourl http://ipolo.tech
 */
class StaticMethods {

  /*
   * Implement an algorithm to determine if a string has all unique
   * characters. What if you can not use additional data structures?
   * SOLUTION: As no additional data structure can be used, an array is
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
   * Write code to reverse a C-Style String (C-String means that "abcd"
   * is represented as five characters, including the null character).
   * SOLUTION: The string is reversed in O(n) complexity and without using an extra variable
   * to do the inversion.
   */
  static char[] reverseCStyleString(char[] word) {
    // 2 is subtracted from the word length because we assume the last character is null.
    int endIndex = word.length - 2;
    int startIndex = 0;
    // The start letter and the end letter of the word are inverted.
    while (startIndex < endIndex) {
      invertCharactersInArray(word, startIndex, endIndex);
      startIndex++;
      endIndex--;
    }
    return word;
  }

  /*
   * Invert a char array. This inversion is done using a XOR function to avoid using an extra variable.
   */
  private static void invertCharactersInArray(char[] array, int index1, int index2) {
    array[index1] ^= array[index2];
    array[index2] ^= array[index1];
    array[index1] ^= array[index2];
  }

  /*
   * Design an algorithm and write code to remove the duplicate characters in
   * a string without using any additional buffer NOTE: One or two additional
   * variables are fine, an extra copy of the array is not.
   */
  static char[] removeDuplicates(char[] word) {
    // First Additional Variable = noRepeatedIndex.
    // Second  Additional Variable = nullChar.
    // The second variable is only needed to make the code more readable.
    // As no additional buffer is allowed, two "for" are used, making it an O(n^2) solution.
    int noRepeatedIndex = 0;
    char nullChar = '\0';
    // Iterate word.
    for (int i = 0; i < word.length; i++) {
      // If word is a null character that means it's a repeated word, so we continue loop.
      if (word[i] == nullChar) {
        continue;
      }
      // From index letter we check if the letter that follows are repeated.
      // If they are repeated, they are changed to null.
      for (int j = i + 1; j < word.length; j++) {
        if (word[i] == word[j]) {
          word[j] = nullChar;
        }
      }
      // A no repeated index is used to keep letter at starting and keeping the
      // null characters at the end and not in the middle.
      if (noRepeatedIndex != i) {
        word[noRepeatedIndex] = word[i];
        word[i] = nullChar;
      }
      noRepeatedIndex++;
    }
    return word;
  }

  /*
   * Write a method to decide if two strings are anagrams or not.
   * SOLUTION: Using a hashmap to store all characters in first word and
   * remove characters when passing second word.
   * Complexity: O(n + m) = O(n) where n + m is the length of the two words.
   */
  static boolean isAnagram(String word1, String word2) {
    // First check if words have the same length. If length differ,
    // they cannot be anagrams.
    if (word1.length() != word2.length()) {
      return false;
    }
    HashMap<Character, Integer> mapLetterFrequency = new HashMap<>();
    // We iterate the first word and store each character and its frequency in a
    // Hashmap (to have a O(1) access to the letters).
    for (char letter : word1.toCharArray()) {
      if (mapLetterFrequency.containsKey(letter)) {
        int value = mapLetterFrequency.get(letter) + 1;
        mapLetterFrequency.put(letter, value);
      } else {
        mapLetterFrequency.put(letter, 1);
      }
    }
    // We iterate the second word and for each, we remove a frequency for map.
    // If frequency reaches zero, the character is removed.
    // If a character doesn't exist in the map the word is not an anagram.
    for (char letter : word2.toCharArray()) {
      if (mapLetterFrequency.containsKey(letter)) {
        int value = mapLetterFrequency.get(letter) - 1;
        if (value < 1) {
          mapLetterFrequency.remove(letter);
        } else {
          mapLetterFrequency.put(letter, value);
        }
      } else {
        return false;
      }
    }
    // If the two words ara anagrams, they hashmap should be left empty.
    return mapLetterFrequency.isEmpty();
  }

  /*
   * Alternative method to isAnagram.
   * SOLUTION: Sort both words and then compare them.
   * The complexity depends on the sorting complexity.
   * Best case O(n log(n))
   */
  static boolean isAnagramUsingSort(String word1, String word2) {
    char[] letters1 = word1.toCharArray();
    char[] letters2 = word2.toCharArray();
    Arrays.sort(letters1);
    Arrays.sort(letters2);
    return Arrays.equals(letters1, letters2);
  }

  /*
   * Write a method to replace all spaces in a string with ‘%20’.
   * SOLUTION: As a String is immutable, StringBuilder could be used as it is
   * mutable.
   * Complexity is O(n)
   */
  static String replaceSpacesWithPercentage20(String word) {
    char[] letters = word.toCharArray();
    StringBuilder result = new StringBuilder();
    for (char letter : letters) {
      if (letter == ' ') {
        result.append("%20");
      } else {
        result.append(letter);
      }
    }
    return result.toString();
  }

  /*
   * Alternative method to replaceSpacesWithPercentage20.
   * Replace uses under the hood StringBuilder.
   */
  static String replaceSpacesWithPercentage20WithReplace(String word) {
    return word.replace(" ", "%20");
  }

  /*
   * Given an image represented by an NxN matrix, where each pixel in the
   * image is 4 bytes, write a method to rotate the image by 90 degrees.
   * Can you do this in place?
   * SOLUTION: We are going to rotate the matrix circularly. First around matrix
   * then in the center.
   */
  static int[][] rotateImage90Degrees(int[][] image) {
    int matrixSize = image.length;
    // First loop will pass elements from outside to inside the matrix.
    for (int startRow = 0; startRow < matrixSize / 2; startRow++) {
      // Element by element is moved to its new position.
      int newMatrixSize = matrixSize - startRow - 1;
      for (int startCol = startRow; startCol < newMatrixSize; startCol++) {
        int temp = image[startRow][startCol];
        int endCol = matrixSize - 1 - startCol;
        int endRow = matrixSize - 1 - startRow;
        image[startRow][startCol] = image[endCol][startRow];
        image[endCol][startRow] = image[endRow][endCol];
        image[endRow][endCol] = image[startCol][endRow];
        image[startCol][endRow] = temp;
      }
    }
    return image;
  }

  /*
   * Write an algorithm such that if an element in an MxN matrix is 0,
   * its entire row and column is set to 0.
   * SOLUTION: Pass Matrix, if a zero is found convert to zero all previous passed
   * rows and columns, then, store the row and column into arrays, so in future passes automatically
   * convert them to zero.
   * Complexity O(n^2)
   */
  static int[][] setRowAndColumnZeroWithElementZero(int[][] matrix) {
    int rowSize = matrix.length;
    int colSize = matrix[0].length;
    boolean[] setRowToZero = new boolean[rowSize];
    boolean[] setColToZero = new boolean[colSize];
    for (int row = 0; row < rowSize; row++) {
      for (int col = 0; col < colSize; col++) {
        if (matrix[row][col] == 0) {
          if (!setRowToZero[row] && row > 0) {
            int tempRow = row;
            while (tempRow > 0) {
              tempRow--;
              matrix[tempRow][col] = 0;
            }
          }
          if (!setColToZero[col] && col > 0) {
            int tempCol = col;
            while (tempCol > 0) {
              tempCol--;
              matrix[row][tempCol] = 0;
            }
          }
          setRowToZero[row] = true;
          setColToZero[col] = true;
        } else if (setRowToZero[row] || setColToZero[col]) {
          matrix[row][col] = 0;
        }
      }
    }
    return matrix;
  }

  /*
   * Assume you have a method isSubstring which checks if one word is a
   * substring of another. Given two strings, s1 and s2, write code to check
   * if s2 is a rotation of s1 using only one call to isSubstring
   * (i e , “waterbottle” is a rotation of “erbottlewat”).
   */
  static boolean isARotationUsingSubstring(String word, String wordRotated) {
    String concatenatedWord = wordRotated + wordRotated;
    return isSubstring(concatenatedWord, word);
  }

  private static boolean isSubstring(String string, String substring) {
    return string.contains(substring);
  }
}
