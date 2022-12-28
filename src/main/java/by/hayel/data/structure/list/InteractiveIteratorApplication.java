package by.hayel.data.structure.list;

import by.hayel.data.structure.list.model.IteratorLinkedList;
import by.hayel.data.structure.list.model.ListIterator;
import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InteractiveIteratorApplication {
  private static final String LIST_EMPTY_MESSAGE = "List is empty!";

  private static final Scanner SCANNER = new Scanner(System.in);

  public static void main(String[] args) {
    var list = new IteratorLinkedList();
    var iterator = list.getIterator();
    fill(iterator);
    startMenu(list, iterator);
  }

  private static void fill(ListIterator iterator) {
    iterator.insertAfter(20);
    iterator.insertAfter(40);
    iterator.insertAfter(80);
    iterator.insertAfter(60);
  }

  private static void startMenu(IteratorLinkedList list, ListIterator iterator) {
    displayMenuActions();
    var input = handleAction();
    switch (input) {
      case "s" -> showList(list);
      case "r" -> iterator.reset();
      case "n" -> next(list, iterator);
      case "g" -> getCurrent(list, iterator);
      case "b" -> insertBefore(iterator);
      case "a" -> insertAfter(iterator);
      case "d" -> deleteCurrent(list, iterator);
      case "e" -> exit();
      default -> log.warn("Invalid entry!");
    }
    startMenu(list, iterator);
  }

  private static void showList(IteratorLinkedList list) {
    if (!list.isEmpty()) list.logList();
    else log.warn(LIST_EMPTY_MESSAGE);
  }

  private static void next(IteratorLinkedList list, ListIterator iterator) {
    if (!list.isEmpty() && iterator.hasNext()) iterator.next();
    else log.warn("Can't go to next link!");
  }

  private static void getCurrent(IteratorLinkedList list, ListIterator iterator) {
    if (!list.isEmpty()) log.info(String.format("Current: %s", iterator.getCurrent()));
    else log.warn(LIST_EMPTY_MESSAGE);
  }

  private static void insertBefore(ListIterator iterator) {
    var value = handleValue();
    iterator.insertBefore(value);
  }

  private static void insertAfter(ListIterator iterator) {
    var value = handleValue();
    iterator.insertAfter(value);
  }

  private static void deleteCurrent(IteratorLinkedList list, ListIterator iterator) {
    if (!list.isEmpty()) log.info(String.format("Deleted: %s", iterator.deleteCurrent()));
    else log.warn(LIST_EMPTY_MESSAGE);
  }

  private static void exit() {
    SCANNER.close();
    System.exit(0);
  }

  private static String handleAction() {
    System.out.print("\nEnter action ->\t");
    return SCANNER.nextLine().strip();
  }

  private static int handleValue() {
    System.out.print("\nEnter value to insert ->\t");
    String input = "";
    try {
      input = SCANNER.nextLine().strip();
      return Integer.parseInt(input);
    } catch (Exception exception) {
      log.error(String.format("Wrong value %s!", input));
      return handleValue();
    }
  }

  private static void displayMenuActions() {
    System.out.println("-".repeat(38));
    System.out.println("s. Show list");
    System.out.println("r. Reset");
    System.out.println("n. Next");
    System.out.println("g. Get current");
    System.out.println("b. Insert before");
    System.out.println("a. Insert after");
    System.out.println("d. Delete");
    System.out.println("e. Exit");
    System.out.println("-".repeat(38));
  }
}
