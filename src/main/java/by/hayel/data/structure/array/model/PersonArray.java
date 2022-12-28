package by.hayel.data.structure.array.model;

import java.util.StringJoiner;

public class PersonArray {
  private final Person[] PEOPLE;
  private final int CAPACITY;

  private int size;

  public PersonArray(int capacity) {
    PEOPLE = new Person[capacity];
    CAPACITY = capacity;
  }

  public Person find(String surname) {
    for(int i = 0; i < size; i++)
      if(PEOPLE[i].getSurname().equals(surname))
        return PEOPLE[i];
    return null;
  }

  public void insert(String name, String surname, int age) {
    if(size == CAPACITY) throw new ArrayStoreException();
    PEOPLE[size++] = new Person(name, surname, age);
  }

  public boolean delete(String surname) {
    for(int i = 0; i < size; i++)
      if(PEOPLE[i].getSurname().equals(surname)) {
        shift(i);
        return true;
      }
    return false;
  }

  private void shift(int from) {
    for(int i = from; i < size; i++)
      PEOPLE[i] = PEOPLE[i + 1];
    PEOPLE[size--] = null;
  }

  @Override
  public String toString() {
    var joiner = new StringJoiner(" | ");
    for (int i = 0; i < size; i++)
      joiner.add(String.valueOf(PEOPLE[i]));
    return String.format("[%s]", joiner);
  }
}
