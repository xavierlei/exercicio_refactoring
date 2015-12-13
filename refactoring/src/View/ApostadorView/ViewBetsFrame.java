/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.ApostadorView;

import Controller.BetESSAPI;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import model.Aposta;
import model.Apostador;
import model.Evento;
import model.Resultado;

/**
 *
 * @author xavier
 */
public class ViewBetsFrame extends javax.swing.JFrame {
    BetESSAPI controller;
    Evento evento;
    Apostador apostador;
    /**
     * Creates new form ViewBetsFrame
     */
    public ViewBetsFrame() {
        initComponents();
    }
    public ViewBetsFrame(BetESSAPI controller, Evento e, Apostador a) {
        initComponents();
        this.controller = controller;
        this.evento = e;
        this.apostador = a;
        this.jLabelId.setText(new Integer(e.getId()).toString());
        this.jLabelE1.setText(e.getEquipa1());
        this.jLabelE2.setText(e.getEquipa2());
        this.loadTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabelE1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelE2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableApostas = new javax.swing.JTable();
        jToggleButtonClose = new javax.swing.JToggleButton();
        jLabelId = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("evento: ");

        jLabelE1.setText("equipa 1");

        jLabel3.setText("X");

        jLabelE2.setText("equipa 2");

        jTableApostas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableApostas);

        jToggleButtonClose.setText("close");
        jToggleButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonCloseActionPerformed(evt);
            }
        });

        jLabelId.setText("id");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jToggleButtonClose)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelId)
                            .addGap(48, 48, 48)
                            .addComponent(jLabelE1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(jLabelE2))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelE1)
                    .addComponent(jLabel3)
                    .addComponent(jLabelE2)
                    .addComponent(jLabelId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToggleButtonClose))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_jToggleButtonCloseActionPerformed

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
            java.util.logging.Logger.getLogger(ViewBetsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewBetsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewBetsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewBetsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewBetsFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelE1;
    private javax.swing.JLabel jLabelE2;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableApostas;
    private javax.swing.JToggleButton jToggleButtonClose;
    // End of variables declaration//GEN-END:variables


    private void loadTable() {
        ArrayList<Aposta> apostas ;
            try{
                apostas = this.controller.getApostas(apostador, evento);
                DefaultTableModel model = new DefaultTableModel(new String[]{"valor","odd","resultado"}, 0);
                this.jTableApostas.setModel(model);
                this.jTableApostas.setCellSelectionEnabled(false);
                for(Aposta a : apostas)
                {
                    String s;               
                    model.addRow(new String[]{new Float(a.getM_aposta()).toString(),a.getOdd_fixada().toString()
                            ,(a.getResultado() == Resultado.VITORIA)? "vitoria" : ((a.getResultado() == Resultado.EMPATE)? "empate":"derrota")
                    });
                    model.fireTableDataChanged();
                }

            } catch (Exception ex) {
                //new ErrorWindow("Inventário", ex.getMessage(), "error", new JFrame()).wshow();
            }
    }
}
