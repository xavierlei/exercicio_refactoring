package Controller;


import model.Evento;
import model.Apostador;
import java.time.Instant;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import model.Bookie;
import model.Subject;
import model.Observer;

public class BetESSAPI implements Subject {

	private Vector<Evento> listaEventos;
	private Vector<Apostador> listaApostadores;
        private HashMap<String,Bookie> listaBookies;
	private double betESStotal;
	private String name;
        private ArrayList<Observer> observersApostadores;
        private ArrayList<Observer> observersUI;
        

	private final BufferedReader in;
	private final PrintStream out;

	public BetESSAPI() {
		this.betESStotal = 0;
		this.listaEventos = new Vector<Evento>();
		this.listaApostadores = new Vector<Apostador>();
                this.listaBookies = new HashMap<String,Bookie>();
		this.name = "BetESSAPI";
		this.in = new BufferedReader(new InputStreamReader(System.in));
		this.out = System.out;
                this.observersUI = new ArrayList<Observer>();
                this.observersApostadores = new ArrayList<Observer>();
	}
        //interface sobre bookies
        public Bookie loginBookie(String nome){
            if(this.listaBookies.containsKey(nome))
                return this.listaBookies.get(nome);
            return null;
        }
        public Bookie registaBookie(String nome, String email){
            if(!this.listaBookies.containsKey(nome)){
                Bookie b = new Bookie(nome,email);
                this.listaBookies.put(nome, b);
                return b;
            }
            return null;
        }

	public void registaAposta(Apostador apostador, Evento evento) {
		evento.registaAposta(apostador);
	}

	// Interface sobre Eventos

	public boolean actualizaOdd(Evento evento, float odd_1, float odd_x, float odd_2){
                boolean b  = evento.actualizaOdd(odd_1,odd_x,odd_2);
                this.notifyUI();
		return b;
                
	}

	public boolean  fechaEvento(Evento evento, char resultado){
		return evento.fechaEvento(resultado);
	}

	public void viewEventos(){

		ListIterator<Evento> listIterator = this.listaEventos.listIterator();
		while (listIterator.hasNext()) {
			System.out.println(listIterator.next().viewEvento());
		}
	}
        public Vector<Evento> getEventos(){return this.listaEventos;}

	public Evento registaEvento(String equipa1, String equipa2) {

		Evento aposta = new Evento(equipa1,equipa2, Date.from(Instant.now()));
		this.listaEventos.add(aposta);
                this.notifyUI();
		return aposta;
	}

	public Evento registaEvento() {


		Evento newevento = new Evento();

		newevento.viewCreateEvento();
		this.listaEventos.add(newevento);
		return newevento;
	}

	// Interface sobre Apostadores
        

	public void viewApostadores(){

		ListIterator<Apostador> lista = this.listaApostadores.listIterator();
		while(lista.hasNext()){
			System.out.println(lista.next());
		}
	}

	public Apostador registaApostador(String nome, String  email, double coins){

		Apostador newuser = new Apostador(nome, email, coins);
		listaApostadores.add(newuser);
		return newuser;
	}

	public Apostador registaApostador() {


		Apostador newuser = new Apostador();
		newuser.viewCreateApostador();
		this.listaApostadores.add(newuser);


		return newuser;
	}
        public Apostador loginApostador(String name){
            for(Apostador a : this.listaApostadores){
                if(a.getName().equals(name))
                    return a;
            }
            return null;
        }

	public Apostador actualizaApostador(Apostador apostador) {


		apostador.viewUpdateApostadpr(apostador);


		return apostador;
	}

	public boolean deleteApostador(Apostador apostador){
		apostador.viewDeleteApostador();
		return this.listaApostadores.remove(apostador);

	}

	// Interface sobre Bookies

	// TO-DO

	// Objects view
	@Override
	public String toString() {
		return "BetESSAPI{" +
				"name=" + name +
				", betESStotal=" + betESStotal +
				'}';
	}

    @Override
    public void notifyApostadores() {
        for(Observer e : this.observersApostadores)
            e.update(null);
    }
    
    public void addObserverApostador(Observer obs){
        this.observersApostadores.add(obs);
    }
    public void addObserverUI(Observer obs){
        this.observersUI.add(obs);
    }
    public void notifyUI() {
        for(Observer e : this.observersUI)
            e.update(null);
    }


}