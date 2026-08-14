package org.EA5;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class EggTimerCanvas extends Canvas {

  private EggTimerModel eggTimer;

  public EggTimerCanvas(EggTimerModel eggTimer) {
    this.eggTimer = eggTimer;
    setPreferredSize(new Dimension(320, 320));
  }

  @Override
  public void paint(Graphics g) {
    g.setColor(Color.RED);
    g.fillOval(10, 10, 300, 300);
    g.setColor(Color.GREEN);
    g.fillArc(10, 10, 300, 300, 0, (int) (eggTimer.getElapsedPart() * 360));
  }
}
