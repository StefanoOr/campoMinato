/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modalita;

import grafico.BottoneCasella;
import grafico.CampoMinatoGrafico;
import grafico.Score;

/**
 *
 * @author Paolo
 */
public abstract class Modalita {

    CampoMinatoGrafico campo;

    public Modalita(CampoMinatoGrafico campo) {
        this.campo = campo;
    }

    public abstract void iniziaGioco();

    public abstract void premutoCasella(BottoneCasella bc);

    public abstract void partitaPersa();

    public abstract String getMexVittoria();

    public abstract void fermaPartita();
    //To change body of generated methods, choose Tools | Templates.

    public abstract String getPath();

    public abstract Score creaScore();
    //To change body of generated methods, choose Tools | Templates.
}
