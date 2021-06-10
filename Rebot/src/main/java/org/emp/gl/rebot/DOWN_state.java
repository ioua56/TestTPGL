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
public class DOWN_state extends OrientationState
{

    public DOWN_state(Rebot rebot) {
        super(rebot);
    }

    @Override
    public void buttonUpPressed() {
        // do nothing 
    }

    @Override
    public void buttonDownPressed() {
        // do nothing
    }

    @Override
    public void buttonLeftPressed() {
        rebot.CurrentOrientation=Rebot.LEFT_Orientation;
        rebot.ChangeState(new LEFT_state(rebot));
    }

    @Override
    public void buttonRightPressed() {
        rebot.CurrentOrientation=Rebot.RIGHT_Orientation;
        rebot.ChangeState(new RIGHT_state(rebot));
    }

    @Override
    public void move() {
        rebot.pos_Y++;
    }
    
}
