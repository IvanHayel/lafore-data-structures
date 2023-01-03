package by.hayel.data.structure.sort;

import by.hayel.data.structure.sort.model.ArrayPartition;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PartitionApplication {
  private static final int CAPACITY = 10;
  private static final int PIVOT = 99;

  public static void main(String[] args) {
    var array = new ArrayPartition(CAPACITY);
    array.fillRandom();
    array.log();
    log.info("Pivot is {}", PIVOT);
    var size = array.size();
    var partitionIndex = array.partitionIt(0, size - 1, PIVOT);
    log.info("Partition index is {}", partitionIndex);
    array.log();
  }
}
