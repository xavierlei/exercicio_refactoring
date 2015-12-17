/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.View;
import model.Bookie;

/**
 *
 * @author xavier
 */
public class BookieController {
    private Bookie bookie;
    private View view;

    public BookieController() {
        this.bookie = new Bookie();
        //this.view = v;
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
    
}
