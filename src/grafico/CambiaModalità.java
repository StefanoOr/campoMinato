/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  grafico;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author Paolo
 */
public class CambiaModalità extends AbstractAction{
  CampoMinatoGrafico campo;

    public CambiaModalità(CampoMinatoGrafico campo) {
        super("Cambia modalità");
        this.campo = campo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        campo.modalita.fermaPartita();
        
        campo.nuovaPartita(true);
    }
    
}
