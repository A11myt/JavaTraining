package org.EA2;

public class StackTest {
  public static void main(String[] args) {
    Stack stack = new Stack();

    System.out.println("isEmpty (erwartet true): " + stack.isEmpty());

    stack.push("Erster");
    stack.push("Zweiter");
    stack.push("Dritter");
    System.out.println("Stapel nach 3x push: " + stack);

    System.out.println("peek (erwartet Dritter): " + stack.peek());
    System.out.println("Stapel nach peek, unveraendert: " + stack);

    System.out.println("pop (erwartet Dritter): " + stack.pop());
    System.out.println("pop (erwartet Zweiter): " + stack.pop());
    System.out.println("Stapel nach 2x pop: " + stack);

    System.out.println("pop (erwartet Erster): " + stack.pop());
    System.out.println("isEmpty (erwartet true): " + stack.isEmpty());

    // Fehlerfall: peek/pop auf leerem Stapel sollen NoSuchElementException auslösen.
    // main deklariert bewusst kein try/catch, damit der Stacktrace die Exception zeigt.
    stack.peek();
  }
}
