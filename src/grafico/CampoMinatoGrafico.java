/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  grafico;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import console.Mappa;
import modalita.Modalita;
import modalita.ModalitaCooldown;
import modalita.ModalitaCooperativa;
import modalita.ModalitaStandard;

/**
 *
 * @author Paolo
 */
public class CampoMinatoGrafico {

    private JFrame frame;
    private Mappa mappa;

    
    public JPanel main1;
    public JPanel panelloMappa;
    private JLabel labelTime = new JLabel("0:00:0");
    JLabel player = new JLabel();
    private JMenuBar menu = new JMenuBar();

    public JLabel labelBandiera = new JLabel("");

    Modalita modalita;

    public CampoMinatoGrafico() {
        init();
    }

    private void init() {
        frame = new JFrame("Campominato");
        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().setSize(350, 350);
        getFrame().setAlwaysOnTop(true);
        getLabelTime().setFont(new Font("SansSerif", Font.BOLD, 30));
        labelBandiera.setFont(new Font("SansSerif", Font.BOLD, 30));
        labelBandiera.setIcon(BottoneCasella.imgFlag);
        modalita = new ModalitaStandard(this);
        JMenu fileScore = new JMenu("Score");

        fileScore.add(new JMenuItem(new AbstractAction("Score") {
            @Override
            public void actionPerformed(ActionEvent e) {
                                                                                                                                                                                                                                                 
                Score record = Score.leggiScore(modalita.getPath());
                JOptionPane.showMessageDialog(getFrame(), "Miglior score: " + record);
            }
        }));
        JMenu file = new JMenu("File");

        file.add(new JMenuItem(new AbstractAction("Nuova Partita") {
            @Override
            public void actionPerformed(ActionEvent e) {
                nuovaPartitaMenu();
            }
        }));

        file.add(new JMenuItem(new AbstractAction("Ricomincia") {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        }));
        JMenu modality = new JMenu("Modalità");
        file.add(modality);

        modality.add(new JMenuItem(new AbstractAction("Cooldown") {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
                modalita = new ModalitaCooldown(CampoMinatoGrafico.this);
                nuovaPartita(true);
            }

        }));

        modality.add(new JMenuItem(new AbstractAction("Coperative") {

            @Override

            public void actionPerformed(ActionEvent e) {
                reset();
                modalita = new ModalitaCooperativa(CampoMinatoGrafico.this);
                nuovaPartita(true);
            }

        }));

        menu.add(file);

        menu.add(fileScore);

        getFrame().setJMenuBar(menu);

        JPanel panelloInterfaccia = new JPanel(new FlowLayout(3));
        main1 = new JPanel(new BorderLayout());
        main1.add(panelloInterfaccia, BorderLayout.NORTH);
        
        ImageIcon smile = new ImageIcon(CampoMinatoGrafico.class.getResource("smile.png"));
        //   JButton reset = new JButton(new ResetAction(this));
        JButton reset = new JButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                labelBandiera.setText("" + mappa.bombe);
                reset();
            }
        });
        panelloInterfaccia.add(labelBandiera);
        reset.setIcon(smile);
        panelloInterfaccia.add(reset);
        panelloInterfaccia.add(getLabelTime());
        panelloInterfaccia.add(player);

        getFrame().setContentPane(main1);
        nuovaPartita(false);

    }

    public void nuovaPartitaMenu() {
        modalita.fermaPartita();

        nuovaPartita(true);
    }

    public void reset() {
        modalita.fermaPartita();

        if (panelloMappa != null) {
            main1.remove(panelloMappa);
        }
        nuovaPartita(false);
    }

    public void nuovaPartita(boolean mostraDialogo) {
        int righeNuovaMappa=5;
        int colonneNuovaMappa=5;
        int bombeNuovaMappa=1;

        if (mappa != null) {
            //usa i valori della mappa esistente(ad esempio il reset)
            righeNuovaMappa = mappa.righe;
            colonneNuovaMappa = mappa.colonne;
            bombeNuovaMappa = mappa.bombe;

        }
        if (mostraDialogo) {
            DialogoNuovaPartita dnp = new DialogoNuovaPartita(getFrame(), true);
            if (!dnp.nuovaPartita) {
                return;
            }

            if (panelloMappa != null) {
                main1.remove(panelloMappa);
            }
            righeNuovaMappa = dnp.righe;
            colonneNuovaMappa = dnp.colonne;
            bombeNuovaMappa = dnp.bombe;

        }

        setMappa(new Mappa(righeNuovaMappa, colonneNuovaMappa, bombeNuovaMappa));
        modalita.iniziaGioco();
        labelBandiera.setText("" + mappa.bombe);
        getMappa().stampaMappa(
                true);
        panelloMappa = new JPanel(new GridLayout(righeNuovaMappa, colonneNuovaMappa));

        main1.add(panelloMappa, BorderLayout.CENTER);

        for (int riga = 0; riga < righeNuovaMappa; riga++) {
            for (int colonna = 0; colonna < colonneNuovaMappa; colonna++) {
                panelloMappa.add(new BottoneCasella(getMappa().getCasella(riga, colonna), this));
            }

        }
        main1.revalidate();
    }

    private void start() {
        getFrame().setVisible(true);
    }

    public static void main(String[] args) {

        CampoMinatoGrafico campominato = new CampoMinatoGrafico();
        campominato.start();

    }

    /**
     * @return the mappa
     */
    public Mappa getMappa() {
        return mappa;
    }

    /**
     * @param mappa the mappa to set
     */
    public void setMappa(Mappa mappa) {
        this.mappa = mappa;
    }

    /**
     * @return the labelTime
     */
    public JLabel getLabelTime() {
        return labelTime;
    }

    /**
     * @return the frame
     */
    public JFrame getFrame() {
        return frame;
    }

    public void terminaPartita(boolean visualizzaBombe, String mex) {
        if (visualizzaBombe) {
            mappa.visualizzaLeBombe();
        }

        mappa.disabilitaCasella();

        JOptionPane.showMessageDialog(frame, mex);
    }

    boolean rimasteSoloBombe() {
        return mappa.caselleRimaste == 0;
    }
}
