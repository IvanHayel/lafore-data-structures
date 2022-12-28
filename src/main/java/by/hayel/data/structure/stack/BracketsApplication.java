package by.hayel.data.structure.stack;

import by.hayel.data.structure.stack.model.task.BracketChecker;
import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BracketsApplication {
  private static final Scanner SCANNER = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.print("Enter a string ->\t");
    var input = SCANNER.nextLine();
    var checker = new BracketChecker(input);
    if (checker.check()) log.info("Correct bracket pairs!");
    else log.warn("Invalid bracket pairs!");
    SCANNER.close();
  }
}
