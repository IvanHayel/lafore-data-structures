package by.hayel.data.structure.recursion;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HanoiTowerApplication {
  private static final String TOWER_FROM = "A";
  private static final String TOWER_INTERMEDIATE = "B";
  private static final String TOWER_TO = "C";

  private static final int NUMBER_OF_DISKS = 3;

  public static void main(String[] args) {
    resolveTowers(NUMBER_OF_DISKS, TOWER_FROM, TOWER_INTERMEDIATE, TOWER_TO);
  }

  private static void resolveTowers(int top, String from, String intermediate, String to) {
    if (top == 1) log.info("Move disk 1 from {} to {}", from, to);
    else {
      resolveTowers(top - 1, from, to, intermediate);
      log.info("Move disk {} from {} to {}", top, from, to);
      resolveTowers(top - 1, intermediate, from, to);
    }
  }
}
