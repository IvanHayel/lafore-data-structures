package by.hayel.data.structure.recursion;

import java.util.function.IntUnaryOperator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FactorialApplication {
  private static final int TEST_NUMBER = 10;
  private static final int EXPECTED_RESULT = 3628800;

  public static void main(String[] args) {
    logResult(FactorialApplication::factorial, "factorial");
    logResult(FactorialApplication::cycledFactorial, "cycled factorial");
  }

  private static int factorial(int n) {
    if(n <= 1) return 1;
    return n * factorial(n - 1);
  }

  private static int cycledFactorial(int n) {
    int result = 1;
    for(int i = 1; i <= n; i++) {
      result *= i;
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
