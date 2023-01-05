package by.hayel.data.structure.hash.model;

import java.util.StringJoiner;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HashTable {
  private static final String TABLE_HEADER =
      "---------------------------TABLE---------------------------";
  private static final String TABLE_FOOTER =
    "-----------------------------------------------------------";

  private static final DataItem NON_ITEM = new DataItem(-1);

  DataItem[] hashArray;
  int size;

  public HashTable(int size) {
    this.size = size;
    hashArray = new DataItem[size];
  }

  public void logTable() {
    var joiner = new StringJoiner(" ");
    var save = 0;
    for (DataItem item : hashArray) {
      if (item != null) joiner.add(String.valueOf(item.getKey()));
      else joiner.add("**");
      if (joiner.length() - save >= 59) {
        joiner.add(System.lineSeparator());
        save = joiner.length();
      }
    }
    log.info(String.format("%n%s%n%s%n%s", TABLE_HEADER, joiner, TABLE_FOOTER));
  }

  public void insert(DataItem item) {
    var key = item.getKey();
    int hashValue = hashFunction(key);
    while (hashArray[hashValue] != null && hashArray[hashValue].getKey() != -1) {
      ++hashValue;
      hashValue %= size;
    }
    hashArray[hashValue] = item;
  }

  private int hashFunction(int key) {
    return key % size;
  }

  public DataItem delete(int key) {
    int hashValue = hashFunction(key);
    while (hashArray[hashValue] != null) {
      if (hashArray[hashValue].getKey() == key) {
        var item = hashArray[hashValue];
        hashArray[hashValue] = NON_ITEM;
        return item;
      }
      ++hashValue;
      hashValue %= size;
    }
    return null;
  }

  public DataItem find(int key) {
    int hashValue = hashFunction(key);
    while (hashArray[hashValue] != null) {
      if (hashArray[hashValue].getKey() == key) return hashArray[hashValue];
      ++hashValue;
      hashValue %= size;
    }
    return null;
  }
}
