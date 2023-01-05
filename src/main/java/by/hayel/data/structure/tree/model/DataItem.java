package by.hayel.data.structure.tree.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DataItem {
  int data;

  @Override
  public String toString() {
    return String.format("DataItem {%d}", data);
  }
}
