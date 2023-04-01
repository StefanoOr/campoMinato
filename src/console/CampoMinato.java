/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 *
 * @author Paolo
 */
public class CampoMinato {

    Mappa mappa;

    public int r = 3;
    public int c = 3;
    public int b = 3;
    static int i = 0;
    static int x = 3;

    public void start() throws IOException {
        mappa = new Mappa(r, c,b);
        mappa.stampaMappa();
        
        Casella casellaInput;

        while (i < r * c - b) {//bug ogni volta che si seleziona la stessa casella i continua a incrementare

            casellaInput = chiediInput();

//            System.out.println("1 utente scegli la casella x=" + casellaInput.riga + " " + casellaInput.colonna);
            if (processaInput(casellaInput)) {

                System.out.println("HAI perso");
                mappa.stampaMappa();
                System.exit(0);
            } else {
                mappa.stampaMappa();
            }

        }
        System.out.println("YOU WIN");
    }

    public static boolean processaInput(Casella casella) {

        if (casella.ceLaBomba()) {
            casella.setVisible();
//            System.out.println("2 se casella x contiene una bomba esce dal gioco ");
            return true;
        }

//        System.out.println(" 2 se casella x non contiene la bomba CONTINUA");
        processa(casella);
        return false;
    }

    public static void main(String[] args) throws IOException {
        CampoMinato campominato = new CampoMinato();
        campominato.start();
    }

    private Casella chiediInput() throws IOException {
//ritorna la  casella  della mappa   alla posizione  decisa dal giocatore.... bich fanculo il sistema
        InputStreamReader ncp = new InputStreamReader(System.in);
        BufferedReader brr = new BufferedReader(ncp);

        System.out.print("Inserisci la riga :");
        String input = brr.readLine();
        Integer rigainput = convertInt(input);

        if (input.contains("q")) {
            System.exit(0);
        }
        System.out.print("Inserisci la colonna :");
        input = brr.readLine();
        Integer colonnainput = convertInt(input);

        if (input.contains("q")) {
            System.exit(0);
        }

        if (rigainput == null || colonnainput == null) {
            System.out.println("Inserisci un numero");
            return chiediInput();

        }

        if (rigainput < 0 || colonnainput < 0 || rigainput > r - 1 || colonnainput > c - 1) {

            return chiediInput();
        } else {

            System.out.println("Inserisci un numero");
            return mappa.caselle[rigainput][colonnainput];

        }

    }

    public static Integer convertInt(String numero) {
        try {
            return Integer.parseInt(numero);
        } catch (Exception e) {
            return null;
        }
    }

    public static void processa(Casella x) {
        if (x.isVisible == false) {
            i++;
        }
        x.setVisible();

//        System.out.println("3 rende visibile la casella x con il suo numeroBombeAccanto");
        if (x.numeroBombeAccanto() == 0) {
//            System.out.println(" 4  se casella x non ha numenumeroBombeAccanto prende le caselle circostanti (caselle Z)  ");
            List<Casella> caselleCircostanti = x.prendiCaselleCircostanti();
//            System.out.println("5 per ogni casella in caselle Z  ritorna  al punto 3  ");
            for (int j = 0; j < caselleCircostanti.size(); j++) {
                Casella z = caselleCircostanti.get(j);
                if (z.isVisible == false) {
                    processa(z);
                }
            }
        } else {

//            System.out.println("4 se casella x ha numeroBombeAccanto non fa niente");
        }

    }

}
//se la casella non ha  delle bombe affianco (numerobombe affianco=0) rende true le altre caselle  circostanti cosi via finche non si arriva alle casselle con delle bombe accanto (numeroBombeAffianco >1)
/*
1 utente scegli la casella x
2 se casella x contiene una bomba esce dal gioco 
  se casella x non contiene la bomba CONTINUA
3 rende visibile la casella x con il suo numeroBombeAccanto
4 se casella x ha numeroBombeAccanto non fa niente
   se casella x non ha numenumeroBombeAccanto prende le caselle circostanti (caselle Z)  
5 per ogni casella in caselle Z  ritorna  al punto 3  
x x x x  0 1 x x
x x x x  0 2 & x
x x x x  0 2 & x
 */
