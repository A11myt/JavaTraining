package org.EA3;

// Reihenfolge der Konstanten entspricht der mittleren Entfernung zur Sonne
// (aufsteigend), Werte laut Wikipedia in Mio. km:
public enum Planet {
    MERCURY(0),  // ca. 57,9 Mio. km
    VENUS(0),    // ca. 108,2 Mio. km
    EARTH(1),    // ca. 149,6 Mio. km
    MARS(2),     // ca. 227,9 Mio. km
    JUPITER(95), // ca. 778,5 Mio. km
    SATURN(146), // ca. 1.434,0 Mio. km
    URANUS(27),  // ca. 2.871,0 Mio. km
    NEPTUNE(14); // ca. 4.495,0 Mio. km

  private final int numberOfMoons;

  Planet(int numberOfMoons){ //Konstruktor um den planeten die anzahl der monde zu geben
    this.numberOfMoons = numberOfMoons;
  }
  public int getNumberOfMoons(){
  return numberOfMoons;
  }
  
  public boolean isCloserToSunThan(Planet other){
    return this.ordinal() > other.ordinal();
  }
}
