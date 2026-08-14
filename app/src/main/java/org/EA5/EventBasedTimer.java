package org.EA5;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class EventBasedTimer {
  private Timer internalTimer = new Timer();
  private List<TickListener> listeners = new ArrayList<TickListener>();

  // Meldet einen TickListener beim Timer an.
  public void addTickListener(TickListener listener) {
    listeners.add(listener);
  }

  // Startet diesen Timer.
  public void start() {
    internalTimer.scheduleAtFixedRate(
        new TimerTask() {
          @Override
          // Einsendeaufgaben zum Modul 63611, Lektion 05 8
          public void run() {
            for (TickListener tickListener : listeners) {
              tickListener.tickPerformed();
            }
          }
        },
        1000,
        1000);
  }

  // Stoppt diesen Timer.
  public void stop() {
    internalTimer.cancel();
  }
}
