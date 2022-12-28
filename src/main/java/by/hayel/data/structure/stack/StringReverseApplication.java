package by.hayel.data.structure.stack;

import by.hayel.data.structure.stack.model.task.StringReverser;
import java.util.Scanner;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringReverseApplication {
  private static final Scanner SCANNER = new Scanner(System.in);

  @SneakyThrows
  public static void main(String[] args) {
    System.out.print("Enter a string ->\t");
    var input = SCANNER.nextLine();
    var reverser = new StringReverser(input);
    log.info("Reversed string -> {}", reverser.doReverse());
    SCANNER.close();
  }
}
