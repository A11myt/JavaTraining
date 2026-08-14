// das package beschreibt den ablageOrt
package org.EA1;

// Die Klasse ist nach der Datei benannt

// Aufgabe B
// moeglihce fehler!
// 1. String statt Zahlen -> NumberFormatException -- fange ich nun 
// 2. Ungrade anzahl an werten -> ArrayIndexOutOfBoundsException -- fange ich nun 
// 3. Zahl auserhalb des int bereichts
// ❯ java -cp app/build/classes/java/main org.EA1.App -2147483648 0
// Das kann nicht sein! --> Buffer Overflow
public class ControlStructure {

  // In der Klasse gibt es eine Funktion main die ein String Array namens args
  // uebergeben bekommt
  public static void main(String[] args) {
    // for-Schleife iteriert in 2er-Schritten ueber args, da je zwei Werte ein
    // Zahlenpaar bilden
    for (int i = 0; i < args.length; i = i + 2) {
      // i wird zu int
      int x = 0;
      int y = 0;
      try {
        x = Integer.parseInt(args[i]);
        // parsed jeden 2ten wert in args zu int und speichert ihn in y
        y = Integer.parseInt(args[i + 1]);
      } catch (NumberFormatException e) {
        System.out.println("Ungueltige Text eingabe!" + e.getMessage());
        continue;
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Ungrade Anzahl an Werten! " + e.getMessage());
        continue;
      }
      // wenn x kleiner als 0 ist, dann multipliziere x mit -1, sonst behalte x bei
      x = x < 0 ? x * -1 : x;
      y = y < 0 ? y * -1 : y;
      // berechne die Summe von x und y und speichere sie in ergebnis
      int ergebnis = x + y;
      // solange ergebnis groesser oder gleich 3 ist, subtrahiere 3 von ergebnis
      while (ergebnis >= 3) {
        ergebnis = ergebnis - 3;
      }
      // berechne die Paar-Nummer, indem i durch 2 geteilt und 1 addiert wird
      int paarNr = i / 2 + 1;
      // wechsel die ergebnis-Werte und gebe sie aus, je nachdem ob ergebnis 0, 1 oder
      // 2 ist
      switch (ergebnis) {
        case 0:
          System.out.println(paarNr + ". Paar: 0");
          break;
        case 1:
          System.out.println(paarNr + ". Paar: 1");
          break;
        case 2:
          System.out.println(paarNr + ". Paar: 2");
          break;
        // bei allen anderen Werten von ergebnis, gebe eine Fehlermeldung aus,
        // theoretisch kann das bei 3 oder groesseren Werten passieren, aber das wird
        // durch die while-Schleife verhindert
        default:
          System.out.println("Das kann nicht sein!");
          break;
      }
    }
  
  }



}
