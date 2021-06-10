/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.rebot;

import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.labyrinthservice.ServiceMaze;
import org.emp.gl.rebotservice.Position;
import org.emp.gl.rebotservice.RebotService;
import org.emp.gl.timer.TimerObserver;

/**
 *
 * @author islem
 */
public class Rebot implements RebotService {



    public int pos_X;
    public int pos_Y;
    String CurrentOrientation;
    private OrientationState orientationState = new UP_state(this);

    public Rebot(int x, int y, String startOrientation) {
        pos_X = x;
        pos_Y = y;
        CurrentOrientation = startOrientation;
    }

    @Override
    public void move() {

        if (!detectCollision()) {
            orientationState.move();
        } else {
            System.out.println("Rebot Stopped  Orientation: " + CurrentOrientation);
        }
    }

    @Override
    public Position getPosition() {
        return new Position(pos_X, pos_Y);
    }

    @Override
    public String getOrientation() {
        return CurrentOrientation;
    }

    public void ChangeState(OrientationState newState) {
        this.orientationState = newState;
    }

    @Override
    public void buttonUpPressed() {
        orientationState.buttonUpPressed();
    }

    @Override
    public void buttonDownPressed() {
        orientationState.buttonDownPressed();
    }

    @Override
    public void buttonLeftPressed() {
        orientationState.buttonLeftPressed();
    }

    @Override
    public void buttonRightPressed() {
        orientationState.buttonRightPressed();
    }

    boolean detectCollision() {
        ServiceMaze sm = Lookup.getLookup().get(ServiceMaze.class);
        if (sm.isObstacle(pos_X-1, pos_Y) && CurrentOrientation == Rebot.LEFT_Orientation) {
            return true;
        }
        if (sm.isObstacle(pos_X+1, pos_Y) && CurrentOrientation == Rebot.RIGHT_Orientation) {
            return true;
        }
        if (sm.isObstacle(pos_X, pos_Y-1) && CurrentOrientation == Rebot.UP_Orientation) {
            return true;
        }
        if (sm.isObstacle(pos_X, pos_X+1) && CurrentOrientation == Rebot.DOWN_Orientation) {
            return true;
        }
        return false;
    }

}
