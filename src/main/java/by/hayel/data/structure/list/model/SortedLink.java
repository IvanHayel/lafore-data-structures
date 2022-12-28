package by.hayel.data.structure.list.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SortedLink {
  int data;
  SortedLink next;

  public SortedLink(int data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return String.format("SortedLink {%d}", data);
  }
}
