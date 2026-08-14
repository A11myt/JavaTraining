package org.EA3;
public class Loewe extends Tier{

  @Override
  public String druckeEigenschaften() {
    String ausgabe = "4 Beine\ngefährlich für Menschen: ja";
    System.out.println(ausgabe);
    return ausgabe;
  }
}

