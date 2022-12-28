package by.hayel.data.structure.list.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class DoublyLink {
  int data;
  DoublyLink next;
  DoublyLink previous;

  public DoublyLink(int data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return String.format("DoublyLink {%d}", data);
  }
}
