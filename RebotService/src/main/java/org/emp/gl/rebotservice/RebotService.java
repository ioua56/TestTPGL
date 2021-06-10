/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.rebotservice;

import org.emp.gl.timer.TimerObserver;
import org.emp.gl.timer.TimerService;

/**
 *
 * @author islem
 */
public interface RebotService extends TimerObserver {

    public final static String UP_Orientation = "UP";
    public final static String DOWN_Orientation = "Down";
    public final static String LEFT_Orientation = "Left";
    public final static String RIGHT_Orientation = "Right";

    public Position getPosition();

    public String getOrientation();

    public void buttonUpPressed();

    public void buttonDownPressed();

    public void buttonLeftPressed();

    public void buttonRightPressed();
}
