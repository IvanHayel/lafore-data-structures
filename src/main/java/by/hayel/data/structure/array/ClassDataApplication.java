package by.hayel.data.structure.array;

import by.hayel.data.structure.array.model.PersonArray;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClassDataApplication {
  private static final PersonArray PERSON_ARRAY;
  private static final int INITIAL_CAPACITY = 100;
  private static final String CORRECT_SURNAME = "Sidorov";
  private static final String INVALID_SURNAME = "Parrot";

  static {
    PERSON_ARRAY = new PersonArray(INITIAL_CAPACITY);
    PERSON_ARRAY.insert("Ivan", "Ivanov", 25);
    PERSON_ARRAY.insert("Petr", "Petrov", 30);
    PERSON_ARRAY.insert("Sidor", "Sidorov", 35);
    PERSON_ARRAY.insert("Oleg", "Olegov", 40);
  }

  public static void main(String[] args){
    logArray(PERSON_ARRAY);
    search(PERSON_ARRAY, CORRECT_SURNAME);
    search(PERSON_ARRAY, INVALID_SURNAME);
    delete(PERSON_ARRAY, CORRECT_SURNAME);
    logArray(PERSON_ARRAY);
    delete(PERSON_ARRAY, INVALID_SURNAME);
    logArray(PERSON_ARRAY);
  }

  private static void logArray(PersonArray array) {
    log.info(array.toString());
  }

  private static void search(PersonArray array, String surname) {
    if(array.find(surname) != null) log.info("Person with surname {} found", surname);
    else log.info("Person with surname {} not found", surname);
  }

  private static void delete(PersonArray array, String surname) {
    if(array.delete(surname)) log.info("Person with surname {} deleted", surname);
    else log.info("Person with surname {} not found", surname);
  }
}
