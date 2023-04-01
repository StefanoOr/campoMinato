/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esempi;

/**
 *
 * @author Paolo
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Cronometro {

    private JFrame frame;
    private JLabel labelTime;
    private JPanel panelButtons;
    private JButton buttonStart;
    private JButton buttonStop;
    private Timer timer;
    private long startTime;

    public Cronometro() {
        frame = new JFrame("Cronometro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(220, 140);
        labelTime = new JLabel("");
        labelTime.setFont(new Font("SansSerif", Font.BOLD, 30));
        labelTime.setHorizontalAlignment(JLabel.CENTER);
        buttonStart = new JButton("START");
        buttonStop = new JButton("STOP");
        buttonStop.setEnabled(false);
        panelButtons = new JPanel(new GridLayout(1, 2));
        panelButtons.add(buttonStart);
        panelButtons.add(buttonStop);
        frame.add(labelTime, BorderLayout.CENTER);
        frame.add(panelButtons, BorderLayout.SOUTH);
        
        timer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                long diffTime = System.currentTimeMillis() - startTime;
                int decSeconds = (int) (diffTime % 1000 / 100);
                int seconds = (int) (diffTime / 1000 % 60);
                int minutes = (int) (diffTime / 60000 % 60);
               
                String s = String.format("%2d:%02d.%d", minutes, seconds, decSeconds);
                labelTime.setText(s);
            }
        });
        buttonStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startTime = System.currentTimeMillis();
                timer.start();
                buttonStart.setEnabled(false);
                buttonStop.setEnabled(true);
            }
        });
        buttonStop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer.stop();
                buttonStart.setEnabled(true);
                buttonStop.setEnabled(false);
            }
        });
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Cronometro();
            }
        });
    }

}
