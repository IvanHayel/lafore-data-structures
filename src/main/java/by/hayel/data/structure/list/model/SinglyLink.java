package by.hayel.data.structure.list.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SinglyLink {
  int integerData;
  double doubleData;
  SinglyLink next;

  public SinglyLink(int integerData, double doubleData) {
    this.integerData = integerData;
    this.doubleData = doubleData;
  }

  @Override
  public String toString() {
    return String.format("SinglyLink {%d, %.2f}", integerData, doubleData);
  }
}
