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

public class Evento  {


	private static AtomicInteger uniqueId=new AtomicInteger();

	private String equipa1;
	private String equipa2;
	private Date dataEvento;
	private int id;
	private boolean isOpen;



	public Evento(String equipa1, String equipa2, Date data) {
		this.equipa1 = equipa1;
		this.equipa2 = equipa2;
		this.isOpen = false;
		this.dataEvento = data;
		this.id=uniqueId.getAndIncrement();
	}

	public Evento() {
		this.equipa1 = null;
		this.equipa2 = null;
		this.isOpen = false;
		this.dataEvento = null;
		this.id=uniqueId.getAndIncrement();
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
            this.isOpen = estado;

	}
        public boolean getEstado(){return this.isOpen;}

}