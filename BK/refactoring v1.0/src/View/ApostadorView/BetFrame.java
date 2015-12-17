/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.ApostadorView;

import Controller.BetESSAPI;
import model.Aposta;
import model.Apostador;
import model.Evento;
import model.Resultado;

/**
 *
 * @author xavier
 */
public class BetFrame extends javax.swing.JFrame {
    
    private BetESSAPI controller;
    private Apostador apostador;
    private Evento evento;

    /**
     * Creates new form BetFrame
     */
    public BetFrame() {
        initComponents();
    }
    public BetFrame(BetESSAPI controller, Apostador apostador, Evento evento) {
        initComponents();
        this.controller = controller;
        this.apostador = apostador;
        this.evento = evento;
        this.jLabelEq1.setText(this.evento.getEquipa1());
        this.jLabelEq2.setText(this.evento.getEquipa2());
        this.jLabelOddVit.setText(new Float(this.evento.getOdd().getOdd1()).toString());
        this.jLabelOddEmp.setText(new Float(this.evento.getOdd().getOddx()).toString());
        this.jLabelOddDer.setText(new Float(this.evento.getOdd().getOdd2()).toString());
        this.jRadioButtonVitoria.setSelected(rootPaneCheckingEnabled);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelEq1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelEq2 = new javax.swing.JLabel();
        jLabelOddVit = new javax.swing.JLabel();
        jLabelOddEmp = new javax.swing.JLabel();
        jLabelOddDer = new javax.swing.JLabel();
        jRadioButtonVitoria = new javax.swing.JRadioButton();
        jRadioButtonEmpate = new javax.swing.JRadioButton();
        jRadioButtonDerrota = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldCoins = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jToggleButtonOk = new javax.swing.JToggleButton();
        jToggleButtonCancel = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelEq1.setText("equipa 1");

        jLabel2.setText("X");

        jLabelEq2.setText("equipa 2");

        jLabelOddVit.setText("vitoria");

        jLabelOddEmp.setText("empate");

        jLabelOddDer.setText("derrota");

        jRadioButtonVitoria.setText("vitoria");
        jRadioButtonVitoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonVitoriaActionPerformed(evt);
            }
        });

        jRadioButtonEmpate.setText("empate");
        jRadioButtonEmpate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonEmpateActionPerformed(evt);
            }
        });

        jRadioButtonDerrota.setText("derrota");
        jRadioButtonDerrota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonDerrotaActionPerformed(evt);
            }
        });

        jLabel1.setText("valor");

        jLabel3.setText("BetCoins");

        jToggleButtonOk.setText("ok");
        jToggleButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonOkActionPerformed(evt);
            }
        });

        jToggleButtonCancel.setText("cancel");
        jToggleButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonEmpate)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButtonVitoria)
                                    .addComponent(jRadioButtonDerrota))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldCoins, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jToggleButtonOk)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jToggleButtonCancel))
                                    .addComponent(jLabel2)
                                    .addComponent(jLabelOddEmp))))
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelOddVit)
                            .addComponent(jLabelEq1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelEq2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelOddDer, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(48, 48, 48))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEq1)
                    .addComponent(jLabel2)
                    .addComponent(jLabelEq2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelOddVit)
                    .addComponent(jLabelOddEmp)
                    .addComponent(jLabelOddDer))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonVitoria)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldCoins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonEmpate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonDerrota)
                    .addComponent(jToggleButtonOk)
                    .addComponent(jToggleButtonCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_jToggleButtonCancelActionPerformed

    private void jRadioButtonVitoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonVitoriaActionPerformed
        this.jRadioButtonEmpate.setSelected(false);
        this.jRadioButtonDerrota.setSelected(false);
    }//GEN-LAST:event_jRadioButtonVitoriaActionPerformed

    private void jRadioButtonEmpateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonEmpateActionPerformed
        this.jRadioButtonVitoria.setSelected(false);
        this.jRadioButtonDerrota.setSelected(false);
    }//GEN-LAST:event_jRadioButtonEmpateActionPerformed

    private void jRadioButtonDerrotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDerrotaActionPerformed
        this.jRadioButtonVitoria.setSelected(false);
        this.jRadioButtonEmpate.setSelected(false);
    }//GEN-LAST:event_jRadioButtonDerrotaActionPerformed

    private void jToggleButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonOkActionPerformed
        char r = this.jRadioButtonVitoria.isSelected() ? '1' : (this.jRadioButtonEmpate.isSelected())? 'x' : '2';
        this.controller.registaAposta(new Aposta(this.apostador,new Float(this.jTextFieldCoins.getText()),
                r,this.evento.getOdd()), this.evento, this.apostador);
        this.dispose();
    }//GEN-LAST:event_jToggleButtonOkActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BetFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BetFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BetFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BetFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BetFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelEq1;
    private javax.swing.JLabel jLabelEq2;
    private javax.swing.JLabel jLabelOddDer;
    private javax.swing.JLabel jLabelOddEmp;
    private javax.swing.JLabel jLabelOddVit;
    private javax.swing.JRadioButton jRadioButtonDerrota;
    private javax.swing.JRadioButton jRadioButtonEmpate;
    private javax.swing.JRadioButton jRadioButtonVitoria;
    private javax.swing.JTextField jTextFieldCoins;
    private javax.swing.JToggleButton jToggleButtonCancel;
    private javax.swing.JToggleButton jToggleButtonOk;
    // End of variables declaration//GEN-END:variables
}
