package by.hayel.data.structure.recursion.model;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Stack {
  Parameters[] stack;
  int top;

  public Stack(int max) {
    stack = new Parameters[max];
    top = -1;
  }

  public void push(Parameters parameters) {
    stack[++top] = parameters;
  }

  public Parameters pop() {
    return stack[top--];
  }

  public Parameters peek() {
    return stack[top];
  }
}
