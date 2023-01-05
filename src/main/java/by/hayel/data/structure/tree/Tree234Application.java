package by.hayel.data.structure.tree;

import by.hayel.data.structure.tree.model.Tree234;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Tree234Application {
  public static void main(String[] args) {
    var tree = new Tree234();
    fill(tree);
    tree.logTree();
    tryToFind(tree, 50);
    tryToFind(tree, 25);
  }

  private static void fill(Tree234 tree) {
    tree.insert(50);
    tree.insert(40);
    tree.insert(60);
    tree.insert(30);
    tree.insert(70);
  }

  private static void tryToFind(Tree234 tree, int key) {
    var found = tree.find(key);
    if(found != -1) log.info("Found {}", found);
    else log.info("Not found {}", key);
  }
}
