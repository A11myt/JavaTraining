package org.EA4;

import java.io.IOException;

public class UmlautSzFilter implements CharEingabeStrom {
  private CharEingabeStrom quelle;
  private int puffer = -1;

  public UmlautSzFilter(CharEingabeStrom quelle) {
    this.quelle = quelle;
  }

  @Override
  public int read() throws IOException {
    if (puffer != -1) {
      int zeichen = puffer;
      puffer = -1;
      return zeichen;
    } else {
      int zeichen = quelle.read();
      switch (zeichen) {
        case 'Ä':
          puffer = 'e';
          return 'A';
        case 'Ö':
          puffer = 'e';
          return 'O';
        case 'Ü':
          puffer = 'e';
          return 'U';
        case 'ä':
          puffer = 'e';
          return 'a';
        case 'ö':
          puffer = 'e';
          return 'o';
        case 'ü':
          puffer = 'e';
          return 'u';
        case 'ß':
          puffer = 's';
          return 's';
        default:
          return zeichen;
      }
    }
  }
}
