/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafico;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import console.Casella;
import modalita.ModalitaATempo;

/**
 *
 * @author Paolo
 */
public class Score {

    public String nome;
    public long tempo;
    public int mosse;
    public int punti;

    public Score() {
    }

    public static boolean confrontaPunteggio(List<Score> lista, Score scoreAttuale, String path) {
//        lista.add(scoreAttuale);
//        scriviMultiScore(path, lista);

        for (int i = 0; i < lista.size(); i++) {

            if (scoreAttuale.tempo < lista.get(i).tempo) {

                lista.add(i, scoreAttuale);
                Score.scriviMultiScore(path, lista);
                return true;
            }
        }
        lista.add(scoreAttuale);
        Score.scriviMultiScore(path, lista);
        return false;
    }

    public String trasformaScore() {

        return String.format("%s-%d-%d-%d", nome, tempo, mosse, punti);
    }

    public static void scriviMultiScore(String path, List<Score> lista) {
        try {
            File file = new File(path);
            FileWriter fw = new FileWriter(file);
            for (int i = 0; i < lista.size(); i++) {
                Score a = lista.get(i);
                String prova = a.trasformaScore();
                fw.write(prova+"\r\n");
            }
            fw.flush();
            fw.close();

        } catch (Exception e) {

        }
    }

    public void scriviScore(String path) {
        try {

            File file = new File(path);
            FileWriter fw = new FileWriter(file);
            fw.write(trasformaScore());
            fw.flush();
            fw.close();
        } catch (IOException e) {

        }

    }

    public static List<Score> leggiMultiScore(String path) {
        List<Score> listaScore = new ArrayList<>(10);
        try {
            File file = new File(path);
            String contenutoDelFile = leggiFile(file);
            String[] righe = contenutoDelFile.split("\n");
            for (String riga : righe) {

                listaScore.add(leggiScoreDaUnaRiga(riga));
            }

            return listaScore;

        } catch (Exception e) {

            return null;
        }
    }

    static Score leggiScoreDaUnaRiga(String riga) {
        try {
           
            String[] parti = riga.trim().split("-");
            Score score = new Score();
            score.nome = parti[0];
            score.tempo = Long.parseLong(parti[1]);
            if (parti.length > 2) {
                score.mosse = Integer.parseInt(parti[2]);
            }
            if (parti.length > 3) {
                score.punti = Integer.parseInt(parti[3]);
            }

            return score;
        } catch (Exception e) {
            System.err.println("errore leggendo score dalla riga");
            return null;
        }
    }

    static Score leggiScore(String path) {
//        
        try {
            File file = new File(path);
            String contenutoDelFile = leggiFile(file);
            Score score = leggiScoreDaUnaRiga(contenutoDelFile);
            return score;
        } catch (Exception e) {
            System.err.println("errore leggendo score");
            return null;
        }
    }

    private static String leggiFile(File file) {

        try {

            byte[] t = Files.readAllBytes(Paths.get(file.toURI()));
            String c=new String(t, StandardCharsets.UTF_8);
            System.out.println("guarda qyu"+c);
            return new String(t, StandardCharsets.UTF_8);
            
        } catch (Exception e) {
            System.err.println("errore leggendo file ");
        }
          
        return null;

    }

    @Override
    public String toString() {

        return nome + " " + ModalitaATempo.formatTempo(tempo) + " " + mosse + " Mosse," + punti + "Punti";
    }

}
