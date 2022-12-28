package by.hayel.data.structure.sort;

import by.hayel.data.structure.sort.model.ArrayPerson;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonSortApplication {
  private static final int MAX_SIZE = 10;

  public static void main(String[] args) {
    ArrayPerson  arrayPerson = new ArrayPerson(MAX_SIZE);
    fill(arrayPerson);
    logArray(arrayPerson);
    arrayPerson.insertionSort();
    logArray(arrayPerson);
  }

  private static void fill(ArrayPerson array) {
    array.insert("Patty", "Evans", 34);
    array.insert("Lorraine", "Smith", 37);
    array.insert("Tom", "Yee", 43);
    array.insert("Henry", "Adams", 63);
    array.insert("Sato", "Hashimoto", 21);
    array.insert("Henry", "Stimson", 29);
    array.insert("Jose", "Velasquez", 72);
    array.insert("Henry", "Lamarque", 54);
    array.insert("Minh", "Vang", 22);
    array.insert("Lucinda", "Creswell", 18);
  }

  private static void logArray(ArrayPerson array) {
    log.info(array.toString());
  }
}
