/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.LoginJFrame;
import View.View;
import javax.swing.JFrame;
import model.Observer;
import refactoring.BetESSAPI;

/**
 *
 * @author xavier
 */
public class LoginController implements Observer {
    
    
    private LoginJFrame view;
    private BetESSAPI api;
    
    public LoginController(BetESSAPI api){
        this.api = api;
        this.view = new LoginJFrame();
        this.view.addObserver("login", this);
        this.view.addObserver("register", this);
    }
    
    public void viewlogin(){
        this.view.setVisible(true);
        
    }

    private void login(String tipo){
        if(tipo.equals("LOGINAPOSTADOR")){
            //System.out.println(tipo);
            this.api.loginApostador(view.getNameText());         
        }
        if(tipo.equals("LOGINBOOKIE")){
            //System.out.println(tipo);
            BookieController bookie = this.api.loginBookie(view.getNameText());
             if(bookie!=null){
                 new BookieUIController(api, bookie);
             }
        }
    }
    private void register(String tipo){
        if(tipo.equals("REGISTERAPOSTADOR")){
            //System.out.println(tipo);
            this.api.registaApostador(view.getNameText(), view.getEmailText(), new Double(view.getBetCoinsText()));
        }
        if(tipo.equals("REGISTERBOOKIE")){
            //System.out.println(tipo);
            this.api.registaBookie(view.getNameText(), view.getEmailText());
        }
    }
    
    @Override
    public void updateObserver(String mensagem) {
        if(mensagem.equals("LOGINBOOKIE") || mensagem.equals("LOGINAPOSTADOR")){
            login(mensagem);
        }
        if(mensagem.equals("REGISTERBOOKIE") || mensagem.equals("REGISTERAPOSTADOR")){
            register(mensagem);
        }
    }
}
