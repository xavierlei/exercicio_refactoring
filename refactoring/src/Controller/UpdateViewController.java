/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ObserverPattern.Observer;
import View.BookieView.UpdateView;
import refactoring.BetESSAPI;

/**
 *
 * @author xavier
 */
public class UpdateViewController implements Observer, Controller {
    BetESSAPI api;
    BookieUIViewController parent;
    EventoController evento;
    UpdateView view;

    public UpdateViewController(BetESSAPI api, EventoController evento,BookieUIViewController parent) {
        this.api = api;
        this.parent = parent;
        this.evento = evento;
        this.view = new UpdateView(this);
        this.initForm();
        this.view.setVisible(true);
    }
    
    private void initForm(){
        this.view.setTextEq1(this.evento.getEquipa1());
        this.view.setTextEq2(this.evento.getEquipa2());
        this.view.setOdd1Text(new Float(this.evento.getOdd().getOdd1()).toString());
        this.view.setOddXText(new Float(this.evento.getOdd().getOddx()).toString());
        this.view.setOdd2Text(new Float(this.evento.getOdd().getOdd2()).toString());
        this.view.setIsOpen(this.evento.getEstado());
    }

    @Override
    public void updateObserver(String notificacao) {
        evento.setEstado(this.view.getIsOpen());
        this.api.actualizaOdd(evento, new Float(this.view.getOdd1Text())
                , new Float(this.view.getOddXText()),new Float(this.view.getOdd2Text()));
        this.updateView(null);
        this.view.dispose();
    }

    @Override
    public void updateView(Object o) {
        this.parent.updateView(o);
    }
    
    
    
}
