/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esempi;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Paolo
 */
public class FileEx {

    static int minuti = 1;
    static int secondi = 20;
    static String s = String.format("%2d:%02d", minuti, secondi);

    public static void nuovoFile() {
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

    public static void scriviFile() {

        String path = "C:\\Users\\Paolo\\Desktop\\html.txt";

        try {
            File file = new File(path);
            FileWriter fw = new FileWriter(file);
            fw.write(s);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leggiFile() {

        String path = "C:\\Users\\Paolo\\Desktop\\html.txt";
        char[] in = new char[50];
        int size = 0;
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            size = fr.read(in);

            System.out.print("Caratteri presenti: " + size + "\n");
            System.out.print("Il contenuto del file è il seguente:\n");

            for (int i = 0; i < size; i++) {
                System.out.print(in[i]);
            }
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String data = "1:02:2";

        String[] items = data.split(":");

        for (String item : items) {

            System.out.println("item = " + item);

        }

    }

}
