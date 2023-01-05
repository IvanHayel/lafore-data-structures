package by.hayel.data.structure.tree.model;

import java.util.StringJoiner;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Node234 {
  private static final int ORDER = 4;

  int size;
  Node234 parent;
  Node234[] childArray = new Node234[ORDER];
  DataItem[] itemArray = new DataItem[ORDER - 1];

  public void connectChild(int childNum, Node234 child) {
    childArray[childNum] = child;
    if (child != null) child.parent = this;
  }

  public Node234 disconnectChild(int childNum) {
    var tempNode = childArray[childNum];
    childArray[childNum] = null;
    return tempNode;
  }

  public Node234 getChild(int childNum) {
    return childArray[childNum];
  }

  public Node234 getParent() {
    return parent;
  }

  public boolean isLeaf() {
    return childArray[0] == null;
  }

  public int getNumItems() {
    return size;
  }

  public DataItem getItem(int index) {
    return itemArray[index];
  }

  public boolean isFull() {
    return size == ORDER - 1;
  }

  public int findItem(int key) {
    for (var i = 0; i < ORDER - 1; i++) {
      if (itemArray[i] == null) break;
      if (itemArray[i].getData() == key) return i;
    }
    return -1;
  }

  public int insertItem(DataItem newItem) {
    size++;
    var newKey = newItem.getData();
    for (int j = ORDER - 2; j >= 0; j--) {
      if (itemArray[j] == null) continue;
      var itemKey = itemArray[j].getData();
      if (newKey < itemKey) itemArray[j + 1] = itemArray[j];
      else {
        itemArray[j + 1] = newItem;
        return j + 1;
      }
    }
    itemArray[0] = newItem;
    return 0;
  }

  public DataItem removeItem() {
    var temp = itemArray[size - 1];
    itemArray[size - 1] = null;
    size--;
    return temp;
  }

  @Override
  public String toString() {
    var joiner = new StringJoiner(", ");
    for(var j = 0; j < size; j++) joiner.add(String.valueOf(itemArray[j].getData()));
    return String.format("Node234 [%s]", joiner);
  }
}
