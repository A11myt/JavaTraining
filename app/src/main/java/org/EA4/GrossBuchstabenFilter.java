package org.EA4;

import java.io.IOException;

public class GrossBuchstabenFilter implements CharEingabeStrom {
  private CharEingabeStrom quelle;

  public GrossBuchstabenFilter(CharEingabeStrom quelle) {
    this.quelle = quelle;
  }

  @Override
  public int read() throws IOException {
    int zeichen = quelle.read();
    if (zeichen < 'a' || zeichen > 'z') return zeichen;
    return Character.toUpperCase((char) zeichen);
  }
}

