/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refactoring;

import Controller.LoginViewController;
import View.LoginView;

/**
 *
 * @author xavier
 */
public class Refactoring {
    public static void main(String args[]){
        BetESSAPI api = new BetESSAPI();
        Povoa.povoaSystem(api);
        LoginViewController login = new LoginViewController(api);
        login.viewlogin();
    }
}
