package by.hayel.data.structure.sort;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MergeSortApplication {
  private static final int[] TEST_A = {23, 47, 81, 95};
  private static final int[] TEST_B = {7, 14, 39, 55, 62, 74};
  private static final int[] TEST_C = new int[10];

  public static void main(String[] args) {
    logArray(TEST_A, "A");
    logArray(TEST_B, "B");
    merge(TEST_A, TEST_B, TEST_C);
  }

  private static void merge(int[] first, int[] second, int[] result) {
    int iFirst = 0;
    int iSecond = 0;
    int iResult = 0;
    while (iFirst < first.length && iSecond < second.length)
      if (first[iFirst] < second[iSecond]) result[iResult++] = first[iFirst++];
      else result[iResult++] = second[iSecond++];
    while (iFirst < first.length) result[iResult++] = first[iFirst++];
    while (iSecond < second.length) result[iResult++] = second[iSecond++];
  }

  private static void logArray(int[] array, String mark) {
    log.info(String.format("%s: %s", mark, Arrays.toString(array)));
  }
}
