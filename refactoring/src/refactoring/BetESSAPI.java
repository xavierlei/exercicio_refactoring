package refactoring;



import Controller.ApostaController;
import Controller.ApostadorController;
import Controller.BookieController;
import Controller.EventoController;

import java.time.Instant;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import ObserverPattern.Subject;
import ObserverPattern.Observer;


public class BetESSAPI implements Subject {

	private ArrayList<EventoController> listaEventos;
	private ArrayList<ApostadorController> listaApostadores;
        private HashMap<String,BookieController> listaBookies;
	private double betESStotal;
	private String name;
        public ArrayList<Observer> views;
        

	private final BufferedReader in;
	private final PrintStream out;

	public BetESSAPI() {
		this.betESStotal = 0;
		this.listaEventos = new ArrayList<EventoController>();
		this.listaApostadores = new ArrayList<ApostadorController>();
                this.listaBookies = new HashMap<String,BookieController>();
                this.views = new ArrayList<Observer>();
		this.name = "BetESSAPI";
		this.in = new BufferedReader(new InputStreamReader(System.in));
		this.out = System.out;
	}

        

	public void registaAposta(ApostaController aposta, EventoController evento, ApostadorController apostador) {
                if(aposta.getM_aposta()<= apostador.getBetESScoins()){
                    evento.registaAposta(aposta);
                    apostador.setBetESScoins(apostador.getBetESScoins()-aposta.getM_aposta());
                    this.notify("apostadores", null);
                }
                    
	}

	// Interface sobre Eventos
        public void observarEvento(EventoController e,  Observer o, String category){
            e.addObserver(category, o);
        }
        
	public boolean actualizaOdd(EventoController evento, float odd_1, float odd_x, float odd_2){
                boolean b  = evento.actualizaOdd(odd_1,odd_x,odd_2);
                this.notify(null,null);
		return b;
                
	}
        

	public boolean  fechaEvento(EventoController evento, char resultado){
                boolean b = evento.fechaEvento(resultado);
                this.notify(null,null);
		return b;
	}
        public void apagarEvento(EventoController e){
            for(EventoController ev : this.listaEventos){
                if(e.getId() == ev.getId()){
                    ev.setVisible(false);
                    this.notify(null,null);
                }
            }
        }


        public ArrayList<EventoController> getEventos(){
            return this.listaEventos;
        }
        
        public EventoController getEvento(int cod){
            for(EventoController e : this.listaEventos){
                if(e.getId() == cod)
                    return e;
            }
            return null;
        }

	public EventoController registaEvento(String equipa1, String equipa2) {
            EventoController evento = new EventoController();
            evento.setEquipa1(equipa1);
            evento.setEquipa2(equipa2);
            evento.setDataEvento(Date.from(Instant.now()));
            this.listaEventos.add(evento);
            this.notify(null,null);
            return evento;
	}

	// Interface sobre Apostadores
        


	public ApostadorController registaApostador(String nome, String  email, double coins){
		ApostadorController newuser = new ApostadorController();
                newuser.setName(nome);
                newuser.setEmail(email);
                newuser.setBetESScoins(coins);
		listaApostadores.add(newuser);
		return newuser;
	}


        public ApostadorController loginApostador(String name){
            for(ApostadorController a : this.listaApostadores){
                if(a.getName().equals(name))
                    return a;
            }
            return null;
        }




        public ArrayList<ApostaController> getApostas(ApostadorController apostador, EventoController e){
            ArrayList<ApostaController> res = new ArrayList<ApostaController>();
                for(ApostaController aposta : e.getApostas(apostador))
                    res.add(aposta);
            return res;
        }
        

	// Interface sobre Bookies

	public BookieController loginBookie(String nome){
            if(this.listaBookies.containsKey(nome))
                return this.listaBookies.get(nome);
            return null;
        }
        public BookieController registaBookie(String nome, String email){
            if(!this.listaBookies.containsKey(nome)){
                BookieController b = new BookieController();
                b.setNome(nome);
                b.setEmail(email);
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
    public void addObserver(String channel, Observer o) {
        if(!this.views.contains(o))
            this.views.add(o);
    }

    


}