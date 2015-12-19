package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;


public class Aposta {

	private float m_aposta;

	public Aposta(){
		this.m_aposta = 0;
	}
        
	public Aposta(float m_aposta) {
            this.m_aposta = m_aposta;
	}

	public float getM_aposta() {
		return m_aposta;
	}

	public void setM_aposta(float m_aposta) {
		this.m_aposta = m_aposta;
	}

}