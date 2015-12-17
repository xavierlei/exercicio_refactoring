package model;

import ObserverPattern.Subject;
import ObserverPattern.Observer;
import model.Apostador;
import model.Aposta;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.time.Instant;

public class Evento implements Subject {


	private static AtomicInteger uniqueId=new AtomicInteger();

	private String equipa1;
	private String equipa2;
	//private Resultado resultado_final;
	private Date dataEvento;
	private int id;
	//private Vector<Aposta> listaApostas;

	private boolean isOpen;
	//private Odd odds;
        private HashMap<String,ArrayList<Observer>> observers;


	public Evento(String equipa1, String equipa2, Date data) {
		this.equipa1 = equipa1;
		this.equipa2 = equipa2;
		this.isOpen = false;
		//this.resultado_final = null;
		this.dataEvento = data;
		this.id=uniqueId.getAndIncrement();
		//this.odds = new Odd();
		//this.listaApostas = new Vector<Aposta>();

                this.observers = new HashMap<String,ArrayList<Observer>>();
	}

	public Evento() {
		this.equipa1 = null;
		this.equipa2 = null;
		this.isOpen = false;
		//this.resultado_final = null;
		this.dataEvento = null;
		this.id=uniqueId.getAndIncrement();
		//this.odds = new Odd();
		//this.listaApostas = new Vector<Aposta>();

	}

	public void setEquipa1(String equipa1) {
		this.equipa1 = equipa1;
	}
        public String getEquipa1() {
		return this.equipa1;
	}

	public String getEquipa2() {
		return this.equipa2;
	}

	public void setEquipa2(String equipa2) {
		this.equipa2 = equipa2;
	}
       // public Odd getOdd(){return this.odds;}
	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}
        public Date getDataEvento(){
            return this.dataEvento;
        }
        public int getId(){return this.id;}
        public void SetIsOpen(boolean value){
            this.isOpen = value;
        }
        public boolean getIsOpen(){
            return this.isOpen;
        }
        public void setEstado(boolean estado) {
		// TODO - implement Aposta.setEstado
            this.isOpen = estado;

	}
        public boolean getEstado(){return this.isOpen;}
        //public Resultado getResultado(){return this.resultado_final;}
        
        
        /*public void setResultado(char resultado){
            this.resultado_final =  (resultado == '1') ? Resultado.VITORIA : (resultado == '2') 
                    ? Resultado.DERROTA : Resultado.EMPATE;
        }*/
          
	/*public boolean fechaEvento(char resultadofinal){
		this.setResultado(resultadofinal);
		this.isOpen = false;
		this.notifyApostadores();
                this.notify("bookies","O Evento "+this.getId()+" terminou!");
                this.notify("apostadores","O Evento "+this.getId()+" terminou!");
		return true;
	}*/

	/*public void registaAposta(Aposta aposta) {
		this.listaApostas.add(aposta);
	}*/

	/*public boolean actualizaOdd(float odd1, float oddx, float odd2 ){
		this.odds.setOddx(oddx);
		this.odds.setOdd1(odd1);
		this.odds.setOdd2(odd2);
                this.notify("bookies","a odd do evento "+this.getId()+" foi alterada!");
                this.notify("apostadores","a odd do evento "+this.getId()+" foi alterada!");
		return true;
	}*/

	
        
        /*private int premio(Aposta aposta){
            return (this.resultado_final == aposta.getResultado()) ? aposta.getPremio() : 0;
        }*/
        
	/*public void notifyApostadores() {
		if (!this.isOpen){
                    Enumeration<Aposta> lista_apostas = this.listaApostas.elements();
                    while (lista_apostas.hasMoreElements()) {
			Aposta aposta = lista_apostas.nextElement();
			aposta.getApostador().updateObserver("ganhou "+premio(aposta)+" no evento "+this.id);
                        //isto deverá ficar aqui?
                        aposta.getApostador().setBetESScoins(aposta.getApostador().getBetESScoins()+premio(aposta));
                    }
		}
	}*/

	/*public void setOdds(float odd_1, float odd_x, float odd_2) {
		this.odds = new Odd(odd_1,odd_x,odd_2);
	}*/

	/*public void updateOdds(float odd_1, float odd_x, float odd_2){
	    this.odds.setOdd1(odd_1);
		this.odds.setOdd2(odd_2);
		this.odds.setOddx(odd_x);
	}*/

	// views Evento

	
        /*public ArrayList<Aposta> getApostas(Apostador apostador){
            ArrayList<Aposta> res = new ArrayList<Aposta>();
            for(Aposta a : this.listaApostas){
                if(a.getApostador().equals(apostador))
                    res.add(a);
            }
            return res;
        }*/

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