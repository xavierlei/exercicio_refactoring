/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.BookieView;

import Controller.BookieUIViewController;
import View.NotificationView;
import refactoring.BetESSAPI;
import View.LoginView;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import model.Bookie;
import model.Evento;
import ObserverPattern.Observer;
import model.Resultado;
import ObserverPattern.Subject;
import javax.swing.JTable;

/**
 *
 * @author xavier
 */
public class BookieUIView extends javax.swing.JFrame implements Subject  {
    
    private Observer controller;


    /**
     * Creates new form BookieUI
     */
    public BookieUIView() {
        initComponents();
    }
    
    public BookieUIView(BookieUIViewController controller) {
        initComponents();
        this.controller = controller;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNome = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEventos = new javax.swing.JTable();
        jToggleButtonNew = new javax.swing.JToggleButton();
        jToggleButtonUpdate = new javax.swing.JToggleButton();
        jToggleButtonEnd = new javax.swing.JToggleButton();
        jToggleButtonDelete = new javax.swing.JToggleButton();
        jToggleButtonObserve = new javax.swing.JToggleButton();
        exitBT = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelNome.setText("jLabel1");

        jLabelEmail.setText("jLabel1");

        jTableEventos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "equipa 1", "equipa 2", "data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableEventos);

        jToggleButtonNew.setText("new");
        jToggleButtonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonNewActionPerformed(evt);
            }
        });

        jToggleButtonUpdate.setText("update");
        jToggleButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonUpdateActionPerformed(evt);
            }
        });

        jToggleButtonEnd.setText("end");
        jToggleButtonEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonEndActionPerformed(evt);
            }
        });

        jToggleButtonDelete.setText("delete");
        jToggleButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonDeleteActionPerformed(evt);
            }
        });

        jToggleButtonObserve.setText("observe");
        jToggleButtonObserve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonObserveActionPerformed(evt);
            }
        });

        exitBT.setText("exit");
        exitBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToggleButtonObserve)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButtonEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButtonUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButtonNew)
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitBT)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelEmail)
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jToggleButtonNew)
                        .addComponent(jToggleButtonUpdate)
                        .addComponent(jToggleButtonEnd)
                        .addComponent(jToggleButtonDelete)
                        .addComponent(jToggleButtonObserve)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(exitBT)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButtonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonNewActionPerformed
        notify(null,"NEW");
    }//GEN-LAST:event_jToggleButtonNewActionPerformed

    private void jToggleButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonUpdateActionPerformed
        notify(null,"UPDATE");
    }//GEN-LAST:event_jToggleButtonUpdateActionPerformed

    private void jToggleButtonEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonEndActionPerformed
        notify(null,"END");
    }//GEN-LAST:event_jToggleButtonEndActionPerformed

    private void jToggleButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonDeleteActionPerformed
        notify(null,"DELETE");
    }//GEN-LAST:event_jToggleButtonDeleteActionPerformed

    private void exitBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBTActionPerformed
        //new LoginView(this.controller).setVisible(rootPaneCheckingEnabled);
        this.dispose();
    }//GEN-LAST:event_exitBTActionPerformed

    private void jToggleButtonObserveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonObserveActionPerformed
        notify(null, "OBSERVE");
    }//GEN-LAST:event_jToggleButtonObserveActionPerformed

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
            java.util.logging.Logger.getLogger(BookieUIView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookieUIView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookieUIView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookieUIView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookieUIView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton exitBT;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEventos;
    private javax.swing.JToggleButton jToggleButtonDelete;
    private javax.swing.JToggleButton jToggleButtonEnd;
    private javax.swing.JToggleButton jToggleButtonNew;
    private javax.swing.JToggleButton jToggleButtonObserve;
    private javax.swing.JToggleButton jToggleButtonUpdate;
    // End of variables declaration//GEN-END:variables


    @Override
    public void notify(String channel, String message) {
        this.controller.updateObserver(message);
    }

    @Override
    public void addObserver(String channel, Observer o) {
        this.controller = o;
    }

    public void setTextName(String name){
        this.jLabelNome.setText(name);
    }
    public void setEmailText(String mail){
        this.jLabelEmail.setText(mail);
    }
    public JTable getTable(){
        return this.jTableEventos;
    }

    public void addRow(String[] row, DefaultTableModel model){
        model.addRow(row);
        model.fireTableDataChanged();
    }
    public DefaultTableModel setTable(){
        DefaultTableModel model = new DefaultTableModel(new String[]{"id","equipa 1","equipa 2","data","estado","resultado"}, 0);
        this.jTableEventos.setModel(model);
        this.jTableEventos.setCellSelectionEnabled(false);
        return model;
    }
   
}

