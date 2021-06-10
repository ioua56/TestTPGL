/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.launcher;

import java.awt.EventQueue;
import javax.swing.SwingUtilities;
import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.gui.Controller;
import org.emp.gl.rebot.Rebot;
import org.emp.gl.rebotservice.RebotService;
import org.emp.gl.timer.TimerImpl;
import org.emp.gl.timer.TimerObserver;
import org.emp.gl.timer.TimerService;
import org.emp.gl.gui1.Maze;
import org.emp.gl.labyrinthservice.ServiceMaze;


/**
 *
 * @author islem
 */
public class MainApp {

    /**
     * @param args the command line arguments
     */
    static {
        Lookup.getLookup().register(TimerService.class, new TimerImpl());
        Lookup.getLookup().register(RebotService.class, new Rebot(1, 5, Rebot.UP_Orientation));
        Lookup.getLookup().register(ServiceMaze.class, new Maze());

    }

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("hello world");

        //Controller  c;
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Controller c = new Controller();
                c.setVisible(true);
                Maze view = new Maze();
                view.setVisible(true);
                Lookup.getLookup().get(TimerService.class).addListener((TimerObserver) view);

            }
        });

        RebotService r = Lookup.getLookup().get(RebotService.class);

        Lookup.getLookup().get(TimerService.class).addListener((TimerObserver) r);

    }

}
