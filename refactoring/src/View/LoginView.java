/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import refactoring.BetESSAPI;
import View.ApostadorView.ApostadorUIView;
import View.BookieView.BookieUIView;
import View.BookieView.BookieUIView;
import model.Apostador;
import model.Bookie;
import ObserverPattern.Observer;
import ObserverPattern.Subject;
import refactoring.Povoa;

/**
 *
 * @author xavier
 */
public class LoginView extends javax.swing.JFrame implements View, Subject {
    Observer channelLogin;
    Observer channelRegister;
    

    /**
     * Creates new form LoginJFrame
     */
    public LoginView() {
        initComponents();
    }
    public LoginView(Observer login, Observer register) {
        initComponents();
        channelLogin = login;
        channelRegister = register;
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        jTextFieldName = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jRadioButtonBookie = new javax.swing.JRadioButton();
        jRadioButtonApostador = new javax.swing.JRadioButton();
        jToggleButtonRegister = new javax.swing.JToggleButton();
        jTextFieldCoins = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("login");

        jLabel1.setText("Name:");

        jLabel2.setText("email:");

        loginButton.setText("login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        jRadioButtonBookie.setText("Bookie");
        jRadioButtonBookie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonBookieActionPerformed(evt);
            }
        });

        jRadioButtonApostador.setSelected(true);
        jRadioButtonApostador.setText("Apostador");
        jRadioButtonApostador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonApostadorActionPerformed(evt);
            }
        });

        jToggleButtonRegister.setText("Register");
        jToggleButtonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonRegisterActionPerformed(evt);
            }
        });

        jTextFieldCoins.setToolTipText("");

        jLabel3.setText("coins:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jRadioButtonApostador)
                                .addComponent(jRadioButtonBookie))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(loginButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jToggleButtonRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(2, 2, 2)))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldCoins)
                            .addComponent(jTextFieldName, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(jTextFieldEmail))))
                .addContainerGap(158, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCoins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jRadioButtonApostador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonBookie)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginButton)
                    .addComponent(jToggleButtonRegister))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        if(this.jRadioButtonApostador.isSelected())
            this.notify("login", "LOGINAPOSTADOR");
        else
            this.notify("login","LOGINBOOKIE");
    }//GEN-LAST:event_loginButtonActionPerformed

    private void jRadioButtonBookieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonBookieActionPerformed
        // TODO add your handling code here:
        this.jRadioButtonApostador.setSelected(false);
        this.jTextFieldCoins.setVisible(false);
    }//GEN-LAST:event_jRadioButtonBookieActionPerformed

    private void jRadioButtonApostadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonApostadorActionPerformed
        // TODO add your handling code here:
        this.jRadioButtonBookie.setSelected(false);
        this.jTextFieldCoins.setVisible(true);
    }//GEN-LAST:event_jRadioButtonApostadorActionPerformed

    private void jToggleButtonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonRegisterActionPerformed
        if(this.jRadioButtonApostador.isSelected())
            this.notify("register", "REGISTERAPOSTADOR");
        else
            this.notify("register","REGISTERBOOKIE");
    }//GEN-LAST:event_jToggleButtonRegisterActionPerformed

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
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButtonApostador;
    private javax.swing.JRadioButton jRadioButtonBookie;
    private javax.swing.JTextField jTextFieldCoins;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JToggleButton jToggleButtonRegister;
    private javax.swing.JButton loginButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateView(Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notify(String channel, String message) {
        if(channel.equals("login")){
            if(message.equals("LOGINBOOKIE"))
                this.channelLogin.updateObserver("LOGINBOOKIE");
            if(message.equals("LOGINAPOSTADOR"))
                this.channelLogin.updateObserver("LOGINAPOSTADOR");
            
        }
        if(channel.equals("register")){
            if(message.equals("REGISTERBOOKIE"))
                this.channelLogin.updateObserver("REGISTERBOOKIE");
            if(message.equals("REGISTERAPOSTADOR"))
                this.channelLogin.updateObserver("REGISTERAPOSTADOR");
        }      
    }

    @Override
    public void addObserver(String channel, Observer o) {
        if(channel.equals("login"))
            this.channelLogin = o;
        if(channel.equals("register"))
            this.channelRegister = o;
    }
    
    public String getNameText(){
        return this.jTextFieldName.getText();
    }
    public String getEmailText(){
        return this.jTextFieldEmail.getText();
    }
    public String getBetCoinsText(){
        return this.jTextFieldCoins.getText();
    }
}