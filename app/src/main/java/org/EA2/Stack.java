package org.EA2;
import java.util.NoSuchElementException;

public class Stack {
  Entry top;

  class Entry {
    String entry;
    Entry next;

    public Entry(String newEntry, Entry nextEntry) {
      this.entry = newEntry;
      this.next = nextEntry;
    }
  }

  public String push(String newEntry) {
    Entry entry = new Entry(newEntry, top);
    top = entry;
    return newEntry;
  }

  public String peek() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    return top.entry;
  }

  public String pop() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    var removeEntry = top;
    top = top.next;
    return removeEntry.entry;
  }
 
  public boolean isEmpty() {
    return top == null;
  }

  public String toString(){
    String allElements = "";
    Entry currentElement = top;

    while(currentElement != null){
      if(allElements.isEmpty()){
      allElements = currentElement.entry;
      }else{
      allElements = allElements + ", " + currentElement.entry;
      }
      currentElement = currentElement.next;
    }
    return allElements;
  }
}
