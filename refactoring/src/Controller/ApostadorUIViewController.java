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
    private BetESSAPI api;
    private ApostadorController me;
    private ApostadorUIView view;

    public ApostadorUIViewController(BetESSAPI api, ApostadorController me) {
        this.api = api;
        this.me = me;
        this.me.addObserver(null, this);//observar a classe apostador para receber as suas notificações
        this.api.addObserver(null, this);//receber mudanças de estado da api
        this.view = new ApostadorUIView(this);
        this.view.setVisible(true);
        this.updateView(null);
    }
    
    private void setUIText(){
        this.view.setTextNome(this.me.getName());
        this.view.setTextMail(this.me.getEmail());
        this.view.setTextCoins(new Double(this.me.getBetESScoins()).toString());
    }

    private String[] buildRow(EventoController e){
        String [] res = new String[6];
        res[0] = new Integer(e.getId()).toString();
        res[1] = e.getDono().getNome();
        res[2] = e.getEquipa1();
        res[3] = e.getEquipa2();
        res[4] = e.getDataEvento().toString();
        res[5] = (e.getEstado() == true) ? "ABERTO" : "FECHADO";
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
    
    private Integer getSelectedEvent(){
        return new Integer(this.view.getTable().getValueAt(this.view.getTable().getSelectedRow(), 0).toString());
    }
    
    private void updateSwitch(String notificacao){
        switch(notificacao){
                case "BET":
                    if(this.view.getTable().getSelectedRow()>-1){
                        new BetViewController(api, this, me, this.api.getEvento(getSelectedEvent()));
                    }
                    break;
                case "OBSERVE":
                    if(this.view.getTable().getSelectedRow()>-1){
                        this.api.observarEvento(this.api.getEvento(getSelectedEvent()), me, "apostadores");
                    }
                    break;
                case "VIEWBETS":
                    if(this.view.getTable().getSelectedRow()>-1){
                        new MyBetsViewController(api, this.api.getEvento(getSelectedEvent()), this.me);
                    }
                    break;
                default:
                    new NotificationView(notificacao).setVisible(true);
                    break;
            }
    }

    @Override
    public void updateObserver(String notificacao) {
        int ind;
        if(notificacao != null)
            this.updateSwitch(notificacao);
        this.updateView(null);
    }
    
    
    
}
