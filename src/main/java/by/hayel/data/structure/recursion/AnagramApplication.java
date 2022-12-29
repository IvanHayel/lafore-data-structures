package by.hayel.data.structure.recursion;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AnagramApplication {
  private static final String TEST_WORD = "cats";
  private static final int TEST_SIZE = TEST_WORD.length();

  private static int size = TEST_SIZE;
  private static int count;
  private static char[] chars = new char[100];

  static {
    for (int i = 0; i < TEST_SIZE; i++) chars[i] = TEST_WORD.charAt(i);
  }

  public static void main(String[] args) {
    log.info("Anagrams for word: {}", TEST_WORD);
    generateAnagrams(TEST_SIZE);
  }

  private static void generateAnagrams(int size) {
    if (size == 1) return;
    for (int i = 0; i < size; i++) {
      generateAnagrams(size - 1);
      if (size == 2) logWord();
      rotate(size);
    }
  }

  private static void logWord() {
    var builder = new StringBuilder();
    for (int i = 0; i < size; i++) builder.append(chars[i]);
    log.info(String.format("%d. %s", ++count, builder));
  }

  private static void rotate(int size) {
    int j;
    int position = AnagramApplication.size - size;
    char temp = chars[position];
    for (j = position + 1; j < AnagramApplication.size; j++)
      chars[j - 1] = chars[j];
    chars[j - 1] = temp;
  }
}
