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
    int numberOfAsciiCharacters = 256;
    int[] arrayMap = new int[numberOfAsciiCharacters];
    char[] letters = word.toCharArray();
    for (char letter : letters) {
      if (arrayMap[letter] != 0) {
        return false;
      }
      arrayMap[letter] = 1;
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
    while (startIndex < endIndex) {
      invertCharactersInArray(word, startIndex, endIndex);
      startIndex++;
      endIndex--;
    }
    return word;
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
    for (int i = 0; i < word.length; i++) {
      if (word[i] == nullChar) {
        continue;
      }
      for (int j = i + 1; j < word.length; j++) {
        if (word[i] == word[j]) {
          word[j] = nullChar;
        }
      }
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
    if (word1.length() != word2.length()) {
      return false;
    }
    HashMap<Character, Integer> mapLetterFrequency = new HashMap<>();
    char[] letters1 = word1.toCharArray();
    char[] letters2 = word2.toCharArray();
    for (char letter : letters1) {
      if (mapLetterFrequency.containsKey(letter)) {
        int value = mapLetterFrequency.get(letter) + 1;
        mapLetterFrequency.put(letter, value);
      } else {
        mapLetterFrequency.put(letter, 1);
      }
    }
    for (char letter : letters2) {
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
   */
  static int[][] rotateImage90Degrees(int[][] image) {
    int matrixSize = image.length;
    int[][] imageRotated = new int[matrixSize][matrixSize];
    // 90 Degrees: newRowRotated = 0, newColRotated = matrixSize
    // 180 Degrees: newRowRotated = matrixSize, newColRotated = matrixSize
    // 270 Degrees: newRowRotated = matrixSize, newColRotated = 0
    // 360 Degrees: newRowRotated = 0, newColRotated = 0
    int newRowRotated;
    int newColRotated = matrixSize - 1;
    for (int[] imageRow : image) {
      newRowRotated = 0;
      for (int col = 0; col < matrixSize; col++) {
        imageRotated[newRowRotated][newColRotated] = imageRow[col];
        newRowRotated++;
      }
      newColRotated--;
    }
    return imageRotated;
  }

  /*
   * Write an algorithm such that if an element in an MxN matrix is 0,
   * its entire row and column is set to 0.
   * SOLUTION: Pass Matrix, if a zero is found convert to zero all previous passed
   * rows and columns, then, store the row and column into arrays, so in future passes automatically
   * convert them to zero.
   */
  static int[][] setRowAndColumnZeroWithElementZero(int[][] matrix) {
    int matrixSize = matrix.length;
    int[] mapRow = new int[matrixSize];
    int[] mapCol = new int[matrixSize];
    for (int row = 0; row < matrixSize; row++) {
      for (int col = 0; col < matrixSize; col++) {
        if (matrix[row][col] == 0) {
          if (mapRow[row] == 0 && row > 0) {
            int tempRow = row;
            while (tempRow > 0) {
              tempRow--;
              matrix[tempRow][col] = 0;
            }
          }
          if (mapCol[col] == 0 && col > 0) {
            int tempCol = col;
            while (tempCol > 0) {
              tempCol--;
              matrix[row][tempCol] = 0;
            }
          }
          mapRow[row] = 1;
          mapCol[col] = 1;
        } else if (mapRow[row] == 1 || mapCol[col] == 1) {
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

  /*
   * Invert a char array. This inversion is done using a XOR function.
   */
  private static void invertCharactersInArray(char[] array, int index1, int index2) {
    array[index1] ^= array[index2];
    array[index2] ^= array[index1];
    array[index1] ^= array[index2];
  }

  private static boolean isSubstring(String string, String substring) {
    return string.contains(substring);
  }
}
