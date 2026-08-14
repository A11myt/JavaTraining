package org.EA2;

public class HagenGamesTest {
  public static void main(String[] args) {
    HagenGames hg = new HagenGames();
    Playable game = hg.buyGame();

    game.playGame();
    // game.update();
    // game.playGame();

    hg.updateGame(game);

    // Aufgabe D - S 151 paketlokale Sichtbarkeit
    // an deklariert ObjectWars ohne den Modifizierer public (paketlokaler Zugriff)
    // und platziert HagenGames und ObjectWars im selben Package, während Test in
    // einem anderen Package liegt – dadurch kann Test den Typnamen ObjectWars gar
    // nicht mehr referenzieren und somit auch nicht auf ihn casten, während
    // HagenGames.updateGame (im selben Package wie ObjectWars) den Cast weiterhin
    // durchführen kann.
  }
}
