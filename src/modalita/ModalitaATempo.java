/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modalita;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import grafico.BottoneCasella;
import grafico.CampoMinatoGrafico;
import grafico.Score;

/**
 *
 * @author Paolo
 */
public abstract class ModalitaATempo extends Modalita {

    protected boolean timerInFunzione;
    protected long startTime;
    protected Timer timer;
    static DateTimeFormatter formataData = DateTimeFormatter.ofPattern("mm:ss:SSS");
    private int mosse;

    public ModalitaATempo(CampoMinatoGrafico campo) {
        super(campo);
        timer = new Timer(70, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (timerInFunzione) {

                    timerAggiornato(getTempoTrascorso());
                }
            }

        });
        timer.start();
    }

    private long getTempoTrascorso() {
        return System.currentTimeMillis() - startTime;
    }

    public static String formatTempo(long tempoMs) {
        Duration dur = Duration.ofMillis(tempoMs);
        LocalTime t = LocalTime.MIDNIGHT.plus(dur);
        return formataData.format(t);
    }

    public abstract void timerAggiornato(long diffTime);

    @Override
    public void partitaPersa() {
        fermaTimer();
        campo.terminaPartita(true, "Hai Perso");

    }

    @Override
    public void fermaPartita() {
        fermaTimer();
        campo.getLabelTime().setText(formatTempo(0));
        
    }

    private void fermaTimer() {
        timerInFunzione = false;
    }

    @Override
    public void premutoCasella(BottoneCasella bc) {
            mosse++;
        if (timerInFunzione == false) {
            startTime = System.currentTimeMillis();

            timerInFunzione = true;

        }
    }

    @Override
    public Score creaScore() {
        Score score = new Score();
        score.tempo = getTempoTrascorso();
        String nickname = JOptionPane.showInputDialog("Hai vinto, il tuo tempo è" + formatTempo(score.tempo) + "\nInserisci Nickname");
        nickname=nickname.replace("-","_");
        score.nome=nickname;
        score.mosse=mosse;
        return score;
        
    }

}
