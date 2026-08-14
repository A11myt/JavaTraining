package org.EA3;

public class Stapel {
  private ListWithInternalArray stack = new ListWithInternalArray();

  // legt ein Element auf den Stapel
  public void push(Object element) {
    stack.add(element, 0);
  }

  // liefert eine Referenz auf das oberste Element des Stapels.
  public Object peek() {
    return stack.getElementAt(0);
  }

  // liefert eine Referenz auf das oberste Element des Stapel.
  // Glecihzeitig wird das Element vom Stapel entfernt
  public Object pop() {
    var removedObj = stack.removeElementAt(0);
    return removedObj;
  }

  // gibt an, ob der Stapel leer ist
  public boolean isEmpty() {
    return stack.getSize() == 0;
  }
}
