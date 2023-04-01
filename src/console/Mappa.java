/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package console;

import javax.swing.ImageIcon;

/**
 *
 * @author Paolo
 */
public class Mappa {

    final Casella[][] caselle;
    public final int righe;
    public final int colonne;
    public final int bombe;
   
    public int caselleRimaste;
    public static ImageIcon imgBomba = new ImageIcon(CampoMinato.class.getResource("../grafico/bomb.png"));

    public Mappa(int righe, int colonne, int bombe) {
        this.colonne = colonne;
        this.righe = righe;
        this.bombe = bombe;
        
        caselleRimaste = righe * colonne - bombe;
        caselle = new Casella[righe][colonne];
        popolaCampo();

    }

    public void stampaMappa() {
        stampaMappa(false);
    }

    public void mettiBandiereEndGame() {
        Casella casella;

        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                casella = getCasella(i, j);
                if (!casella.isVisible) {
                    casella.bottone.setIcon(casella.bottone.imgFlag);
                    casella.bottone.setDisabledIcon(casella.bottone.imgFlag);
                    casella.bottone.setEnabled(false);
                }
            }
        }

    }
    public int getBandiereRimaste(){
        
        return bombe-contaBandiere();
    }

    public void disabilitaCasella() {
        Casella casella;

        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                casella = getCasella(i, j);

                casella.bottone.setEnabled(false);

            }
        }
    }

    public void visualizzaLeBombe() {
        Casella casella;
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                casella = getCasella(i, j);
                if (casella.ceLaBomba()) {
                    if (casella.isModalitaGrafica()) {

                        casella.bottone.setIcon(imgBomba);
                        casella.bottone.setDisabledIcon(imgBomba);
                        casella.setVisible();

                    }
                    casella.setVisible();
                }
            }
        }
    }

    public void stampaMappa(boolean vedi) {
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                if (vedi) {
                    System.out.print(caselle[i][j].numeroBombeAccanto() + " ");
                } else {
                    System.out.print(caselle[i][j] + " ");
                }
            }
            System.out.println("");
        }
    }

    public Casella getCasella(int riga, int colonna) {
        return caselle[riga][colonna];
    }

    private void popolaCampo() {

        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                caselle[i][j] = new Casella(this, i, j);
            }
        }
        while (bombe > contaBombe()) {

            Casella casella = caselle[numberRandom(0, righe)][numberRandom(0, colonne)];
            casella.bomba = true;
        }
    }

    public int contaBandiere() {
        int contaBandiere = 0;
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                if (caselle[i][j].ceLaBandiera()) {
                    contaBandiere++;

                }
            }
        }
        return contaBandiere;
    }

    public int contaBombe() {
        int contatoreBombe = 0;
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                if (caselle[i][j].ceLaBomba()) {
                    contatoreBombe++;
                }
            }
        }
        return contatoreBombe;
    }

    public int contaCaselle() {

        return caselleRimaste--;
    }

    public static int numberRandom(int min, int max) {

        int numeroRandom = (int) (Math.random() * (max - min));

        return numeroRandom;
    }

    public static Integer convertInt(String numero) {
        try {
            return Integer.parseInt(numero);
        } catch (Exception e) {
            return null;
        }

    }
}
