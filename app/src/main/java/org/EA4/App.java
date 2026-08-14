package org.EA4;


public class App {
  public static void main(String[] args) {
    BinaryTree<String> test = new BinaryTree<String>("test");
    test.contains("test");
    test.insert("asd1`123");
    test.insert("test");

    test.insert("ast");
    test.insert("t2131sat");
    test.insert("test1231");
    test.insert("te211st");
    test.insert("asdf");
    test.inorder();
  }
}
