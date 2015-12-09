/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerObserver;

/**
 *
 * @author xavier
 */
public interface ModelSubject {
    public void notifyController(String message);
    public void addController(ControllerObserver c);
}
