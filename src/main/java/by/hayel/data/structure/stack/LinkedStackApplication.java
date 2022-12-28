package by.hayel.data.structure.stack;

import by.hayel.data.structure.stack.model.LinkedStack;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LinkedStackApplication {
  public static void main(String[] args) {
    var stack = new LinkedStack();
    fill(stack);
    stack.logStack();
    extract(stack, 2);
    stack.logStack();
  }

  private static void extract(LinkedStack stack, int count) {
    var counter = 0;
    while (!stack.isEmpty() && count-- > 0) {
      var extracted = stack.pop();
      log.info(String.format("%d. Extracted: %s", ++counter, extracted));
    }
  }

  private static void fill(LinkedStack stack) {
    stack.push(20);
    stack.push(40);
    stack.push(60);
    stack.push(80);
  }
}
