package org.EA2;

// a) Welche Datentypen werden verwendet? Welche davon sind Basisdatentypen? 
// 1. int, int ist ein basistyp
// 2. string, string ist ein Referenztyp (kein basistyp da von obj erbt)
// 3.  object, object ist kein basistyp
// 4. Foo ist ein obj, daher ein Referenztyp 

// b) Welche unbenannten Konstanten enthält das Programm? 
// quasi jeder wert der zugewiesen wird, also 
// 1. 3
// 2. "Hallo"
// 3. 42

// c) Welche benannten Konstanten sind enthalten? 
// ein Alias fuer einen wert der mit final also unveraenderlich geflaggt ist zb. final object s 
// Merksatz: b) fragt nach Werten ohne Namen (Literale), c) fragt nach Werten mit Namen (final-Deklarationen).

// d) Welche formalen Parameter können Sie entdecken? 
// im prinzip alle uebergabe paramterer also in foo int i und string s
// Foo f
// und int a

// e) Welche Attribute sind zu finden? Unterscheiden Sie in Objekt- und Klassenattribute. 
// i und s sind attribute da sie direkt in der klasse deklariert werden. außerhalb von Methoden und Konstruktoren, sie sind fuer jedes Foo Object die default werte also sind sie Instanzvariablen 

// f) Welche Konstruktoren sind zu finden? 
// Foo(i & s) & Foo(foo) beides konstruktoren

// g) Welche Methoden sind zu finden? Unterscheiden Sie in Objekt- und Klassenmethoden. 
// int m als auch int m(a) sind objectmethoden also foo.m().. und static void x kann ohne object aufgerufen werden daher eine Klassenmethode

// h) Wo finden Überladungen statt?
// sowohl bei den konstruktoren Foo als auch bei m

//i) Gibt es in dem Programm Stellen, an denen der Compiler Fehler meldet? Wenn ja, wo und warum? 
// static void x schmeisst einen fehler da die variable von der klasse i nicht static ist.

public class Foo {
  private int i = 3; //instanzvariable variable
  final Object s;  //final darf nur einmal zugewiesen werden/unveraenderlichn da im Konstruktor zugewiesen. object ist der type und s ist der name des objects

  private Foo(int i, String s) {
    this.i = i; //i ist 3 eine int variable 
    this.s = s; //string ist object daher ok /subclass um string operatioren aufzurufen muss man aber erst zurueck casten
  }

 //foo ist das obj und hier wird foo ueber das object foo aufgerufen eine ueberladung
  Foo(Foo f) {
    this.i = f.i; 
    this.s = f.s;
  }

  int m() { //gibt einfach 42 zurueck
    String s = "Hallo";
    System.out.println(s);
    return 42;
  }

  int m(int a) { //ueberladung von m gibt i zurueck
    return i;
  }

  // static void x() { // printend einfach i
  //   System.out.println(i);
  // }
}
