/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  grafico;

/**
 *
 * @author Paolo
 */
public class DialogoNuovaPartita extends javax.swing.JDialog {

    public boolean nuovaPartita;
    public int righe;
    public int colonne;
    public int bombe;
    public int bandiere;
    /**
     * Creates new form DialogoNuovaPartita
     */
    public DialogoNuovaPartita(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        bottoneFacile = new javax.swing.JRadioButton();
        bottoneMedio = new javax.swing.JRadioButton();
        bottoneDIfficile = new javax.swing.JRadioButton();
        personalizzato = new javax.swing.JRadioButton();
        bottoneOK = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuova Partita");
        setAlwaysOnTop(true);
        setModal(true);
        setResizable(false);

        buttonGroup1.add(bottoneFacile);
        bottoneFacile.setText("Facile (5x5,3 bombe) ");
        bottoneFacile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bottoneFacileActionPerformed(evt);
            }
        });

        buttonGroup1.add(bottoneMedio);
        bottoneMedio.setText("Medio (5x5,3 bombe)");

        buttonGroup1.add(bottoneDIfficile);
        bottoneDIfficile.setText("Difficile  (5x5,3 bombe)");

        buttonGroup1.add(personalizzato);
        personalizzato.setText("Personalizzato ");
        personalizzato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personalizzatoActionPerformed(evt);
            }
        });

        bottoneOK.setText("OK");
        bottoneOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bottoneOKActionPerformed(evt);
            }
        });

        jButton2.setText("Annulla");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bottoneFacile)
                    .addComponent(bottoneMedio)
                    .addComponent(bottoneDIfficile)
                    .addComponent(personalizzato)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bottoneOK)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bottoneFacile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bottoneMedio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bottoneDIfficile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(personalizzato)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bottoneOK)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bottoneOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bottoneOKActionPerformed
        nuovaPartita = true;
        if (bottoneFacile.isSelected()) {
            righe = 5;
            colonne = 5;
            bombe = 3;
            bandiere=3;

        } else if (bottoneMedio.isSelected()) {
            righe = 7;
            colonne = 7;
            bombe =7 ;
            bandiere=7;
        } else if (bottoneDIfficile.isSelected()) {
            righe =10;
            colonne = 10;
            bombe = 13;
            bandiere=13;
        } else if (personalizzato.isSelected()) {
            righe = 5;
            colonne = 5;
            bombe = 3;
            bandiere=bombe;
        }
        dispose();

    }//GEN-LAST:event_bottoneOKActionPerformed

    private void bottoneFacileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bottoneFacileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bottoneFacileActionPerformed

    private void personalizzatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personalizzatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_personalizzatoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton bottoneDIfficile;
    private javax.swing.JRadioButton bottoneFacile;
    private javax.swing.JRadioButton bottoneMedio;
    private javax.swing.JButton bottoneOK;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JRadioButton personalizzato;
    // End of variables declaration//GEN-END:variables
}
