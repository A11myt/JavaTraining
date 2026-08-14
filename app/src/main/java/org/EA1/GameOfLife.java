package org.EA1;

public class GameOfLife {
  boolean[][] feld = {
    {false, false, false, false, false},
    {false, false, true, false, false},
    {false, false, true, false, false},
    {false, false, true, false, false},
    {false, false, false, false, false}
  };

  public static void main(String[] args) {
    GameOfLife myGame = new GameOfLife();
    for (int i = 0; i < 10; i++) {
      myGame.nextGeneration();
      myGame.print();
      System.out.println();
    }
  }

  void print() {
    for (int i = 0; i < feld.length; i++) {
      for (int j = 0; j < feld[i].length; j++) {
        if (feld[i][j]) {
          System.out.print("o ");
        } else {
          System.out.print(". ");
        }
      }
      System.out.println();
    }
  }

  void nextGeneration() {
    boolean[][] nextfields = new boolean[feld.length][feld[0].length];
    for (int i = 0; i < feld.length; i++) {
      for (int j = 0; j < feld[i].length; j++) {
        int neighbours = countNeighbours(i, j);
        if (feld[i][j]) {
          nextfields[i][j] = (neighbours == 2 || neighbours == 3);
        }
        else {
          nextfields[i][j] = (neighbours == 3);
        }
      }
    }
    feld = nextfields;
  }

  int countNeighbours(int row, int col) {
    int count = 0;
    for (int di = -1; di <= 1; di++) {
      for (int dj = -1; dj <= 1; dj++) {
        if (di == 0 && dj == 0) continue;
        int ni = row + di;
        int nj = col + dj;
        if (ni >= 0 && ni < feld.length && nj >= 0 && nj < feld[ni].length && feld[ni][nj]) {
          count++;
        }
      }
    }
    return count;
  }
}
