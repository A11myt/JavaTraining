package org.EA4;

import java.io.IOException;
import java.io.InputStreamReader;

public class Adapter implements CharEingabeStrom {
  InputStreamReader text;

  public Adapter(InputStreamReader str) {
    this.text = str;
  }

  public int read() throws IOException {
  return text.read();
  }
}
