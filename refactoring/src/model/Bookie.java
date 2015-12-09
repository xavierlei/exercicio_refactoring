/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Controller.ControllerObserver;
import View.ModelSubject;


/**
 *
 * @author xavier
 */
public class Bookie implements Observer, ModelSubject {
    private String nome;
    private String email;
    private ControllerObserver c;
    
    public Bookie(){
        this.nome = "John Doe";
        //this.password = "";
    }
    public Bookie(String nome, String email){
        this.nome = nome;
        this.email = email;
    }
    public String getEmail(){return this.email;}
    public String getNome(){return this.nome;}
    public void setEmail(String email){this.email = email;}
    public void setNome(String nome){this.nome = nome;}

    @Override
    public void update(String notificacao) {
        System.out.println(notificacao);
        notifyController(notificacao);
    }

    @Override
    public void notifyController(String message) {
        c.updateToUpperLevel(message);
    }

    @Override
    public void addController(ControllerObserver c) {
        this.c = c;
        System.out.println("adicionou");
    }
    
}
