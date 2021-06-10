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
public class LEFT_state extends OrientationState {

    public LEFT_state(Rebot rebot) {
        super(rebot);
    }

    @Override
    public void buttonUpPressed() {
        rebot.CurrentOrientation = Rebot.UP_Orientation;
        rebot.ChangeState(new UP_state(rebot));
    }

    @Override
    public void buttonDownPressed() {
        rebot.CurrentOrientation = Rebot.DOWN_Orientation;
        rebot.ChangeState(new DOWN_state(rebot));
    }

    @Override
    public void buttonLeftPressed() {
// do nothing
    }

    @Override
    public void buttonRightPressed() {
// do nothing
    }

    @Override
    public void move() {
        rebot.pos_X--;
    }

}
