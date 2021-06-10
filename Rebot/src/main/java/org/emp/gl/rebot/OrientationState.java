/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.rebot;

/**
 *
 * @author islem
 */
public abstract class  OrientationState {
    Rebot rebot ;

    public OrientationState(Rebot rebot) {
        this.rebot = rebot;
    }
    
    public abstract void buttonUpPressed();
    public abstract void buttonDownPressed();
    public abstract void buttonLeftPressed();
    public abstract void buttonRightPressed();
    public abstract void move();
    
}
