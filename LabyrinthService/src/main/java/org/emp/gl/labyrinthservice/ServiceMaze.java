/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.labyrinthservice;

import org.emp.gl.timer.TimerObserver;

/**
 *
 * @author islem
 */
public interface ServiceMaze extends TimerObserver   {
    public boolean isObstacle(int i ,int j);
   
}
