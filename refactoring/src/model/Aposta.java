package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;


public class Aposta {

	//private Apostador apostador;
	private float m_aposta;
	//private Resultado resultado;
	//private Odd odd_fixada;



	public Aposta(){
		//this.apostador = null;
		this.m_aposta = 0;
		//this.resultado = null;
		//this.odd_fixada = null;
	}
        
        
        /*private void setResultado(char resultado){
            this.resultado = (resultado == '1') ? Resultado.VITORIA 
                    : (resultado == 'x') ? Resultado.EMPATE : Resultado.DERROTA;
        }*/
        
	public Aposta(Apostador apostador, float m_aposta, char resultado, Odd odd_actual) {
            //this.apostador = apostador;
            this.m_aposta = m_aposta;
            //this.setResultado(resultado);
            //this.odd_fixada = odd_actual.clone();
	}

	// getter and setters

	/*public Apostador getApostador() {
		return apostador;
	}*/

	/*public Resultado getResultado() {
		return resultado;
	}*/

	public float getM_aposta() {
		return m_aposta;
	}

	/*public Odd getOdd_fixada() {
		return odd_fixada;
	}*/
        
        /*public int getPremio(){
            switch (this.getResultado()) {
		case VITORIA:
                    return (int) (this.getM_aposta() * this.getOdd_fixada().getOdd1());
		case EMPATE:
                    return (int) (this.getM_aposta() * this.getOdd_fixada().getOddx());
		case DERROTA:
                    return (int) (this.getM_aposta() * this.getOdd_fixada().getOdd2());
		}
            return 0;
        }*/
        

	/*public void setOdd_fixada(Odd odd_fixada) {
		this.odd_fixada = odd_fixada.clone();
	}*/

	public void setM_aposta(float m_aposta) {
		this.m_aposta = m_aposta;
	}

	/*public void setApostador(Apostador apostador) {
		this.apostador = apostador;
	}*/

	/*public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}*/
}