package org.EA4;

import java.io.IOException;

public class Rot13Filter implements CharEingabeStrom {

  private CharEingabeStrom quelle;

  public Rot13Filter(CharEingabeStrom quelle) {
    this.quelle = quelle;
  }

  @Override
  public int read() throws IOException {

    int zeichen = quelle.read();
    // Diese Bedingung ist true, wenn zeichen außerhalb des Bereichs A–Z liegt
    // (kleiner als A oder größer als Z). Nur in diesem Fall (Bedingung true) wird
    // der return ausgeführt und die Methode sofort verlassen.
    // Alphabet length: A = 0, Z = 25
    // ASCII Value 65 - 90
    if (zeichen < 'A' || zeichen > 'Z') return zeichen;
    // Implizite Typkonvertierung char → int
    // "byte → short → int → long → float → double und char → int"
    int pos = (int) zeichen - (int) 'A';
    int newPos = ((pos + 13) % 26) + 'A';
    char result = (char) newPos;
    return result;
  }
}
