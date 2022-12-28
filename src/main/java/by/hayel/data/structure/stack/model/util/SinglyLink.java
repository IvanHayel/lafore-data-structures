package by.hayel.data.structure.stack.model.util;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class SinglyLink {
  int data;
  SinglyLink next;

  public SinglyLink(int data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return String.format("SinglyLink {%d}", data);
  }
}
