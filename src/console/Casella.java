/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package console;

import java.util.ArrayList;
import java.util.List;
import grafico.BottoneCasella;

/**
 *
 * @author Paolo
 */
public class Casella {

    BottoneCasella bottone;
    Mappa mappa;
    final int riga;
    final int colonna;
    public boolean bomba;
    public boolean bandiera;
    public boolean isVisible;


    public Casella(Mappa mappa, int riga, int colonna) {

        this.mappa = mappa;
        this.riga = riga;
        this.colonna = colonna;

    }

    public int getRiga() {
        return riga;
    }

    public int getColonna() {
        return colonna;
    }

    public boolean ceLaBomba() {
        if (!bomba) {
            return false;
        } else {
            return true;
        }
    }

    public boolean ceLaBandiera() {
        if (!bandiera) {
            return false;

        } else {
            return true;
        }
    }

    public Mappa getMappa() {
        return mappa;
    }

    public int numeroBombeAccanto() {
        int numeroBombeAccanto = 0;

        if (colonna + 1 < mappa.colonne && mappa.caselle[riga][colonna + 1].ceLaBomba()) {

            numeroBombeAccanto++;
        }
        if (riga + 1 < mappa.righe && mappa.caselle[riga + 1][colonna].ceLaBomba()) {
            numeroBombeAccanto++;
        }
        if (colonna - 1 >= 0 && mappa.caselle[riga][colonna - 1].ceLaBomba()) {
            numeroBombeAccanto++;
        }
        if (riga - 1 >= 0 && mappa.caselle[riga - 1][colonna].ceLaBomba()) {
            numeroBombeAccanto++;
        }
        if (colonna + 1 < mappa.colonne && riga + 1 < mappa.righe && mappa.caselle[riga + 1][colonna + 1].ceLaBomba()) {
            numeroBombeAccanto++;
        }
        if (colonna - 1 >= 0 && riga - 1 >= 0 && mappa.caselle[riga - 1][colonna - 1].ceLaBomba()) {
            numeroBombeAccanto++;
        }
        if (riga - 1 >= 0 && colonna + 1 < mappa.colonne && mappa.caselle[riga - 1][colonna + 1].ceLaBomba()) {
            numeroBombeAccanto++;
        }
        if (colonna - 1 >= 0 && riga + 1 < mappa.righe && mappa.caselle[riga + 1][colonna - 1].ceLaBomba()) {
            numeroBombeAccanto++;
        }
       
        return numeroBombeAccanto;
    }

    public void setVisible() {
        isVisible = true;
        if (isModalitaGrafica()) {
            bottone.setSelected(true);
            bottone.setEnabled(false);
            
            mappa.contaCaselle();
        }
    }

    public List prendiCaselleCircostanti() {

        List<Casella> listaCaselle = new ArrayList<>(8);

        if (colonna + 1 < mappa.colonne) {
            if (mappa.caselle[riga][colonna + 1].bandiera) {

            } else {
                listaCaselle.add(mappa.caselle[riga][colonna + 1]);
            }
        }

        if (riga + 1 < mappa.righe) {
            if (mappa.caselle[riga + 1][colonna].bandiera) {

            } else {
                listaCaselle.add(mappa.caselle[riga + 1][colonna]);
            }
        }

        if (colonna - 1 >= 0) {
            if (mappa.caselle[riga][colonna - 1].bandiera) {

            } else {
                listaCaselle.add(mappa.caselle[riga][colonna - 1]);
            }
        }

        if (riga - 1 >= 0) {
            if (mappa.caselle[riga - 1][colonna].bandiera) {

            } else {
                listaCaselle.add(mappa.caselle[riga - 1][colonna]);
            }
        }

        if (colonna + 1 < mappa.colonne && riga + 1 < mappa.righe) {
            if (mappa.caselle[riga + 1][colonna + 1].bandiera) {

            } else {
                listaCaselle.add(mappa.caselle[riga + 1][colonna + 1]);
            }
        }

        if (colonna - 1 >= 0 && riga - 1 >= 0) {
            if (mappa.caselle[riga - 1][colonna - 1].bandiera) {

            } else {
                listaCaselle.add(mappa.caselle[riga - 1][colonna - 1]);
            }
        }

        if (riga - 1 >= 0 && colonna + 1 < mappa.colonne) {
            if (mappa.caselle[riga - 1][colonna + 1].bandiera) {

            } else {
                listaCaselle.add(mappa.caselle[riga - 1][colonna + 1]);
            }
        }

        if (colonna - 1 >= 0 && riga + 1 < mappa.righe) {
            if (mappa.caselle[riga + 1][colonna - 1].bandiera) {

            } else {
                listaCaselle.add(mappa.caselle[riga + 1][colonna - 1]);
            }
        }

        return listaCaselle;
    }

    public boolean isModalitaGrafica() {
        return bottone != null;
    }

    @Override
    public String toString() {
        if (isVisible == false) {
            if (isModalitaGrafica()) {

                return "";
            }
            return "x";
        }

        if (ceLaBomba()) {
            if (isModalitaGrafica()) {

                return "";

            }
            return "*";
          
        } else if (numeroBombeAccanto() > 0) {
            return "" + numeroBombeAccanto();
        } else {
            return null;
        }
    }

    public void setBottone(BottoneCasella bottone) {
        this.bottone = bottone;

    }

}
