package by.hayel.data.structure.tree.model;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BinaryTree {
  BinaryNode root;

  public BinaryNode find(int key) {
    var current = root;
    while (current.getKey() != key) {
      if (key < current.getKey()) current = current.getLeft();
      else current = current.getRight();
      if (current == null) return null;
    }
    return current;
  }

  public void insert(int key) {
    var node = new BinaryNode(key);
    if (root == null) root = node;
    else {
      var current = root;
      BinaryNode parent;
      while (true) {
        parent = current;
        if (key < current.getKey()) {
          current = current.getLeft();
          if (current == null) {
            parent.setLeft(node);
            return;
          }
        } else {
          current = current.getRight();
          if (current == null) {
            parent.setRight(node);
            return;
          }
        }
      }
    }
  }

  public boolean delete(int key) {
    var current = root;
    var parent = root;
    boolean isLeftChild = true;
    while (current.getKey() != key) {
      parent = current;
      if (key < current.getKey()) {
        isLeftChild = true;
        current = current.getLeft();
      } else {
        isLeftChild = false;
        current = current.getRight();
      }
      if (current == null) return false;
    }
    if (current.getLeft() == null && current.getRight() == null) {
      if (current == root) root = null;
      else if (isLeftChild) parent.setLeft(null);
      else parent.setRight(null);
    } else if(current.getRight()==null) {
      if (current == root) root = current.getLeft();
      else if (isLeftChild) parent.setLeft(current.getLeft());
      else parent.setRight(current.getLeft());
    } else if (current.getLeft()==null) {
      if (current == root) root = current.getRight();
      else if (isLeftChild) parent.setLeft(current.getRight());
      else parent.setRight(current.getRight());
    } else {
      var successor = getSuccessor(current);
      if (current == root) root = successor;
      else if (isLeftChild) parent.setLeft(successor);
      else parent.setRight(successor);
      successor.setLeft(current.getLeft());
    }
    return true;
  }

  private BinaryNode getSuccessor(BinaryNode delNode) {
    var successorParent = delNode;
    var successor = delNode;
    var current = delNode.getRight();
    while (current != null) {
      successorParent = successor;
      successor = current;
      current = current.getLeft();
    }
    if (successor != delNode.getRight()) {
      successorParent.setLeft(successor.getRight());
      successor.setRight(delNode.getRight());
    }
    return successor;
  }

  public BinaryNode min() {
    var current = root;
    while (current.getLeft() != null) current = current.getLeft();
    return current;
  }

  public BinaryNode max() {
    var current = root;
    while (current.getRight() != null) current = current.getRight();
    return current;
  }

  public void logInOrder() {
    inOrder(root);
  }

  private void inOrder(BinaryNode localRoot) {
    if (localRoot != null) {
      inOrder(localRoot.getLeft());
      log.info(localRoot.toString());
      inOrder(localRoot.getRight());
    }
  }
}
