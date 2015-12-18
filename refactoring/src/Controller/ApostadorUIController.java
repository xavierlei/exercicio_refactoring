/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ObserverPattern.Observer;
import View.ApostadorView.ApostadorUI;
import View.NotificationFrame;
import javax.swing.table.DefaultTableModel;
import refactoring.BetESSAPI;

/**
 *
 * @author xavier
 */
public class ApostadorUIController implements Observer, Controller {
    BetESSAPI api;
    ApostadorController me;
    ApostadorUI view;

    public ApostadorUIController(BetESSAPI api, ApostadorController me) {
        this.api = api;
        this.me = me;
        this.me.addObserver(null, this);//observar a classe apostador para receber as suas notificações
        this.api.addObserver(null, this);//receber mudanças de estado da api
        this.view = new ApostadorUI(this);
        this.view.setVisible(true);
        this.view.setTextNome(this.me.getName());
        this.view.setTextMail(this.me.getEmail());
        this.view.setTextCoins(new Double(this.me.getBetESScoins()).toString());
        this.updateView(me);
    }

    private String[] buildRow(EventoController e){
        String [] res = new String[6];
        res[0] = new Integer(e.getId()).toString();
        res[1] = e.getEquipa1();
        res[2] = e.getEquipa2();
        res[3] = e.getDataEvento().toString();
        res[4] = (e.getEstado() == true) ? "ABERTO" : "FECHADO";
        if(e.getResultado()!=null)
            res[5] = e.getResultado().toString();
        return res;
    }
    
    @Override
    public void updateView(Object o) {
        try{
            DefaultTableModel model = view.setTable();
            for(EventoController e : this.api.getEventos()){
                if(e.getVisible())
                    view.addRow(buildRow(e), model);
            }
        }catch (Exception e){
        }
    }

    @Override
    public void updateObserver(String notificacao) {
        int ind;
        if(notificacao != null)
            switch(notificacao){
                case "BET":
                    System.out.println("BET");
                    break;
                case "OBSERVE":
                    ind = new Integer(this.view.getTable().getValueAt(this.view.getTable().getSelectedRow(), 0).toString());
                    //this.api.getEvento(ind).addObserver("apostadores", this);
                    this.api.observarEvento(this.api.getEvento(ind), me, "apostadores");
                    break;
                case "VIEWBETS":
                    System.out.println("VIEWBETS");
                    break;
                default:
                    new NotificationFrame(notificacao).setVisible(true);
                    //this.updateView(null);
                    break;
            }
        this.updateView(null);
    }
    
    
    
}
