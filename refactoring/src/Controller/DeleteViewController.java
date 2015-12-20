/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ObserverPattern.Observer;
import View.BookieView.DeleteView;
import refactoring.BetESSAPI;

/**
 *
 * @author xavier
 */
public class DeleteViewController implements Observer {
    private BetESSAPI api;
    private BookieUIViewController parent;
    private EventoController evento;
    private DeleteView view;
    
    public DeleteViewController(BetESSAPI api, BookieUIViewController parent, EventoController evento){
        this.api = api;
        this.parent = parent;
        this.evento = evento;
        this.view = new DeleteView(this);
        this.view.setVisible(true);
    }

    @Override
    public void updateObserver(String notificacao) {
        this.api.apagarEvento(this.evento);
        this.parent.updateView(api);
        this.view.dispose();
    }
    
}
