package org.EA1;

public class CaseDiffer {
  public static void main(String[] animalName) {
    if (animalName[0].equals("Spinne")) {
      System.out.println("8 Beine");
      System.out.println("flugfaehig: nein");
      System.out.println("hat federn: nein");
      System.out.println("gefaehrlich fuer den menschen: eventuell");
    } else {
      System.out.println("Tier befindet sich nicht in der DB");
    }
  }
}

//Warum ist dies kein gutes vorgehn?
//Zu langer code mit zu vielen wiederholenden worten der schwer wartbar ist usw.
//1. Wartbarkeit 1000 Zeilen in einer methode ist deutlich zu viel fuer eine methode imagine, dort kommt eine eigenschaft duzu
//2. Wiederholung DRY verletzung(dont repeat yourself) immer das selbe
//3. Sequentielle Prüfung (Iteration) bevor ich beim naechseten tier bin muss ich immer alles davor pruefen
//4. Datenhaltung und Logik sind untrennbar kombiniert
//5. Typos koennen nicht wirklich abgefangen werden
