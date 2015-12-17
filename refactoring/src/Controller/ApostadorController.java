/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.View;
import model.Apostador;

/**
 *
 * @author xavier
 */
public class ApostadorController {
    Apostador apostador;
    private View view;

    public ApostadorController() {
        this.apostador = new Apostador();
        //this.view = v;
    }
    
    public String getEmail() {
		return apostador.getEmail();
	}

    public double getBetESScoins() {
		return apostador.getBetESScoins();
	}

    public String getName() {
		return apostador.getName();
	}


    public void setEmail(String email) {
		this.apostador.setEmail(email);
	}

    public void setBetESScoins(double betESScoins) {
		this.apostador.setBetESScoins(betESScoins);
	}

    public void setName(String name) {
		this.apostador.setName(name);
	}
    
}
