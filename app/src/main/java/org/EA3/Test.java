package org.EA3;

// Antwort
// A: statischer Typ von f ist Fisch (nicht Forelle!) -> nur m(Tier,Fisch) anwendbar -> "1"
// B: gleiche Auflösung wie A, da statischer Typ von s2 ebenfalls Super ist -> m(Tier,Fisch) gewaehlt.
//    Sub ueberschreibt aber genau diese Signatur -> dynamisches Binden liefert Sub-Version -> "6"
// C: nur m(Tier,Huhn) anwendbar (Huhn passt zu keinem der anderen Parameter) -> "3"
// D: statischer Typ von s2 ist Super -> Sub's m(Vogel,Huhn) ist fuer die Auflösung unsichtbar.
//    Also wie bei C m(Tier,Huhn) gewaehlt; Sub ueberschreibt diese Signatur nicht -> geerbte Super-Methode -> "3"
// E: m(Tier,Fisch) und m(Vogel,Forelle) beide anwendbar; m(Vogel,Forelle) ist spezifischer (Vogel<:Tier, Forelle<:Fisch) -> "2"
// F: m(Tier,Huhn) und m(Huhn,Vogel) beide anwendbar, aber keine eindeutig spezifischer
//    (Tier<:Huhn falsch UND Vogel<:Huhn falsch) -> mehrdeutig, Compilerfehler
public class Test{
 public static void main(String[] args){
    // Super s1 = new Super();
    // Super s2 = new Sub();
    // Fisch f = new Forelle();
    // Forelle fo = new Forelle();
    // Vogel v = new Vogel();
    // Huhn h = new Huhn();
    // s1.m(v, f); //Aufruf A
    // s2.m(v, f); //Aufruf B
    // s1.m(v, h); //Aufruf C
    // s2.m(v, h); //Aufruf D
    // s1.m(h, fo); //Aufruf E
    // s1.m(h, h); //Aufruf F

}
class Super {
 void m(Tier t, Fisch f){
    System.out.println("1");
  }
 void m(Vogel v, Forelle f){
    System.out.println("2");
  }
 void m(Tier t, Huhn v){
    System.out.println("3");
  }
 void m(Huhn h, Vogel v){
    System.out.println("4");
  }
}

class Sub extends Super{
  void m (Vogel v, Huhn h){
System.out.println("5");
  }
  void m(Tier t, Fisch f){
    System.out.println("6");
  }
}

class Tier {}
class Vogel extends Tier {}
class Huhn extends Vogel{}
class Fisch extends Tier {}
class Karpfen extends Fisch{}
class Forelle extends Fisch{}}
