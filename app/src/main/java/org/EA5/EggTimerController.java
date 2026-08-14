package org.EA5;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EggTimerController implements TickListener, ActionListener {

  private EggTimerModel eggTimer;
  private EventBasedTimer eventBasedTimer;
  private EggTimerCanvas window;

  public EggTimerController(EggTimerModel eggTimer, EggTimerCanvas window) {
    this.eggTimer = eggTimer;
    this.eventBasedTimer = new EventBasedTimer();
    this.window = window;
    eventBasedTimer.addTickListener(this);
    
  }

  public void actionPerformed(ActionEvent e){
    eventBasedTimer.start();
    Button btn = (Button) e.getSource();
    btn.setEnabled(false);
  } 
  

  public void tickPerformed() {
    eggTimer.increaseElapsedTime();
    var elapsedTime = eggTimer.getElapsedPart();
    window.repaint();
    if (elapsedTime == 1) {
      eventBasedTimer.stop();
    }
  }
}
