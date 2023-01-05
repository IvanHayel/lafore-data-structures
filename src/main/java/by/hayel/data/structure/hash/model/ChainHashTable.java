package by.hayel.data.structure.hash.model;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChainHashTable {
  SortedList[] hashArray;
  int size;

  public ChainHashTable(int size) {
    this.size = size;
    hashArray = new SortedList[size];
    for (int i = 0; i < size; i++) hashArray[i] = new SortedList();
  }

  public void logTable() {
    for (int i = 0; i < size; i++) {
      log.info("{}. {}", i, hashArray[i]);
    }
  }

  private int hashFunction(int key) {
    return key % size;
  }

  public void insert(Link link) {
    int key = link.getKey();
    var hashValue = hashFunction(key);
    hashArray[hashValue].insert(link);
  }

  public void delete(int key) {
    int hashValue = hashFunction(key);
    hashArray[hashValue].delete(key);
  }

  public Link find(int key) {
    int hashValue = hashFunction(key);
    return hashArray[hashValue].find(key);
  }
}
