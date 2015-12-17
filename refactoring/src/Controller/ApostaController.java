/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.View;
import model.Aposta;
import model.Resultado;

/**
 *
 * @author xavier
 */
public class ApostaController {
    private Aposta aposta;
    private ApostadorController apostador;
    private OddController odd;
    private Resultado resultado;
    private View view;
    
    public ApostaController(View v){
        this.aposta = new Aposta();
        this.view = v;
    }

    public ApostadorController getApostador() {
        return apostador;
    }

    public void setApostador(ApostadorController apostador) {
        this.apostador = apostador;
    }

    public OddController getOdd() {
        return odd;
    }

    public void setOdd(OddController odd) {
        this.odd = odd.clone();
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(char resultado) {
        this.resultado = (resultado == '1') ? Resultado.VITORIA 
                    : (resultado == 'x') ? Resultado.EMPATE : Resultado.DERROTA;
    }
    public float getM_aposta() {
		return aposta.getM_aposta();
	}
    public void setM_aposta(float m_aposta) {
		this.aposta.setM_aposta(m_aposta);
	}
    
    /*métodos*/
   public int getPremio(){
       switch (this.getResultado()) {
		case VITORIA:
                    return (int) (this.aposta.getM_aposta() * this.odd.getOdd1());
		case EMPATE:
                    return (int) (this.aposta.getM_aposta() * this.odd.getOddx());
		case DERROTA:
                    return (int) (this.aposta.getM_aposta() * this.odd.getOdd2());
		}
            return 0;
   }
    
}
