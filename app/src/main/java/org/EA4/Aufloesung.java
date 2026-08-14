package org.EA4;

import java.util.ArrayList;
import java.util.List;

public class Aufloesung {
  public static void main(String[] args) {
    Super s1 = new Sub();
    Sub s2 = new Sub();

    List<Kuh> kuhList = new ArrayList<Kuh>();
    List<Tier> tierList = null;
    
    Tier[] tierArray = new Kuh[2];
    Kuh[] kuhArray = new Kuh[5];

    // 1.Fehler finden
    // 2.Was steht in der ausgabe, nachdem fehler geloescht sind
    //Super
    s1.m(tierArray, tierList);
    // Aufruf A1 - Tier[] & List<Tier> - print = M1 (exakter Match, eindeutig)
    s1.m(kuhArray, kuhList);
    // Aufruf A2 - Kuh[] & List<Kuh> - print = M5 (Compiler bindet Signatur M2 ueber statischen Typ Super, Sub ueberschreibt diese Signatur als M5 -> Laufzeit-Dispatch fuehrt M5 aus)

    // s1.m(tierArray, kuhList);
    // Aufruf A3 - Tier[] & List<Kuh> - Fehler: keine Methode passt.
    //   M2 scheitert an p1: Tier[] nicht zuweisbar an Kuh[] (Array-Kovarianz nur Kuh[]->Tier[], nicht umgekehrt)
    //   M1 scheitert an p2: List<Kuh> nicht zuweisbar an List<Tier> (Generics-Invarianz)

    // s1.m(kuhArray, tierList);
    // Aufruf A4 - Kuh[] & List<Tier> - Fehler: ambiguous. M1 und M2 beide anwendbar, keine ist spezifischer als die andere (List<? extends Tier> ist kein Subtyp von List<Tier>)

    //Sub
    s2.m(tierArray, tierList); // Aufruf A5 - Tier[] & List<Tier> - print = M1 (spezifischer als M3, da Tier[]/List<Tier> jeweils Subtyp von Lebewesen[]/List<?>)
    s2.m(kuhArray, kuhList); // Aufruf A6 - Kuh[] & List<Kuh> - print = M5 (Signatur M2/M5 spezifischer als M3, Ueberschreiben wie bei A2)
    s2.m(tierArray, kuhList); // Aufruf A7 - Tier[] & List<Kuh> - print = M3 (M1 scheitert an Generics-Invarianz p2, M2/M5 an Array-Kovarianz p1, M4 scheitert weil kuhList statisch List<Kuh> ist, nicht ArrayList<Kuh> -> nur M3 bleibt anwendbar)
    // s2.m(kuhArray, tierList); // Aufruf A8 - Kuh[] & List<Tier> - Fehler: ambiguous. M1 und M5 beide anwendbar (gleiches Problem wie A4); M3/M4 loesen die Ambiguitaet nicht auf (M4 nicht anwendbar: tierList ist List<Tier>, nicht ArrayList<Kuh>; M3 ist nicht spezifischer als M1/M5)
  }
}

class Super {
  void m(Tier[] p1, List<Tier> p2) {
    System.out.println("M1");
  }

  void m(Kuh[] p1, List<? extends Tier> p2) {
    System.out.println("M2");
  }
}

class Sub extends Super {
  void m(Lebewesen[] p1, List<?> p2) {
    System.out.println("M3");
  }

  void m(Tier[] p1, ArrayList<Kuh> p2) {
    System.out.println("M4");
  }

  void m(Kuh[] p1, List<? extends Tier> p2) {
    System.out.println("M5");
  }
}

class Lebewesen {}
class Tier extends Lebewesen {}
class Kuh extends Tier {}
