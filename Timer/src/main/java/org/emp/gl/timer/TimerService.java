/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.timer;

/**
 *
 * @author islem
 */
public interface TimerService {
    void addListener (TimerObserver n);
    void removeListener (TimerObserver n);
}
