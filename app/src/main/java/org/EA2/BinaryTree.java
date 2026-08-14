package org.EA2;

public class BinaryTree {
  private BinaryNode root; // root node

  public BinaryTree(int value) {
    root = new BinaryNode(value);
  }

  public BinaryTree() {}

  public boolean contains(int value) {

    BinaryNode binaryNode = root;
    if (root == null) {
      return false;
    }
    while (binaryNode.value != value) {
      if (binaryNode.value > value) {
        if (binaryNode.leftSon == null) {
          return false;
        } else {
          binaryNode = binaryNode.leftSon;
        }
      } else if (binaryNode.value < value) {
        if (binaryNode.rightSon == null) {
          return false;
        } else {
          binaryNode = binaryNode.rightSon;
        }
      }
    }
    return true;
  }

  public void insert(int value) {
    BinaryNode binaryNode = root;
    if (root == null) {
      root = new BinaryNode(value);
      return;
    }

    while (binaryNode.value != value) {
      if (binaryNode.value > value) {
        if (binaryNode.leftSon == null) {
          binaryNode.leftSon = new BinaryNode(value);
        } else {
          binaryNode = binaryNode.leftSon;
        }
      } else if (binaryNode.value < value) {
        if (binaryNode.rightSon == null) {
          binaryNode.rightSon = new BinaryNode(value);
        } else {
          binaryNode = binaryNode.rightSon;
        }
      }
    }
  }

  public void inorder() {
    inorder(root);
  }

  // Gibt die Werte in aufsteigender Reihenfolge aus (links < Knoten < rechts).
  private void inorder(BinaryNode node) {
    if (node == null) {
      return;
    }
    inorder(node.leftSon);
    System.out.println(node.value);
    inorder(node.rightSon);
  }

  private static class BinaryNode {
    private BinaryNode leftSon, rightSon;
    private int value;

    public BinaryNode(int value) {
      this.value = value;
    }
  }
}
