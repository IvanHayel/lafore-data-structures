package by.hayel.data.structure.sort.model;

import java.util.StringJoiner;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class ArrayPerson {
  Person[] people;
  int size;

  public ArrayPerson(int size) {
    people = new Person[size];
    this.size = 0;
  }

  public void insert(String name, String surname, int age) {
    people[size] = new Person(name, surname, age);
    size++;
  }

  public void insertionSort() {
    for (int i = 1; i < size; i++) {
      Person temp = people[i];
      int j = i;
      while (j > 0 && people[j-1].getSurname().compareTo(temp.getSurname()) > 0) {
        people[j] = people[j-1];
        --j;
      }
      people[j] = temp;
    }
  }

  @Override
  public String toString() {
    var joiner = new StringJoiner(", ");
    for (int i = 0; i < size; i++) joiner.add(people[i].toString());
    return String.format("[%s]", joiner);
  }
}
