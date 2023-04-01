/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modalita;

import grafico.CampoMinatoGrafico;

/**
 *
 * @author Paolo
 */
public class ModalitaStandard extends ModalitaATempo {

    public static String path = "C:\\Users\\Paolo\\Desktop\\html.txt";

    public ModalitaStandard(CampoMinatoGrafico campo) {
        super(campo);

    }

    @Override
    public void iniziaGioco() {
//        System.out.println("Modalita Standard");

    }

    @Override
    public void timerAggiornato(long diffTime) {
        campo.getLabelTime().setText(formatTempo(diffTime));
    }

    @Override
    public String getMexVittoria() {
        return "Modalita normale  hai vintoi";
    }

    @Override
    public String getPath() {
        return path;
    }

}
