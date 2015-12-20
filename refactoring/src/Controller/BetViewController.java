/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ObserverPattern.Observer;
import View.ApostadorView.BetView;
import refactoring.BetESSAPI;

/**
 *
 * @author xavier
 */
public class BetViewController implements Observer, Controller {
    BetESSAPI api;
    ApostadorUIViewController parent;
    ApostadorController apostador;
    EventoController evento;
    BetView view;
    
    
    public BetViewController(BetESSAPI api, ApostadorUIViewController parent
            ,ApostadorController apostador,EventoController evento){
        this.api = api;
        this.parent = parent;
        this.apostador = apostador;
        this.evento = evento;
        this.view = new BetView(this);
        this.setUIText();
        this.view.setVisible(true);
    }
    
    private void setUIText(){
        this.view.setEq1Text(this.evento.getEquipa1());
        this.view.setEq2Text(this.evento.getEquipa2());
        this.view.setOdd1Text(new Float(this.evento.getOdd().getOdd1()).toString());
        this.view.setOddXText(new Float(this.evento.getOdd().getOddx()).toString());
        this.view.setOdd2Text(new Float(this.evento.getOdd().getOdd2()).toString());
    }
    
    private ApostaController criaAposta(){
        ApostaController aposta = new ApostaController();
        aposta.setM_aposta(new Float(this.view.getValortext()));
        aposta.setResultado((this.view.getVitoria() == true) ? '1' : (this.view.getEmpate() == true) ? 'x' : '2');
        aposta.setApostador(apostador);
        aposta.setOdd(this.evento.getOdd().clone());
        return aposta;
    }

    @Override
    public void updateObserver(String notificacao) {
        this.api.registaAposta(criaAposta(), evento, apostador);
        this.view.dispose();
    }

    @Override
    public void updateView(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
}
