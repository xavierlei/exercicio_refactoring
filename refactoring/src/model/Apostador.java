package model;

import ObserverPattern.Subject;
import ObserverPattern.Observer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;


public class Apostador {

	private String email;
	private double betESScoins;
	private String name;


	public Apostador(String name, String email, double betESScoins) {
		this.email = email;
		this.name = name;
                this.betESScoins = betESScoins;

	}

	public Apostador() {
		this.email = "";
                this.betESScoins = 0.0;
                this.name = "";
	}

	public String getEmail() {
		return email;
	}

	public double getBetESScoins() {
		return betESScoins;
	}

	public String getName() {
		return name;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public void setBetESScoins(double betESScoins) {
		this.betESScoins = betESScoins;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Apostador{" +
				"email='" + email + '\'' +
				", betESScoins=" + betESScoins +
				", name='" + name + '\'' +
				'}';
	}

}