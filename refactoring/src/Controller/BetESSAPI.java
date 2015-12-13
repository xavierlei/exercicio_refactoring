package Controller;


import View.View;
import model.Evento;
import model.Apostador;
import java.time.Instant;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import model.Aposta;
import model.Bookie;
import model.Subject;
import model.Observer;

public class BetESSAPI implements Subject {

	private Vector<Evento> listaEventos;
	private Vector<Apostador> listaApostadores;
        private HashMap<String,Bookie> listaBookies;
	private double betESStotal;
	private String name;
        public ArrayList<Observer> views;
        

	private final BufferedReader in;
	private final PrintStream out;

	public BetESSAPI() {
		this.betESStotal = 0;
		this.listaEventos = new Vector<Evento>();
		this.listaApostadores = new Vector<Apostador>();
                this.listaBookies = new HashMap<String,Bookie>();
                this.views = new ArrayList<Observer>();
		this.name = "BetESSAPI";
		this.in = new BufferedReader(new InputStreamReader(System.in));
		this.out = System.out;
	}

        

	public void registaAposta(Aposta aposta, Evento evento) {
		evento.registaAposta(aposta);
	}

	// Interface sobre Eventos
        public void observarEvento(Evento e,  Observer o, String category){
            e.addObserver(category, o);
        }
        
	public boolean actualizaOdd(Evento evento, float odd_1, float odd_x, float odd_2){
                boolean b  = evento.actualizaOdd(odd_1,odd_x,odd_2);
                this.notify(null,null);
		return b;
                
	}
        

	public boolean  fechaEvento(Evento evento, char resultado){
                boolean b = evento.fechaEvento(resultado);
                this.notify(null,null);
		return b;
	}
        public void apagarEvento(Evento e){
            for(Evento ev : this.listaEventos){
                if(e.getId() == ev.getId()){
                    listaEventos.remove(ev);
                    this.notify(null,null);
                }
            }
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
                this.notify(null,null);
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
        public ArrayList<Aposta> getApostas(Apostador apostador, Evento e){
            ArrayList<Aposta> res = new ArrayList<Aposta>();
                for(Aposta aposta : e.getApostas(apostador))
                    res.add(aposta);
            return res;
        }
        

	// Interface sobre Bookies

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


	// Objects view
	@Override
	public String toString() {
		return "BetESSAPI{" +
				"name=" + name +
				", betESStotal=" + betESStotal +
				'}';
	}

    @Override
    public void notify(String category, String message) {
        for(Observer o : this.views){
            o.updateObserver(null);
        }
    }

    @Override
    public void addObserver(String category, Observer o) {
        if(!this.views.contains(o))
            this.views.add(o);
    }


}