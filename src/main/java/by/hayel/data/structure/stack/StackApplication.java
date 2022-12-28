package by.hayel.data.structure.stack;

import by.hayel.data.structure.stack.model.Stack;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StackApplication {
  private static final int STACK_SIZE = 10;

  public static void main(String[] args) {
    Stack stack = new Stack(STACK_SIZE);
    fill(stack);
    logStack(stack);
    extractAll(stack);
    logStack(stack);
  }

  private static void fill(Stack stack) {
    stack.push(20);
    stack.push(40);
    stack.push(60);
    stack.push(80);
  }

  private static void logStack(Stack stack) {
    log.info(stack.toString());
  }

  private static void extractAll(Stack stack) {
    var counter = 0;
    while(!stack.isEmpty()) {
      log.info(String.format("%d. Extracted: %d", ++counter, stack.pop()));
    }
  }
}
