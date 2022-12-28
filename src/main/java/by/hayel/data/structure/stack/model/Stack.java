package by.hayel.data.structure.stack.model;

import java.util.StringJoiner;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Stack {
  private static final String STACK_FULL_MESSAGE = "Stack is full!";
  private static final String STACK_EMPTY_MESSAGE = "Stack is empty!";

  final int[] stack;
  final int size;
  int top;

  public Stack(int size) {
    this.size = size;
    stack = new int[size];
    top = -1;
  }

  public void push(int value) {
    if (isFull()) throw new IllegalStateException(STACK_FULL_MESSAGE);
    stack[++top] = value;
  }

  public int pop() {
    if (isEmpty()) throw new IllegalStateException(STACK_EMPTY_MESSAGE);
    return stack[top--];
  }

  public int peek() {
    if (isEmpty()) throw new IllegalStateException(STACK_EMPTY_MESSAGE);
    return stack[top];
  }

  public boolean isEmpty() {
    return top == -1;
  }

  public boolean isFull() {
    return top == size - 1;
  }

  @Override
  public String toString() {
    var joiner = new StringJoiner(", ");
    for (int i = 0; i <= top; i++) joiner.add(String.valueOf(stack[i]));
    return String.format("Stack [top=%d, stack={%s}]", top, joiner);
  }
}
