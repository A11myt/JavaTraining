package org.EA5;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MVCEggTimerMain {

  // Erzeugen eines EggTimerModel für eine Laufzeit von 60 Sekunden.
  private EggTimerModel eggTimer;
  // Erzeugen eines EggTimerCanvas, das das oben erzeugte Model verwendet.
  private EggTimerCanvas window;
  private EggTimerController controller;
  private Frame frame;
  private Button startBtn;
  public MVCEggTimerMain(int timer) {
    this.eggTimer = new EggTimerModel(timer);
    this.window = new EggTimerCanvas(eggTimer);
    this.startBtn = new Button("Start");
   this.controller = new EggTimerController(eggTimer, window);
    this.frame = new Frame("Kurzzeitwecker");
    frame.addWindowListener(
        new WindowAdapter() {
          @Override
          public void windowClosing(WindowEvent e) {
            System.exit(0);
          }
        });
    frame.add(window);
    frame.add(startBtn, BorderLayout.SOUTH);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    startBtn.addActionListener(controller);
  }


  public static void main(String[] args) {
  
   new MVCEggTimerMain(60);
    // new MVCEggTimerMain(Integer.parseInt(args[0]));
  }

}
