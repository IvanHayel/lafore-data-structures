package by.hayel.data.structure.tree.model;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Tree234 {
  Node234 root = new Node234();

  public int find(int key) {
    var current = root;
    int childNumber;
    while (true) {
      if ((childNumber = current.findItem(key)) != -1) return childNumber;
      else if (current.isLeaf()) return -1;
      else current = getNextChild(current, key);
    }
  }

  private Node234 getNextChild(Node234 node, int key) {
    int j;
    var numItems = node.getNumItems();
    for (j = 0; j < numItems; j++) if (key < node.getItem(j).getData()) return node.getChild(j);
    return node.getChild(j);
  }

  public void insert(int key) {
    var current = root;
    var tempItem = new DataItem(key);
    while (true) {
      if (current.isFull()) {
        split(current);
        current = current.getParent();
        current = getNextChild(current, key);
      } else if(current.isLeaf()) break;
      else current = getNextChild(current, key);
    }
    current.insertItem(tempItem);
  }

  private void split(Node234 node) {
    int itemIndex;
    Node234 parent;
    var itemC = node.removeItem();
    var itemB = node.removeItem();
    var child2 = node.disconnectChild(2);
    var child3 = node.disconnectChild(3);
    var newRight = new Node234();
    if (node == root) {
      root = new Node234();
      parent = root;
      root.connectChild(0, node);
    } else parent = node.getParent();
    itemIndex = parent.insertItem(itemB);
    var n = parent.getNumItems();
    for (var j = n - 1; j > itemIndex; j--) {
      var temp = parent.disconnectChild(j);
      parent.connectChild(j + 1, temp);
    }
    parent.connectChild(itemIndex + 1, newRight);
    newRight.insertItem(itemC);
    newRight.connectChild(0, child2);
    newRight.connectChild(1, child3);
  }

  public void logTree() {
    recursionLogTree(root, 0, 0);
  }

  private void recursionLogTree(Node234 node, int level, int childNumber) {
    log.info(String.format("Level = %d. Child number = %d. Node = %s", level, childNumber, node));
    int numItems = node.getNumItems();
    for(int j = 0; j < numItems + 1; j++) {
      var next = node.getChild(j);
      if(next != null) recursionLogTree(next, level + 1, j);
      else break;
    }
  }
}
