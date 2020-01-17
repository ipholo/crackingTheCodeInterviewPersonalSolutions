package crackingthecodinginterviewpersonalsolutions.arraysAndStringsSolutions;

/*
 * Write code to reverse a C-Style String (C-String means that "abcd"
 * is represented as five characters, including the null character).
 */
class Question2 {

  /*
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
}
