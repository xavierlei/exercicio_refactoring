/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;




/**
 *
 * @author xavier
 */
public class Bookie implements Observer, Subject {
    private String nome;
    private String email;
    private Observer observador;
    
    public Bookie(){
        this.nome = "John Doe";
        this.email = "no email";
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
    public void updateObserver(String notificacao) {
        this.notify(null,notificacao);
    }


    @Override
    public void notify(String category, String message) {
        this.observador.updateObserver(message);
    }

    @Override
    public void addObserver(String category, Observer o) {
        this.observador = o;
    }


    
}
