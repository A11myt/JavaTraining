package org.EA3;

public class ListWithInternalArray {
  public Object[] list = new Object[0];

  // Fuegt das uebergebene Element an der angegebenen Position ein.
  // Die nachfolgenden Elemente verschieben sich nach hinten.
  public void add(Object elem, int index) {
    if (list.length < index || index < 0) {
      throw new ArrayIndexOutOfBoundsException("");
    }
    Object[] newArray = new Object[list.length + 1];

    for (var i = list.length; i >= 0; i--) {
      if (i == index) {
        newArray[index] = elem;
      } else if (i >= index) {
        newArray[i] = list[i - 1];
      } else {
        newArray[i] = list[i];
      }
    }
    list = newArray;
  }

  // Liefert eine Referenz auf das Element an der angegebenen Position.
  public Object getElementAt(int index) {
    if (getSize() <= index || index < 0) {
      throw new ArrayIndexOutOfBoundsException("");
    }
    return list[index];
  }

  // Liefert eine Referenz auf das Element an der angegebenen Position und
  // entfernt es // gleichzeitig aus der Liste. Nachfolgende Elemente werden ggf.
  // nach vorne verschoben.
  public Object removeElementAt(int index) {
    if (getSize() <= index || index < 0) {
      throw new ArrayIndexOutOfBoundsException("");
    }
    Object[] newArray = new Object[list.length - 1];
    Object obj = list[index];
    for (var i = list.length - 1; i >= 0; i--) {
      if (i == index) {
        continue;
      } else if (i > index) {
        newArray[i - 1] = list[i];
      } else {
        newArray[i] = list[i];
      }
    }
    list = newArray;
    return obj;
  }

  // Liefert die Anzahl der Elemente in der Liste
  public int getSize() {
    return list.length;
  }
}
