/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.timer;

import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author islem
 */
public class TimerImpl implements TimerService{
        // we made the constructor private so we can't instace a object from it 
	private static TimerImpl INSTANCE ;
	int lastGeneratedNumber = -1 ;
	// create a process that genrates a number every second 
	public TimerImpl () {
		TimerTask t = new TimerTask() {			
			@Override
			public void run() {
				notifier();
			}
		}; 
		
		Timer tt = new Timer() ;
		tt.scheduleAtFixedRate(t, 0, 1000);
	}
	// singltone:  
	static public TimerImpl GET_INSTANCE () {
            if(INSTANCE == null)
                INSTANCE = new TimerImpl();
	return INSTANCE ;
	}
	
	
	
	Set<TimerObserver> observers = new HashSet<>();

        @Override
	public void addListener (TimerObserver n) {
		observers.add(n) ;
	}
	
        @Override
	public void removeListener (TimerObserver n) {
		observers.remove(n) ;
	}
	
	void notifier () {
		for (TimerObserver e: observers) {
			e.move();
		}
	}
}
