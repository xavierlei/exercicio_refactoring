/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import ObserverPattern.Subject;
import ObserverPattern.Observer;




/**
 *
 * @author xavier
 */
public class Bookie {
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
    
}
