/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refactoring;

import model.Evento;

/**
 *
 * @author xavier
 */
public class Povoa {
    public static void povoaSystem(BetESSAPI controller){
        Evento e1 = controller.registaEvento("Braga","Barcelos"); e1.setOdds(2, 4, 6);
        Evento e2 = controller.registaEvento("Bragança","Porto"); e2.setOdds(3, 5, 1);
        Evento e3 = controller.registaEvento("Guimarães","Benfica"); e3.setOdds(8, 2, 4);
        Evento e4 = controller.registaEvento("AAUM","Benfica"); e4.setOdds(8, 2, 4);
        Evento e5 = controller.registaEvento("Porto","Benfica"); e5.setOdds(8, 2, 4);
    }
}
