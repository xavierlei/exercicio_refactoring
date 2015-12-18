/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.ApostadorView.ViewBetsFrame;
import javax.swing.table.DefaultTableModel;
import refactoring.BetESSAPI;

/**
 *
 * @author xavier
 */
public class ViewBetsFrameController implements Controller{
    BetESSAPI api;
    EventoController evento;
    ApostadorController apostador;
    ViewBetsFrame view;
    
    public ViewBetsFrameController(BetESSAPI api,EventoController evento,ApostadorController apostador){
        this.api = api;
        this.evento = evento;
        this.apostador = apostador;
        this.view = new ViewBetsFrame();
        this.view.setVisible(true);
        this.updateView(null);
    }
    
    private String[] buildRow(ApostaController aposta){
        //{"valor","odd","resultado"}
        String [] line = new String[3];
        line[0] = new Float(aposta.getM_aposta()).toString();
        line[1] = aposta.getOdd().toString();
        line[2] = aposta.getResultado().toString();
        return line;
    }
    
    public void updateView(Object o) {
        try{
            DefaultTableModel model = view.setTable();
            for(ApostaController ap : this.api.getApostas(apostador, evento)){
                //if(e.getVisible())
                view.addRow(buildRow(ap), model);
            }
        }catch (Exception e){
        }
    }
}
