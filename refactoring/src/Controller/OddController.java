/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import model.Odd;

/**
 *
 * @author xavier
 */
public class OddController {
    private Odd odd;
    
    public OddController(){
        this.odd = new Odd();
    }
    
    
    public float getOdd1() {
		return this.odd.getOdd1();
	}


	public void setOdd1(float odd1) {
		this.odd.setOdd1(odd1);
	}

	public float getOddx() {
		return this.odd.getOddx();
	}

	public void setOddx(float oddx) {
		this.odd.setOddx(oddx);
	}

	public float getOdd2() {
		return this.odd.getOdd2();
	}


	public void setOdd2(float odd2) {
		this.odd.setOdd2(odd2);
	}

        public String toString(){
            return this.odd.toString();
        }
    
    public OddController clone(){
        OddController res = new OddController();
        res.setOdd1(this.getOdd1());
        res.setOdd2(this.getOdd2());
        res.setOddx(this.getOddx());
        return res;
    }
}
