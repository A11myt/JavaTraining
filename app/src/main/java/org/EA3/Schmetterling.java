package org.EA3;
public class Schmetterling extends Tier {

  @Override
  public String druckeEigenschaften() {
    String ausgabe = "6 Beine\ngefährlich für Menschen: nein";
    System.out.println(ausgabe);
    return ausgabe;
  }
}
