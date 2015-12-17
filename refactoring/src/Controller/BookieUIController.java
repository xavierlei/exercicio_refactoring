/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.BookieView.BookieUI;
import model.Observer;
import refactoring.BetESSAPI;

/**
 *
 * @author xavier
 */
public class BookieUIController implements Observer {
    private BetESSAPI api;
    private BookieUI view;
    private BookieController me;

    public BookieUIController(BetESSAPI api,BookieController me) {
        this.api = api;
        this.me = me;
        view = new BookieUI();
        this.view.setTextName(me.getNome());
        this.view.setEmailText(me.getEmail());
        view.setVisible(true);
    }
    
    

    @Override
    public void updateObserver(String notificacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
