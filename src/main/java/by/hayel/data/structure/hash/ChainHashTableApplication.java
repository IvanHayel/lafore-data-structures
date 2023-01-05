package by.hayel.data.structure.hash;

import by.hayel.data.structure.hash.model.ChainHashTable;
import by.hayel.data.structure.hash.model.Link;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChainHashTableApplication {
  private static final Random GENERATOR = new Random();
  private static final int GENERATION_BOUND = 10;

  private static final int TABLE_SIZE = 5;
  private static final int FILL_SIZE = Math.min(TABLE_SIZE, 4);

  public static void main(String[] args) {
    var hashTable = new ChainHashTable(TABLE_SIZE);
    fill(hashTable);
    hashTable.logTable();
    tryToFind(hashTable, GENERATOR.nextInt(GENERATION_BOUND));
    tryToFind(hashTable, GENERATOR.nextInt(GENERATION_BOUND));
    tryToFind(hashTable, GENERATOR.nextInt(GENERATION_BOUND));
    tryToFind(hashTable, GENERATOR.nextInt(GENERATION_BOUND));
    hashTable.delete(122);
    hashTable.logTable();
  }

  private static void fill(ChainHashTable hashTable) {
    var counter = FILL_SIZE;
    while(counter-- > 0) {
      var data = new Link(GENERATOR.nextInt(GENERATION_BOUND));
      hashTable.insert(data);
    }
    hashTable.insert(new Link(122));
  }

  private static void tryToFind(ChainHashTable hashTable, int key) {
    var found = hashTable.find(key);
    if(found != null) log.info("Found: {}", found);
    else log.info("Data with key {} not found!", key);
  }
}
