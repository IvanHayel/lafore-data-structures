package by.hayel.data.structure.stack.model.task;

import by.hayel.data.structure.stack.model.Stack;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class StringReverser {
  private static final String EMPTY = "";

  String input;
  String output;

  public StringReverser(String input) {
    this.input = input;
    output = EMPTY;
  }

  public String doReverse() {
    int stackSize = input.length();
    var stack = new Stack(stackSize);
    for(int i = 0; i < stackSize; i++) {
      char ch = input.charAt(i);
      stack.push(ch);
    }
    var builder = new StringBuilder();
    while(!stack.isEmpty()) {
      builder.append((char) stack.pop());
    }
    output = builder.toString();
    return output;
  }
}
