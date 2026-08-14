package org.EA3;
public class Pinguin extends Tier {

  @Override
  public String druckeEigenschaften() {
    String ausgabe = "2 Beine\ngefährlich für Menschen: nein";
    System.out.println(ausgabe);
    return ausgabe;
  }
}
