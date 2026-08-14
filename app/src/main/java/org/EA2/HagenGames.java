package org.EA2;


class HagenGames {
  public Playable buyGame() {
  return new ObjectWars();
  
 }

 public void updateGame(Playable game){
  ((ObjectWars)game).update();
 }
}

class ObjectWars implements Playable{
  private double version = 1.0;

  public void playGame() {
    System.out.println("Running ObjectWars, Version" + version);
  }

  public void update() {
    version = version + 0.1;
  }
} 

