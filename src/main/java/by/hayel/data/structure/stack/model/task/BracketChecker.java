package by.hayel.data.structure.stack.model.task;

import by.hayel.data.structure.stack.model.Stack;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class BracketChecker {
  private static final char BRACKET_OPEN_1 = '{';
  private static final char BRACKET_OPEN_2 = '[';
  private static final char BRACKET_OPEN_3 = '(';
  private static final char BRACKET_CLOSE_1 = '}';
  private static final char BRACKET_CLOSE_2 = ']';
  private static final char BRACKET_CLOSE_3 = ')';

  String input;

  public BracketChecker(String input) {
    this.input = input;
  }

  public boolean check() {
    var stackSize = input.length();
    var stack = new Stack(stackSize);
    for (int i = 0; i < stackSize; i++) {
      if (isInvalid(stack, i)) return false;
    }
    var isInvalidState = !stack.isEmpty();
    if (isInvalidState)
      log.error("Some brackets don't have a pair!");
    return !isInvalidState;
  }

  private boolean isInvalid(Stack stack, int i) {
    var symbol = input.charAt(i);
    switch (symbol) {
      case BRACKET_OPEN_1, BRACKET_OPEN_2, BRACKET_OPEN_3 -> stack.push(symbol);
      case BRACKET_CLOSE_1, BRACKET_CLOSE_2, BRACKET_CLOSE_3 -> {
        if (!stack.isEmpty()) {
          var bracket = (char) stack.pop();
          if (isIncorrectBracketPair(symbol, bracket)) {
            log.error("Incorrect bracket pair:  {} at {}", symbol, i);
            return true;
          }
        } else {
          log.error("Brackets don't have a pair: {} at {}", symbol, i);
          return true;
        }
      }
    }
    return false;
  }

  private static boolean isIncorrectBracketPair(char symbol, char bracket) {
    return (bracket == BRACKET_OPEN_1 && symbol != BRACKET_CLOSE_1)
        || (bracket == BRACKET_OPEN_2 && symbol != BRACKET_CLOSE_2)
        || (bracket == BRACKET_OPEN_3 && symbol != BRACKET_CLOSE_3);
  }
}
