package org.EA3;

// abstract: Tier kann selbst nicht instanziiert werden (kein "new Tier()"),
// druckeEigenschaften() hat keinen Rumpf und muss von jeder konkreten
// Unterklasse (Pinguin, Loewe, Schmetterling, ...) implementiert werden.
//
// Nachteil: Java erlaubt bei Klassen nur Einfachvererbung. Eine Unterklasse
// von Tier kann also nicht gleichzeitig von einer anderen (abstrakten)
// Klasse erben. Im Tierpark-Beispiel faellt das nicht auf, waere aber ein
// Problem, wenn ein Tier zusaetzlich Eigenschaften aus einer voellig
// anderen Klassenhierarchie braeuchte.
public abstract class Tier {

  public abstract String druckeEigenschaften();
}


