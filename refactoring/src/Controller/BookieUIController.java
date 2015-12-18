/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.BookieView.BookieUI;
import ObserverPattern.Observer;
import View.NotificationFrame;
import javax.swing.table.DefaultTableModel;
import refactoring.BetESSAPI;

/**
 *
 * @author xavier
 */
public class BookieUIController implements Controller, Observer {
    private BetESSAPI api;
    private BookieUI view;
    private BookieController me;

    public BookieUIController(BetESSAPI api,BookieController me) {
        this.api = api;
        this.me = me;
        view = new BookieUI(this);
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
        switch(notificacao){
            case "NEW":
                NewEventFormController e = new NewEventFormController(api,this);
                break;
            case "UPDATE":
                //refactor aqui??
                ind = new Integer(this.view.getTable().getValueAt(this.view.getTable().getSelectedRow(), 0).toString());
                ev = this.api.getEvento(ind);
                UpdateFormController u = new UpdateFormController(api, ev, this);
                break;
            case "END":
                ind = new Integer(this.view.getTable().getValueAt(this.view.getTable().getSelectedRow(), 0).toString());
                ev = this.api.getEvento(ind);
                EndEventFrameController end = new EndEventFrameController(api, this, ev);
                break;
            case "DELETE":
                ind = new Integer(this.view.getTable().getValueAt(this.view.getTable().getSelectedRow(), 0).toString());
                this.api.apagarEvento(this.api.getEvento(ind));
                this.updateView(null);
                break;
            case "OBSERVE":
                ind = new Integer(this.view.getTable().getValueAt(this.view.getTable().getSelectedRow(), 0).toString());
                this.api.getEvento(ind).addObserver("bookies", this);
                break;
            default:
                new NotificationFrame(notificacao).setVisible(true);
                break;
        }
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
