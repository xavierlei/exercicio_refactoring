/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ObserverPattern.Observer;
import ObserverPattern.Subject;
import View.View;
import model.Bookie;

/**
 *
 * @author xavier
 */
public class BookieController implements Observer, Subject {
    private Bookie bookie;
    Observer observer;

    public BookieController() {
        this.bookie = new Bookie();
    }
    public String getEmail(){
        return this.bookie.getEmail();
    }
    public String getNome(){
        return this.bookie.getNome();
    }
    public void setEmail(String email){
        this.bookie.setEmail(email);
    }
    public void setNome(String nome){
        this.bookie.setNome(nome);
    }

    @Override
    public void updateObserver(String notificacao) {
        this.observer.updateObserver(notificacao);
    }

    @Override
    public void notify(String channel, String message) {
        this.updateObserver(message);
    }

    @Override
    public void addObserver(String channel, Observer o) {
        this.observer = o;
    }
    
}
