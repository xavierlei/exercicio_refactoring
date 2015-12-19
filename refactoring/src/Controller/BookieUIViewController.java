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
        this.view.setTextName(me.getNome());
        this.view.setEmailText(me.getEmail());
        view.setVisible(true);
        this.updateView(null);
    }
    

    @Override
    public void updateObserver(String notificacao) {
        //fazer um refactor neste método
        Integer ind;
        EventoController ev;
        if(notificacao != null)
            switch(notificacao){
                case "NEW":
                    NewEventViewController e = new NewEventViewController(api,this);
                    break;
                case "UPDATE":
                    if(this.view.getTable().getSelectedRow()>-1){
                        ind = new Integer(this.view.getTable().getValueAt(this.view.getTable().getSelectedRow(), 0).toString());
                        ev = this.api.getEvento(ind);
                        UpdateViewController u = new UpdateViewController(api, ev, this);
                    }
                    break;
                case "END":
                    if(this.view.getTable().getSelectedRow()>-1){
                        ind = new Integer(this.view.getTable().getValueAt(this.view.getTable().getSelectedRow(), 0).toString());
                        ev = this.api.getEvento(ind);
                        EndEventViewController end = new EndEventViewController(api, this, ev);
                    }
                    break;
                case "DELETE":
                    if(this.view.getTable().getSelectedRow()>-1){
                        ind = new Integer(this.view.getTable().getValueAt(this.view.getTable().getSelectedRow(), 0).toString());
                        this.api.apagarEvento(this.api.getEvento(ind));
                        //this.updateView(null);
                    }
                    break;
                case "OBSERVE":
                    if(this.view.getTable().getSelectedRow()>-1){
                        ind = new Integer(this.view.getTable().getValueAt(this.view.getTable().getSelectedRow(), 0).toString());
                        this.api.observarEvento(this.api.getEvento(ind), me, "bookies");
                    }
                    break;
                default:
                    new NotificationView(notificacao).setVisible(true);
                    break;
            }
        this.updateView(null);
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
    
}
