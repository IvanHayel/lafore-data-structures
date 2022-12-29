package by.hayel.data.structure.recursion;

import java.util.function.IntUnaryOperator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TriangleNumbersApplication {
  private static final int TEST_NUMBER = 1000;
  private static final int EXPECTED_RESULT = TEST_NUMBER * (TEST_NUMBER + 1) / 2;

  public static void main(String[] args) {
    logResult(TriangleNumbersApplication::triangle, "triangle");
    logResult(TriangleNumbersApplication::cycledTriangle, "cycled triangle");
  }

  private static int triangle(int n) {
    if (n == 1) return 1;
    return n + triangle(n - 1);
  }

  private static int cycledTriangle(int n) {
    var result = 0;
    while(n > 0) {
      result += n;
      n--;
    }
    return result;
  }

  private static void logResult(IntUnaryOperator operator, String functionName) {
    var result = operator.applyAsInt(TEST_NUMBER);
    if (result == EXPECTED_RESULT) log.info(String.format("Success: %s function works fine!", functionName));
    else log.error(String.format("Error: %s function doesn't work!", functionName));
    log.info(
      String.format(
        "Test input: %d. Expected: %d. Result: %d.", TEST_NUMBER, EXPECTED_RESULT, result));
  }
}
