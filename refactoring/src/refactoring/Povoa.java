/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refactoring;

import Controller.BookieController;
import Controller.EventoController;
import model.Evento;

/**
 *
 * @author xavier
 */
public class Povoa {
    public static void povoaSystem(BetESSAPI api){
        BookieController b = api.registaBookie("Mário Anónimo", "anonimo@mail.pt");
        EventoController e1 = api.registaEvento("Braga","Barcelos",b); e1.setOdds(2, 4, 6);
        EventoController e2 = api.registaEvento("Bragança","Porto",b); e2.setOdds(3, 5, 1);
        EventoController e3 = api.registaEvento("Guimarães","Benfica",b); e3.setOdds(8, 2, 4);
        EventoController e4 = api.registaEvento("AAUM","Benfica",b); e4.setOdds(8, 2, 4);
        EventoController e5 = api.registaEvento("Porto","Benfica",b); e5.setOdds(8, 2, 4);
    }
}
