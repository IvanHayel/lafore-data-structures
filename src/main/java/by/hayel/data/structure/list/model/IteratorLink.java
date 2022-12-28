package by.hayel.data.structure.list.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class IteratorLink {
  int data;
  IteratorLink next;

  public IteratorLink(int data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return String.format("IteratorLink {%d}", data);
  }
}
