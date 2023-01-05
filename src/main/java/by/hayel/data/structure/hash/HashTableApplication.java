package by.hayel.data.structure.hash;

import by.hayel.data.structure.hash.model.DataItem;
import by.hayel.data.structure.hash.model.HashTable;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HashTableApplication {
  private static final Random GENERATOR = new Random();
  private static final int GENERATION_BOUND = 500;

  private static final int TABLE_SIZE = 100;
  private static final int FILL_SIZE = Math.min(TABLE_SIZE, 30);

  public static void main(String[] args) {
    var hashTable = new HashTable(TABLE_SIZE);
    fill(hashTable);
    hashTable.logTable();
    tryToFind(hashTable, GENERATOR.nextInt(GENERATION_BOUND));
    tryToFind(hashTable, GENERATOR.nextInt(GENERATION_BOUND));
    tryToFind(hashTable, GENERATOR.nextInt(GENERATION_BOUND));
    tryToFind(hashTable, GENERATOR.nextInt(GENERATION_BOUND));
    tryToDelete(hashTable, GENERATOR.nextInt(GENERATION_BOUND));
    tryToDelete(hashTable, GENERATOR.nextInt(GENERATION_BOUND));
    tryToDelete(hashTable, GENERATOR.nextInt(GENERATION_BOUND));
    tryToDelete(hashTable, GENERATOR.nextInt(GENERATION_BOUND));
    hashTable.logTable();
  }

  private static void fill(HashTable hashTable) {
    var counter = FILL_SIZE;
    while(counter-- > 0) {
      var data = new DataItem(GENERATOR.nextInt(GENERATION_BOUND));
      hashTable.insert(data);
    }
  }

  private static void tryToFind(HashTable hashTable, int key) {
    var found = hashTable.find(key);
    if(found != null) log.info("Found: {}", found);
    else log.info("Data with key {} not found!", key);
  }

  private static void tryToDelete(HashTable hashTable, int key) {
    var deleted = hashTable.delete(key);
    if(deleted != null) log.info("Deleted: {}", key);
    else log.info("Data with key {} not found!", key);
  }
}
