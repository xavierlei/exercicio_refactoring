/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ObserverPattern.Observer;
import ObserverPattern.Subject;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import model.Evento;
import model.Resultado;

/**
 *
 * @author xavier
 */
public class EventoController implements Subject {
    private Evento evento;
    private BookieController dono;
    private Resultado resultado_final;
    private ArrayList<ApostaController> listaApostas;
    private OddController odds;
    private HashMap<String,ArrayList<Observer>> observers;
    private boolean visible;
    
    public EventoController(){
        this.visible = true;
        this.evento = new Evento();
        this.listaApostas = new ArrayList<ApostaController>();
        this.observers  = new HashMap<String,ArrayList<Observer>>();
    }
    
    public void setVisible(boolean b){
        this.visible = b;
    }
    public boolean getVisible(){
        return this.visible;
    }
    public BookieController getDono(){
        return this.dono;
    }
    public void setDono(BookieController dono){
        this.dono = dono;
    }
    
    public void setEquipa1(String equipa1) {
		this.evento.setEquipa1(equipa1);
	}
        public String getEquipa1() {
		return this.evento.getEquipa1();
	}

	public String getEquipa2() {
		return this.evento.getEquipa2();
	}

	public void setEquipa2(String equipa2) {
		this.evento.setEquipa2(equipa2);
	}
        public OddController getOdd(){return this.odds;}
	public void setDataEvento(Date dataEvento) {
		this.evento.setDataEvento(dataEvento);
	}
        public Date getDataEvento(){
            return this.evento.getDataEvento();
        }
        public int getId(){
            return this.evento.getId();
        }
        public Resultado getResultado(){
            return this.resultado_final;
        }
        
        
        public void setResultado(char resultado){
            this.resultado_final =  (resultado == '1') ? Resultado.VITORIA : (resultado == '2') 
                    ? Resultado.DERROTA : Resultado.EMPATE;
        }
          
	public boolean fechaEvento(char resultadofinal){
		this.setResultado(resultadofinal);
		this.evento.SetIsOpen(false);
		this.notifyApostadores();
                this.notify("bookies","O Evento "+this.getId()+" terminou!");
                this.notify("apostadores","O Evento "+this.getId()+" terminou!");
		return true;
	}

	public void registaAposta(ApostaController aposta) {
		this.listaApostas.add(aposta);
	}

	public boolean actualizaOdd(float odd1, float oddx, float odd2 ){
		this.odds.setOddx(oddx);
		this.odds.setOdd1(odd1);
		this.odds.setOdd2(odd2);
                this.notify("bookies","a odd do evento "+this.getId()+" foi alterada!");
                this.notify("apostadores","a odd do evento "+this.getId()+" foi alterada!");
		return true;
	}

	public void setEstado(boolean estado) {
            this.evento.SetIsOpen(estado);

	}
        public boolean getEstado(){
            return this.evento.getIsOpen();
        }
        
        private int premio(ApostaController aposta){
            return (this.resultado_final == aposta.getResultado()) ? aposta.getPremio() : 0;
        }
        
	public void notifyApostadores() {
		if (!this.evento.getIsOpen()){                    
                    for(ApostaController aposta : this.listaApostas) {
			aposta.getApostador().updateObserver("ganhou "+premio(aposta)+" no evento "+this.evento.getId());
                        aposta.getApostador().setBetESScoins(aposta.getApostador().getBetESScoins()+premio(aposta));
                    }
		}
	}

	public void setOdds(float odd_1, float odd_x, float odd_2) {
            //this.odds = new Odd(odd_1,odd_x,odd_2);
            this.odds = new OddController();
            this.odds.setOdd1(odd_1);
            this.odds.setOdd2(odd_2);
            this.odds.setOddx(odd_x);
	}

	public void updateOdds(float odd_1, float odd_x, float odd_2){
	    this.odds.setOdd1(odd_1);
            this.odds.setOdd2(odd_2);
            this.odds.setOddx(odd_x);
	}


	
        public ArrayList<ApostaController> getApostas(ApostadorController apostador){
            ArrayList<ApostaController> res = new ArrayList<ApostaController>();
            for(ApostaController a : this.listaApostas){
                if(a.getApostador().equals(apostador))
                    res.add(a);
            }
            return res;
        }

        @Override
        public void notify(String category,String message) {
            if(this.observers.containsKey(category)){
                for(Observer o : this.observers.get(category))
                    o.updateObserver(message);
            }
        }

        @Override
        public void addObserver(String category, ObserverPattern.Observer o) {
            if(this.observers.containsKey(category)){
                this.observers.get(category).add(o);
            }
            else{
                ArrayList<Observer> obs = new ArrayList<Observer>();
                obs.add(o);
                this.observers.put(category, obs);
            }
        }  
}
