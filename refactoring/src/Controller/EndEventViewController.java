/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ObserverPattern.Observer;
import View.BookieView.EndEventView;
import refactoring.BetESSAPI;

/**
 *
 * @author xavier
 */
public class EndEventViewController implements Observer, Controller {
    private BetESSAPI api;
    private BookieUIViewController parent;
    private EventoController evento;
    private EndEventView view;
    
    public EndEventViewController(BetESSAPI api, BookieUIViewController parent, EventoController evento){
        this.api = api;
        this.parent = parent;
        this.evento = evento;
        this.view = new EndEventView(this);
        this.view.setVisible(true);
        this.view.addObserver(null, this);
    }

    @Override
    public void updateObserver(String notificacao) {
        this.api.fechaEvento(this.evento, (this.view.getVitoria() == true) ? 
                '1' : (this.view.getEmpate() == true) ? 'x' : '2');
        this.updateView(null);
        this.view.dispose();
    }

    @Override
    public void updateView(Object o) {
        this.parent.updateView(o);
    }
    
}
