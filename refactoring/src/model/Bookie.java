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
public class Bookie {
    private String nome;
    private String password;
    
    public Bookie(){
        this.nome = "John Doe";
        this.password = "";
    }
    public Bookie(String nome,String passowrd){
        this.nome = nome;
        this.password = password;
    }
    public String getPassword(){return this.password;}
    public String getNome(){return this.getNome();}
    public void setPassword(String password){this.password = password;}
    public void setNome(String nome){this.nome = nome;}
}
