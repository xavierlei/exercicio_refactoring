/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ObserverPattern.Observer;
import View.BookieView.UpdateFrame;
import refactoring.BetESSAPI;

/**
 *
 * @author xavier
 */
public class UpdateFormController implements Observer, Controller {
    BetESSAPI api;
    BookieUIController parent;
    EventoController evento;
    UpdateFrame view;

    public UpdateFormController(BetESSAPI api, EventoController evento,BookieUIController parent) {
        this.api = api;
        this.parent = parent;
        this.evento = evento;
        this.view = new UpdateFrame(this);
        this.view.setVisible(true);
        this.view.setOdd1Text(new Float(this.evento.getOdd().getOdd1()).toString());
        this.view.setOddXText(new Float(this.evento.getOdd().getOddx()).toString());
        this.view.setOdd2Text(new Float(this.evento.getOdd().getOddx()).toString());
        this.view.setIsOpen(this.evento.getEstado());
    }

    @Override
    public void updateObserver(String notificacao) {
        this.api.actualizaOdd(evento, new Float(this.view.getOdd1Text())
                , new Float(this.view.getOddXText()),new Float(this.view.getOdd2Text()));
        evento.setEstado(this.view.getIsOpen());
        this.updateView(null);
        this.view.dispose();
    }

    @Override
    public void updateView(Object o) {
        this.parent.updateView(o);
    }
    
    
    
}
