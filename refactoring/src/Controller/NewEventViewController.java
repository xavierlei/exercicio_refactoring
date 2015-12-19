/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ObserverPattern.Observer;
import View.BookieView.NewEventView;
import javax.swing.JFrame;
import refactoring.BetESSAPI;

/**
 *
 * @author xavier
 */
public class NewEventViewController implements Observer,Controller {
    BookieUIViewController parent;
    NewEventView view;
    BetESSAPI api;
    
    public NewEventViewController(BetESSAPI api, BookieUIViewController parent){
        this.api = api;
        this.parent = parent;
        this.view = new NewEventView(this);
        this.view.setVisible(true);
    }

    @Override
    public void updateObserver(String notificacao) {
        this.api.registaEvento(this.view.getEq1Text(), this.view.getEq2Text()).setOdds(new Float(this.view.getOdd1Text()), new Float(this.view.getOddXText())
                ,new Float(this.view.getOdd2Text()));
        this.updateView(null);
    }

    @Override
    public void updateView(Object o) {
        this.parent.updateView(o);
        this.view.dispose();
    }
}
