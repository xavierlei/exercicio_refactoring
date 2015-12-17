/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.ApostadorView;

import Controller.BetESSAPI;
import View.LoginJFrame;
import View.NotificationFrame;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import model.Apostador;
import model.Evento;
import model.Observer;

/**
 *
 * @author xavier
 */
public class ApostadorUI extends javax.swing.JFrame implements Observer {
    
    private BetESSAPI controller;
    private Apostador me;
    /**
     * Creates new form ApostadorUI
     */
    public ApostadorUI() {
        initComponents();
    }
    public ApostadorUI(BetESSAPI controller, Apostador a) {
        initComponents();
        this.controller = controller;
        this.me = a;
        this.controller.addObserver("apostadores",this);
        this.me.addObserver(null, this);
        this.jLabelNome.setText(this.me.getName());
        this.jLabelMail.setText((this.me.getEmail()));
        this.jLabelCoins.setText(this.me.getBetESScoins()+" betEssCoins");
        this.updateObserver(null);
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
        jLabelMail = new javax.swing.JLabel();
        jLabelCoins = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEventos = new javax.swing.JTable();
        jButtonBet = new javax.swing.JButton();
        jToggleButtonObserve = new javax.swing.JToggleButton();
        jToggleButtonExit = new javax.swing.JToggleButton();
        jButtonViewBets = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelNome.setText("nome");

        jLabelMail.setText("email");

        jLabelCoins.setText("coins");

        jTableEventos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableEventos);

        jButtonBet.setText("bet");
        jButtonBet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBetActionPerformed(evt);
            }
        });

        jToggleButtonObserve.setText("observe");
        jToggleButtonObserve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonObserveActionPerformed(evt);
            }
        });

        jToggleButtonExit.setText("exit");
        jToggleButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonExitActionPerformed(evt);
            }
        });

        jButtonViewBets.setText("view bets");
        jButtonViewBets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewBetsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)
                        .addComponent(jLabelCoins)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelMail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonViewBets)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButtonObserve, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBet)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jToggleButtonExit))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNome)
                    .addComponent(jLabelCoins))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMail)
                    .addComponent(jButtonBet)
                    .addComponent(jToggleButtonObserve)
                    .addComponent(jButtonViewBets))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButtonExit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBetActionPerformed
        if(this.jTableEventos.getSelectedRow()>-1){
            new BetFrame(this.controller,me,this.controller.getEventos().get(this.jTableEventos.getSelectedRow())).setVisible(rootPaneCheckingEnabled);
        }
    }//GEN-LAST:event_jButtonBetActionPerformed

    private void jToggleButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_jToggleButtonExitActionPerformed

    private void jToggleButtonObserveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonObserveActionPerformed
        if(this.jTableEventos.getSelectedRow()>-1){
            Evento e = this.controller.getEventos().get(this.jTableEventos.getSelectedRow());
            this.controller.observarEvento(e, me,"apostadores");
            NotificationFrame n = new NotificationFrame("Está agora a observar o evento "+e.getId()+"!");
            n.setVisible(rootPaneCheckingEnabled);
        }
    }//GEN-LAST:event_jToggleButtonObserveActionPerformed

    private void jButtonViewBetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewBetsActionPerformed
        if(this.jTableEventos.getSelectedRow()>-1){
            new ViewBetsFrame(this.controller,this.controller.getEventos().get(this.jTableEventos.getSelectedRow()),me).setVisible(rootPaneCheckingEnabled);
        }
    }//GEN-LAST:event_jButtonViewBetsActionPerformed

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
            java.util.logging.Logger.getLogger(ApostadorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApostadorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApostadorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApostadorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApostadorUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBet;
    private javax.swing.JButton jButtonViewBets;
    private javax.swing.JLabel jLabelCoins;
    private javax.swing.JLabel jLabelMail;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEventos;
    private javax.swing.JToggleButton jToggleButtonExit;
    private javax.swing.JToggleButton jToggleButtonObserve;
    // End of variables declaration//GEN-END:variables

    
    
    public void loadTable(Evento e, DefaultTableModel model){
        model.addRow(new String[]{new Integer(e.getId()).toString(),e.getEquipa1(),
                        e.getEquipa2(),e.getDataEvento().toString(),
                        (e.getEstado()) ? "aberto" : "fechado",(e.getResultado()!=null) ? e.getResultado().toString() : ""});
        model.fireTableDataChanged();
    }
    public DefaultTableModel setTable(){
        DefaultTableModel model = new DefaultTableModel(new String[]{"id","equipa 1","equipa 2","data","estado","resultado"}, 0);
        this.jTableEventos.setModel(model);
        this.jTableEventos.setCellSelectionEnabled(false);
        return model;
    }
    @Override
    public void updateObserver(String notificacao) {
        if(notificacao!=null){
            new NotificationFrame(notificacao).setVisible(rootPaneCheckingEnabled);
        }
        try{
                this.jLabelCoins.setText(this.me.getBetESScoins()+" betEssCoins");
                DefaultTableModel model = setTable();
                for(Evento e : this.controller.getEventos())
                {               
                    loadTable(e,model);
                }
            } catch (Exception ex) {
                //do nothing
            }
    }
    
}