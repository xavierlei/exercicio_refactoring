/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ObserverPattern.Observer;
import View.ApostadorView.ApostadorUIView;
import View.NotificationView;
import javax.swing.table.DefaultTableModel;
import refactoring.BetESSAPI;

/**
 *
 * @author xavier
 */
public class ApostadorUIViewController implements Observer, Controller {
    BetESSAPI api;
    ApostadorController me;
    ApostadorUIView view;

    public ApostadorUIViewController(BetESSAPI api, ApostadorController me) {
        this.api = api;
        this.me = me;
        this.me.addObserver(null, this);//observar a classe apostador para receber as suas notificações
        this.api.addObserver(null, this);//receber mudanças de estado da api
        this.view = new ApostadorUIView(this);
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
            this.view.setTextCoins(new Float(this.me.getBetESScoins()).toString());
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
                    if(this.view.getTable().getSelectedRow()>-1){
                        ind = new Integer(this.view.getTable().getValueAt(this.view.getTable().getSelectedRow(), 0).toString());
                        new BetViewController(api, this, me, this.api.getEvento(ind));
                    }
                    break;
                case "OBSERVE":
                    if(this.view.getTable().getSelectedRow()>-1){
                        ind = new Integer(this.view.getTable().getValueAt(this.view.getTable().getSelectedRow(), 0).toString());
                        this.api.observarEvento(this.api.getEvento(ind), me, "apostadores");
                    }
                    break;
                case "VIEWBETS":
                    if(this.view.getTable().getSelectedRow()>-1){
                        ind = new Integer(this.view.getTable().getValueAt(this.view.getTable().getSelectedRow(), 0).toString());
                        new MyBetsViewController(api, this.api.getEvento(ind), this.me);
                    }
                    break;
                default:
                    new NotificationView(notificacao).setVisible(true);
                    break;
            }
        this.updateView(null);
    }
    
    
    
}
