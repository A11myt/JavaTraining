package org.EA4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Rot13FileTest {
  public static void main(String[] args) {
    // Verwendung des Try-with-Ressources-Statements (nur als weiteres Beispiel;
    // // für die Lösung der Aufgabe ist der Unterschied nicht relevant)
    try (OutputStreamWriter osw =
            new OutputStreamWriter(new FileOutputStream("testout.txt"), "UTF-8");
        InputStreamReader isr = new InputStreamReader(new FileInputStream("testin.txt"), "UTF-8")) {
      Adapter adapter = new Adapter(isr);
      CharEingabeStrom cs = new UmlautSzFilter(adapter);
      cs = new GrossBuchstabenFilter(cs);
      cs = new Rot13Filter(cs);
      int zeichen = -1;
      while ((zeichen = cs.read()) != -1) {
        osw.write(zeichen);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
