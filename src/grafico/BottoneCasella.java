/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  grafico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import console.CampoMinato;
import console.Casella;
import modalita.Modalita;

/**
 *
 * @author Paolo
 */
public class BottoneCasella extends JToggleButton {

    Player player = new Player();
    Casella casella;
    CampoMinatoGrafico campo;

    static public ImageIcon imgFlag = new ImageIcon(CampoMinato.class.getResource("../grafico/flag.png"));

    public BottoneCasella(Casella casella, CampoMinatoGrafico campo) {
        super();
        this.campo = campo;
        this.casella = casella;
        casella.setBottone(this);

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (SwingUtilities.isRightMouseButton(e)) {

                    if (getIcon() == null && isEnabled()) {
                        if (campo.getMappa().contaBandiere() < campo.getMappa().bombe) {

                            setIcon(imgFlag);

                            setDisabledIcon(imgFlag);
                            setEnabled(false);
                            casella.bandiera = true;
                            campo.labelBandiera.setText("" + campo.getMappa().getBandiereRimaste());

                        }
                    } else {
                        casella.bandiera = false;

                        campo.labelBandiera.setText("" + campo.getMappa().getBandiereRimaste());
                        setEnabled(true);
                        setIcon(null);
                    }

                }
                {

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Riga" + casella.getRiga() + " Colonna :" + casella.getColonna());
                setEnabled(false);

                campo.modalita.premutoCasella(BottoneCasella.this);

                if (CampoMinato.processaInput(casella)) {
                    campo.modalita.partitaPersa();
                }

                if (campo.rimasteSoloBombe()) {

                    campo.getMappa().mettiBandiereEndGame();
                    campo.modalita.fermaPartita();
                    Score scoreAttuale = campo.modalita.creaScore();
                    List<Score> multiScoreVecchio = Score.leggiMultiScore(campo.modalita.getPath());
//                    Score scoreVecchio = Score.leggiScore(campo.modalita.getPath());
                    if (scoreAttuale.mosse != 1) {
                        if (multiScoreVecchio != null) {

                            if (Score.confrontaPunteggio(multiScoreVecchio,scoreAttuale,campo.modalita.getPath())) {
//                                scoreAttuale.scriviScore(campo.modalita.getPath());
                                        Score.scriviMultiScore(campo.modalita.getPath(), multiScoreVecchio);
                                campo.terminaPartita(false, campo.modalita.getMexVittoria() );

                            } else {
                                campo.terminaPartita(false, "HAI Vinto,imbattuto");

                            }

                        } else {
                            scoreAttuale.scriviScore(campo.modalita.getPath());
                            campo.terminaPartita(false, "HAI Vinto,score migliore");

                        }
                    }else{
                        campo.terminaPartita(false, "Colpo fortunato");
                    }
                }

            }

        });

    }

    @Override
    public String getText() {
        if (casella == null) {
            return "";
        }
        return casella.toString();
    }

}
