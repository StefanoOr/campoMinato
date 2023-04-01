/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modalita;

import javax.swing.JOptionPane;
import grafico.CampoMinatoGrafico;

/**
 *
 * @author Paolo
 */
public class ModalitaCooldown extends ModalitaATempo {

    public static String path = "C:\\Users\\Paolo\\Desktop\\cool.txt";
    long tempoMassimo;

    public ModalitaCooldown(CampoMinatoGrafico campo) {
        super(campo);
    }

    @Override
    public void iniziaGioco() {
        tempoMassimo = campo.getMappa().bombe * 10000;
        System.out.println(campo.getMappa().bombe);
        System.out.println(tempoMassimo);
        System.out.println("cooldown");
    }

    @Override
    public void timerAggiornato(long tempoTrascorso) {

        long rimanente = getTempoRimanente(tempoTrascorso);
        campo.getLabelTime().setText(formatTempo(rimanente));
        if (rimanente <= 0) {
            fermaPartita();
            campo.terminaPartita(false, "Tempo finito , hai perso");

        }
    }

    @Override
    public void fermaPartita() {
        super.fermaPartita();
        campo.getLabelTime().setText("");
    }

    @Override
    public String getMexVittoria() {
        return "Coldownn hai vintoi";
    }

    public long getTempoRimanente(long tempo) {
        return tempoMassimo - tempo;
    }

    @Override
    public String getPath() {
  return path;
    }
}
