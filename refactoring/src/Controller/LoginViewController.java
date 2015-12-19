/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.LoginView;
import View.View;
import javax.swing.JFrame;
import ObserverPattern.Observer;
import refactoring.BetESSAPI;

/**
 *
 * @author xavier
 */
public class LoginViewController implements Observer {
    
    
    private LoginView view;
    private BetESSAPI api;
    
    public LoginViewController(BetESSAPI api){
        this.api = api;
        this.view = new LoginView();
        this.view.addObserver("login", this);
        this.view.addObserver("register", this);
    }
    
    public void viewlogin(){
        this.view.setVisible(true);
        
    }

    private void login(String tipo){
        if(tipo.equals("LOGINAPOSTADOR")){
            if(this.api.loginApostador(view.getNameText()) != null){
                new ApostadorUIViewController(api, this.api.loginApostador(view.getNameText()));
            }
        }
        if(tipo.equals("LOGINBOOKIE")){
             if(this.api.loginBookie(view.getNameText())!=null){
                 new BookieUIViewController(api, this.api.loginBookie(view.getNameText()));
             }
        }
    }
    private void register(String tipo){
        if(tipo.equals("REGISTERAPOSTADOR")){
            this.api.registaApostador(view.getNameText(), view.getEmailText(), new Double(view.getBetCoinsText()));
        }
        if(tipo.equals("REGISTERBOOKIE")){
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
