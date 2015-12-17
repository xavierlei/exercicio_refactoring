/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refactoring;

import Controller.LoginController;
import View.LoginJFrame;

/**
 *
 * @author xavier
 */
public class Refactoring {
    public static void main(String args[]){
        BetESSAPI api = new BetESSAPI();
        Povoa.povoaSystem(api);
        LoginController login = new LoginController(api);
        login.viewlogin();
    }
}
