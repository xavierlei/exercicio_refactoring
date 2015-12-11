package model;

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
	private Resultado resultado_final;
	private Date dataEvento;
	private int id;
	private Vector<Aposta> listaApostas;
	private final BufferedReader in;
	private final PrintStream out;
	private boolean isOpen;
	private Odd odds;
        private HashMap<String,ArrayList<Observer>> observers;


	public Evento(String equipa1, String equipa2, Date data) {
		this.equipa1 = equipa1;
		this.equipa2 = equipa2;
		this.isOpen = false;
		this.resultado_final = null;
		this.dataEvento = data;
		this.id=uniqueId.getAndIncrement();
		this.odds = new Odd();
		this.listaApostas = new Vector<Aposta>();

                this.observers = new HashMap<String,ArrayList<Observer>>();
		this.in = new BufferedReader(new InputStreamReader(System.in));
		this.out = System.out;
	}

	public Evento() {
		this.equipa1 = null;
		this.equipa2 = null;
		this.isOpen = false;
		this.resultado_final = null;
		this.dataEvento = null;
		this.id=uniqueId.getAndIncrement();
		this.odds = new Odd();
		this.listaApostas = new Vector<Aposta>();

		this.in = new BufferedReader(new InputStreamReader(System.in));
		this.out = System.out;
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
        public Odd getOdd(){return this.odds;}
	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}
        public Date getDataEvento(){
            return this.dataEvento;
        }
        public int getId(){return this.id;}

        public void setResultado(char resultado){
            switch (resultado) {
		case '1':
                    this.resultado_final = Resultado.VITORIA;
                    break;
		case 'x':
                    this.resultado_final = Resultado.EMPATE;
                    break;
		case '2':
                    this.resultado_final = Resultado.DERROTA;
                    break;
            }
        }
        public Resultado getResultado(){return this.resultado_final;}
        
	public boolean fechaEvento(char resultadofinal){
		this.setResultado(resultadofinal);
		this.isOpen = false;
		this.notifyApostadores();
                this.notify("bookies","O Evento "+this.getId()+" terminou!");
		return true;
	}

	public void registaAposta(Aposta aposta) {
		this.listaApostas.add(aposta);
	}

	public boolean actualizaOdd(float odd1, float oddx, float odd2 ){
		this.odds.setOddx(oddx);
		this.odds.setOdd1(odd1);
		this.odds.setOdd2(odd2);
                this.notify("bookies","a odd do evento "+this.getId()+" foi alterada!");
		return true;
	}

	public void setEstado(boolean estado) {
		// TODO - implement Aposta.setEstado
            this.isOpen = estado;

	}
        public boolean getEstado(){return this.isOpen;}
        private int premio(Aposta aposta){
            if (this.resultado_final == aposta.getResultado()) {
                return aposta.getPremio();
            }
            return 0;
        }
	public void notifyApostadores() {
		if (!this.isOpen){
                    Enumeration<Aposta> lista_apostas = this.listaApostas.elements();
                    while (lista_apostas.hasMoreElements()) {
			Aposta aposta = lista_apostas.nextElement();
			aposta.getApostador().updateObserver(premio(aposta)+"");
                    }
		}
	}

	public void setOdds(float odd_1, float odd_x, float odd_2) {
		this.odds = new Odd(odd_1,odd_x,odd_2);
	}

	public void updateOdds(float odd_1, float odd_x, float odd_2){
	    this.odds.setOdd1(odd_1);
		this.odds.setOdd2(odd_2);
		this.odds.setOddx(odd_x);
	}

	// views Evento

	public String viewEvento() {
		return "Evento{" +
				"equipa1='" + equipa1 + '\'' +
				", equipa2='" + equipa2 + '\'' +
				", resultado_final=" + resultado_final +
				", estado=" + isOpen +
				", data da aposta" + dataEvento.toString() +
				", ultima odd" + this.odds.toString() +
				'}';
	}

	public void viewCreateEvento(){

		String readinput;
		this.out.print("Introduza as equipas participantes no evento: (Equipa1, Equipa2, DataEvento)\n");
		try {
			readinput = this.in.readLine();
			String[] tokens = readinput.split(",");
			this.setEquipa2(tokens[1]);
			this.setEquipa1(tokens[0]);
			this.setDataEvento(Date.from(Instant.now()));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void viewUpdateEvento(){
		String readinput;
		this.out.print("Introduza as equipas participantes no evento: (Equipa1, Equipa2, DataEvento)\n");
		try {
			readinput = this.in.readLine();
			String[] tokens = readinput.split(",");
			this.setEquipa2(tokens[1]);
			this.setEquipa1(tokens[0]);
			this.setDataEvento(Date.from(Instant.now()));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void viewDeleteApostador(){
		this.out.println("Remover Apostador" + this.viewEvento());

	}

    @Override
    public void notify(String category,String message) {
        if(this.observers.containsKey(category)){
            for(Observer o : this.observers.get(category))
                o.updateObserver(message);
        }
    }

    @Override
    public void addObserver(String category, model.Observer o) {
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