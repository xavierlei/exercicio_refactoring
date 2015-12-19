/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.ApostadorView.MyBetsView;
import javax.swing.table.DefaultTableModel;
import refactoring.BetESSAPI;

/**
 *
 * @author xavier
 */
public class MyBetsViewController implements Controller{
    BetESSAPI api;
    EventoController evento;
    ApostadorController apostador;
    MyBetsView view;
    
    public MyBetsViewController(BetESSAPI api,EventoController evento,ApostadorController apostador){
        this.api = api;
        this.evento = evento;
        this.apostador = apostador;
        this.view = new MyBetsView();
        this.view.setVisible(true);
        this.updateView(null);
    }
    
    private String[] buildRow(ApostaController aposta){
        String [] line = new String[3];
        line[0] = new Float(aposta.getM_aposta()).toString();
        line[1] = aposta.getOdd().toString();
        line[2] = aposta.getResultado().toString();
        return line;
    }
    
    public void updateView(Object o) {
        try{
            this.view.setTextEq1(this.evento.getEquipa1());
            this.view.setTextEq2(this.evento.getEquipa2());
            this.view.setTextId(new Integer(this.evento.getId()).toString());
            DefaultTableModel model = view.setTable();
            for(ApostaController ap : this.api.getApostas(apostador, evento)){
                view.addRow(buildRow(ap), model);
            }
        }catch (Exception e){
        }
    }
}
