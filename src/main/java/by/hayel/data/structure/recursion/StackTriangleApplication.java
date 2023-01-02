package by.hayel.data.structure.recursion;

import by.hayel.data.structure.recursion.model.Parameters;
import by.hayel.data.structure.recursion.model.Stack;
import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StackTriangleApplication {
  private static final Scanner SCANNER = new Scanner(System.in);
  private static final int STACK_CAPACITY = 10000;

  static int number;
  static int answer;
  static Stack stack;
  static int code;
  static Parameters parameters;

  public static void main(String[] args) {
    number = handleNumberInput();
    recursionTriangle();
    logAnswer();
  }

  private static int handleNumberInput() {
    System.out.print("Enter a number -> ");
    try {
      return Integer.parseInt(SCANNER.nextLine());
    } catch (Exception exception) {
      return handleNumberInput();
    }
  }

  private static void recursionTriangle() {
    stack = new Stack(STACK_CAPACITY);
    code = 1;
    while (step() == false)
      ;
  }

  private static boolean step() {
    switch (code) {
      case 1 -> {
        parameters = new Parameters(number, 6);
        stack.push(parameters);
        code = 2;
      }
      case 2 -> {
        parameters = stack.peek();
        if (parameters.getN() == 1) {
          answer = 1;
          code = 5;
        } else code = 3;
      }
      case 3 -> {
        var newParameters = new Parameters(parameters.getN() - 1, 4);
        stack.push(newParameters);
        code = 2;
      }
      case 4 -> {
        parameters = stack.peek();
        answer += parameters.getN();
        code = 5;
      }
      case 5 -> {
        parameters = stack.peek();
        code = parameters.getAddress();
        stack.pop();
      }
      case 6 -> {
        return true;
      }
      default -> {
        return false;
      }
    }
    return false;
  }

  private static void logAnswer() {
    log.info(String.format("Triangle: %d", answer));
  }
}
