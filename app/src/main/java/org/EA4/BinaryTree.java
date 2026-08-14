package org.EA4;

// A:
// Der Übergabeparameter an Comparable ist T, also der Typ der übergebenen Klasse – in den meisten
// Fällen vermutlich die implementierende Klasse selbst (wie bei String). Dadurch wird mit String
// verglichen. Ohne einen Typparameter müsste man beispielsweise mit Object vergleichen; dafür wäre
// immer ein Casting nötig gewesen, das alles quasi manuell durchprüft. Man hätte keine „echte"
// Typsicherheit, da auch andere Strukturen passen könnten. Der Typ legt also fest, welche Struktur
// sich dahinter verbirgt, und es muss zwingend derselbe Typ sein – sonst würde es bereits beim
// Compilieren zu einem Fehler führen. Beim Casting würde dies dagegen erst zur Laufzeit auffallen
// und gegebenenfalls zu einer ClassCastException führen.

public class BinaryTree<T extends Comparable<T>> {

  private BinaryNode<T> root;

  public BinaryTree(T value) {
    root = new BinaryNode<T>(value);
  }

  public BinaryTree() {}

  public boolean contains(T value) {
    var binaryNode = root;
    if (root == null) {
      return false;
    }
    int comparator;
    while ((comparator = binaryNode.value.compareTo(value)) != 0) {
      if (comparator > 0) {
        if (binaryNode.leftSon == null) {
          return false;
        } else {
          binaryNode = binaryNode.leftSon;
        }
      } else if (comparator < 0) {
        if (binaryNode.rightSon == null) {
          return false;
        } else {
          binaryNode = binaryNode.rightSon;
        }
      }
    }
    return true;
  }

  public void insert(T value) {
    BinaryNode<T> binaryNode = root;
    if (root == null) {
      root = new BinaryNode<T>(value);
      return;
    }
    int comparator;
    while ((comparator = binaryNode.value.compareTo(value)) != 0) {
      if (comparator > 0) {
        if (binaryNode.leftSon == null) {
          binaryNode.leftSon = new BinaryNode<T>(value);
        } else {
          binaryNode = binaryNode.leftSon;
        }
      } else if (comparator < 0) {
        if (binaryNode.rightSon == null) {
          binaryNode.rightSon = new BinaryNode<T>(value);
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
  private void inorder(BinaryNode<T> node) {
    if (node == null) {
      return;
    }
    inorder(node.leftSon);
    System.out.println(node.value);
    inorder(node.rightSon);
  }

  private static class BinaryNode<T> {
    private BinaryNode<T> leftSon, rightSon;
    private T value;

    public BinaryNode(T value) {
      this.value = value;
    }
  }
}
