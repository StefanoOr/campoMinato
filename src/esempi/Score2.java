/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esempi;

import java.io.File;
import java.io.IOException;

import grafico.CampoMinatoGrafico;
import grafico.CampoMinatoGrafico;

/**
 *
 * @author Paolo
 */
public class Score2 {

    CampoMinatoGrafico campoGrafico;

    public Score2() {
    }

    public void newFile() {
        String path = "C:\\Users\\Paolo\\Desktop\\html.txt";

        try {
            File file = new File(path);

            if (file.exists()) {
                System.out.println("Il file " + path + " esiste");
            } else if (file.createNewFile()) {
                System.out.println("Il file " + path + " è stato creato");
            } else {
                System.out.println("Il file " + path + " non può essere creato");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String readFile(){
        return "fottiti";
    }

    public static Integer convertInt(String numero) {
        try {

            return Integer.parseInt(numero.trim());

        } catch (Exception e) {

            return null;
        }

    }

    public boolean scoreSuperiore(int minuti, int secondi, int milliSecondi) {
        String data = readFile();
        String score = String.format("%d:%02d:%d", minuti, secondi, milliSecondi);

        String scoreAttuale[] = score.split(":");

        System.out.println("provaaa" + scoreAttuale[1]);

        String[] scoreVecchioLettura = data.split("-");
        String[] vecchioTimeLettura = scoreVecchioLettura[1].split(":");

        int[] timer = new int[scoreAttuale.length];
        int[] scoreVecchio = new int[vecchioTimeLettura.length];
//        for (String i : scoreVecchioLettura) {
//            System.out.println(i + "test qui");
//        }
        for (int i = 0; i < scoreAttuale.length; i++) {
            timer[i] = convertInt(scoreAttuale[i]);

        }

        for (int i = 0; i < vecchioTimeLettura.length; i++) {

            scoreVecchio[i] = convertInt(vecchioTimeLettura[i]);

        }
        if (timer[0] < scoreVecchio[0]) {
            System.out.println("minuti");
            return true;
        }
        if (timer[1] < scoreVecchio[1]) {
            System.out.println("secondi");
            return true;
        }
        if (timer[2] < scoreVecchio[2]) {
            System.out.println("millisecondi");
            return true;
        }

        return false;
    }
}
