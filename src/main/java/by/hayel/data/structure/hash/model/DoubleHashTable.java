package by.hayel.data.structure.hash.model;

import java.util.StringJoiner;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DoubleHashTable {
  private static final String TABLE_HEADER =
    "---------------------------TABLE---------------------------";
  private static final String TABLE_FOOTER =
    "-----------------------------------------------------------";

  private static final DataItem NON_ITEM = new DataItem(-1);

  DataItem[] hashArray;
  int size;

  public DoubleHashTable(int size) {
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

  private int firstHashFunction(int key) {
    return key % size;
  }

  private int secondHashFunction(int key) {
    return 5 - key % 5;
  }

  public void insert(DataItem item) {
    int hashValue = firstHashFunction(item.getKey());
    int step = secondHashFunction(item.getKey());
    while (hashArray[hashValue] != null && hashArray[hashValue].getKey() != -1) {
      hashValue += step;
      hashValue %= size;
    }
    hashArray[hashValue] = item;
  }

  public DataItem delete(int key) {
    int hashValue = firstHashFunction(key);
    int step = secondHashFunction(key);
    while (hashArray[hashValue] != null) {
      if (hashArray[hashValue].getKey() == key) {
        DataItem temp = hashArray[hashValue];
        hashArray[hashValue] = NON_ITEM;
        return temp;
      }
      hashValue += step;
      hashValue %= size;
    }
    return null;
  }

  public DataItem find(int key) {
    int hashValue = firstHashFunction(key);
    int step = secondHashFunction(key);
    while (hashArray[hashValue] != null) {
      if (hashArray[hashValue].getKey() == key) return hashArray[hashValue];
      hashValue += step;
      hashValue %= size;
    }
    return null;
  }
}
