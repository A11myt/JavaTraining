package org.EA1;

import java.util.ArrayList;
import java.util.List;

public class MagicNumber {

  // Aufgabe 1
  // Eine Ausgangszahl wird, falls sie gerade ist, durch 2 dividiert.
  // Wenn sie hingegen ungerade ist, wird sie mit 3 multipliziert und dann 1
  // dazuaddiert.
  // Dieses wird wiederholt, bis das Ergebnis 1 ist. Tritt dieser Fall irgendwann
  // ein, nennt man die Ausgangszahl wundersam.
  // Interessant ist neben der Frage, ob eine Zahl wundersam ist, auch die Anzahl
  // der Schritte, die ggf. benötigt werden, bis man bei 1 ankommt.
  // Nennen wir die Funktion, welche eine wunder- same Zahl n auf die Anzahl der
  // Schritte abbildet wunder(n).
  // Dann gilt z.B.:
  // wunder(5) = 5 (mit den Schritten 16, 8, 4, 2, 1)
  // wunder(22) = 15 (mit den Schritten 11, 34, 17, 52, 26, 13, 40, 20, 10, 5, 16,
  // 8, 4, 2, 1)
  // wunder(1) = 0 (keine Schritte nötig, weil bereits der Ausgangswert 1 ist)

  public static void main(String[] args) {
    if (args.length == 0) {
      printLongestChainInRange(100);
    } else {
      int x = Integer.parseInt(args[0]);
      printChain(x);
    }
  }

  private static void printLongestChainInRange(int upperBound) {
    System.out.println("LEE GO");
    LongestChain longest = findLongestChain(upperBound);
    System.out.println();
    System.out.println(
        "Die meisten nummern mit " + longest.length() + " hat die: " + longest.number());
  }

  private static LongestChain findLongestChain(int upperBound) {
    int bestNumber = 0;
    int bestLength = 0;
    for (int i = 1; i <= upperBound; i++) {
      int length = collatzSteps(i).size();
      if (length > bestLength) {
        bestLength = length;
        bestNumber = i;
      }
    }
    return new LongestChain(bestNumber, bestLength);
  }

  private static void printChain(int n) {
    List<Integer> steps = collatzSteps(n);
    System.out.println(
        "wunder(" + n + "): = " + steps.size() + "(mit den Schritten " + steps + ")");
  }

  public static List<Integer> collatzSteps(int n) {
    int x = n;
    List<Integer> s = new ArrayList<>();
    while (x != 1) {
      if (x % 2 == 0) {
        x = x / 2;
      } else {
        x = x * 3 + 1;
      }
      s.add(x);
    }
    return s;
  }

  public static int collatzRekSteps(int n) {
    if (n == 1) return 0;
    int next = (n % 2 == 0) ? n / 2 : n * 3 + 1;
    return 1 + collatzRekSteps(next);
  }

  private record LongestChain(int number, int length) {}
}
