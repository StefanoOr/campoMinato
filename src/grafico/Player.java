/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  grafico;

import console.Casella;

/**
 *
 * @author Paolo
 */
public class Player {

    Casella casella;
    CampoMinatoGrafico campo;
    boolean player1;
  


    public void cambiaPlayer() {
        if (player1) {
            campo.player.setText("P1");
            player1 = false;
            
        } else {
            player1 = true;
            campo.player.setText("P2");
        }
    }

}
