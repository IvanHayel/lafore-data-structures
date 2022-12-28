package by.hayel.data.structure.sort.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Data
public class Person {
  String name;
  String surname;
  int age;

  @Override
  public String toString() {
    return String.format("%s %s - %d", surname, name, age);
  }
}
