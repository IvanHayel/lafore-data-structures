package by.hayel.data.structure.tree;

import by.hayel.data.structure.tree.model.BinaryTree;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BinaryTreeApplication {
  public static void main(String[] args) {
    var tree = new BinaryTree();
    fill(tree);
    tryToFind(tree, 2);
    tree.logInOrder();
    findExtrema(tree);
    tryToDelete(tree, 333);
    tryToDelete(tree, 222);
    tree.logInOrder();
  }

  private static void fill(BinaryTree tree) {
    tree.insert(333);
    tree.insert(44);
    tree.insert(5555);
    tree.insert(11);
    tree.insert(2);
  }

  private static void tryToFind(BinaryTree tree, int key) {
    var node = tree.find(key);
    if(node != null) log.info("Found: {}", node);
    else log.info(String.format("Node with key %d not found!", key));
  }

  private static void findExtrema(BinaryTree tree) {
    log.info("Maximum:  {}", tree.max());
    log.info("Minimum:  {}", tree.min());
  }

  private static void tryToDelete(BinaryTree tree, int key) {
    if(tree.delete(key)) log.info("Deleted: {}", key);
    else log.info(String.format("Node with key %d not found!", key));
  }
}
