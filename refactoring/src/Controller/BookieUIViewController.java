/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.BookieView.BookieUIView;
import ObserverPattern.Observer;
import View.NotificationView;
import javax.swing.table.DefaultTableModel;
import refactoring.BetESSAPI;

/**
 *
 * @author xavier
 */
public class BookieUIViewController implements Controller, Observer {
    private BetESSAPI api;
    private BookieUIView view;
    private BookieController me;

    public BookieUIViewController(BetESSAPI api,BookieController me) {
        this.api = api;
        this.me = me;
        this.api.addObserver("bookies", me);//receber mudanças de estado da api
        this.me.addObserver(null, this);//observer o bookie para receber as suas notificações
        view = new BookieUIView(this);
        this.setViewText();
        view.setVisible(true);
        this.updateView(null);
    }
    
    private void setViewText(){
        this.view.setTextName(me.getNome());
        this.view.setEmailText(me.getEmail());
    }

    private Integer getSelectedEvent(){
        return new Integer(this.view.getTable().getValueAt(this.view.getTable().getSelectedRow(), 0).toString());
    }
    
    private void updateSwitch(String notificacao){
        switch(notificacao){
                case "NEW":
                    NewEventViewController e = new NewEventViewController(api,this,me);
                    break;
                case "UPDATE":
                    if(this.view.getTable().getSelectedRow()>-1){
                        UpdateViewController u = new UpdateViewController(api, this.api.getEvento(this.getSelectedEvent()), this);
                    }
                    break;
                case "END":
                    if(this.view.getTable().getSelectedRow()>-1){
                        EndEventViewController end = new EndEventViewController(api, this, this.api.getEvento(this.getSelectedEvent()));
                    }
                    break;
                case "DELETE":
                    if(this.view.getTable().getSelectedRow()>-1){
                        DeleteViewController dv = new DeleteViewController(api, this, this.api.getEvento(this.getSelectedEvent()));
                    }
                    break;
                case "OBSERVE":
                    if(this.view.getTable().getSelectedRow()>-1){
                        this.api.observarEvento(this.api.getEvento(this.getSelectedEvent()), me, "bookies");
                    }
                    break;
                default:
                    new NotificationView(notificacao).setVisible(true);
                    break;
            }
    }
    
    @Override
    public void updateObserver(String notificacao) {
        if(notificacao != null)
            this.updateSwitch(notificacao);
        this.updateView(null);
    }

    private String[] buildRow(EventoController e){
        String [] res = new String[7];
        res[0] = new Integer(e.getId()).toString();
        res[1] = e.getDono().getNome();
        res[2] = e.getEquipa1();
        res[3] = e.getEquipa2();
        res[4] = e.getDataEvento().toString();
        res[5] = (e.getEstado() == true) ? "ABERTO" : "FECHADO";
        if(e.getResultado()!=null)
            res[6] = e.getResultado().toString();
        else
            res[6] = "-";
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
    
}
