/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ObserverPattern.Observer;
import View.ApostadorView.BetFrame;
import refactoring.BetESSAPI;

/**
 *
 * @author xavier
 */
public class BetFormController implements Observer, Controller {
    BetESSAPI api;
    ApostadorUIController parent;
    ApostadorController apostador;
    EventoController evento;
    BetFrame view;
    
    
    public BetFormController(BetESSAPI api, ApostadorUIController parent
            ,ApostadorController apostador,EventoController evento){
        this.api = api;
        this.parent = parent;
        this.apostador = apostador;
        this.evento = evento;
        this.view = new BetFrame(this);
        this.view.setVisible(true);
    }

    @Override
    public void updateObserver(String notificacao) {
        char resultado = (this.view.getVitoria() == true) ? '1' : (this.view.getEmpate() == true) ? 'x' : '2';
        ApostaController aposta = new ApostaController();
        aposta.setM_aposta(new Float(this.view.getValortext()));
        aposta.setResultado(resultado);
        aposta.setApostador(apostador);
        aposta.setOdd(this.evento.getOdd().clone());
        this.api.registaAposta(aposta, evento, apostador);
        this.view.dispose();
    }

    @Override
    public void updateView(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
}
