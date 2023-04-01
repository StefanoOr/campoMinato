package modalita;


import grafico.BottoneCasella;
import grafico.CampoMinatoGrafico;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paolo
 */
public class ModalitaCooperativa extends ModalitaStandard{
    public static String path = "C:\\Users\\Paolo\\Desktop\\html.txt";
    
    public ModalitaCooperativa(CampoMinatoGrafico campo) {
        super(campo);
    }

    @Override
    public void premutoCasella(BottoneCasella bc) {
        campo.terminaPartita(true, "Coming soon");
    }
      
}
