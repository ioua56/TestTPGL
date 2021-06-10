package org.emp.gl.gui1;

import org.emp.gl.labyrinthservice.ServiceMaze;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.SwingUtilities;
import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.rebotservice.Position;
import org.emp.gl.rebotservice.RebotService;
import org.emp.gl.timer.TimerObserver;

/**
 *
 * @author islam
 */
public class Maze extends JFrame implements ServiceMaze {

    private int[][] labyrinth
            = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}

            };

    public Maze() {

        setTitle("Labyrinth");
        setSize(500, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);

        for (int row = 0; row < labyrinth.length; row++) {
            for (int col = 0; col < labyrinth[0].length; col++) {

                Color color;
                switch (labyrinth[row][col]) {
                    case 1:
                        color = Color.BLACK;
                        break;
                    default:
                        color = Color.WHITE;
                }
                g.setColor(color);
                g.fillRect(30 * col, 30 * row, 30, 30);
                g.setColor(Color.BLACK);
                g.drawRect(30 * col, 30 * row, 30, 30);

            }
        }
        RebotService r = Lookup.getLookup().get(RebotService.class);
        int pathX = r.getPosition().x;
        int pathY = r.getPosition().y;

        try {
            BufferedImage image = null;

            switch (r.getOrientation()) {
                case RebotService.DOWN_Orientation:
                    image = ImageIO.read(new File("C:\\Users\\islem\\Desktop\\Desktop\\TP GL\\TP-2\\gl-tp3\\TestTpGL\\Labyrinth\\Arrow.png"));
                    break;
                case RebotService.UP_Orientation:
                    image = ImageIO.read(new File("C:\\Users\\islem\\Desktop\\Desktop\\TP GL\\TP-2\\gl-tp3\\TestTpGL\\Labyrinth\\Arrowup.png"));
                    break;
                case RebotService.LEFT_Orientation:
                    image = ImageIO.read(new File("C:\\Users\\islem\\Desktop\\Desktop\\TP GL\\TP-2\\gl-tp3\\TestTpGL\\Labyrinth\\Arrowleft.png"));
                    break;
                case RebotService.RIGHT_Orientation:
                    image = ImageIO.read(new File("C:\\Users\\islem\\Desktop\\Desktop\\TP GL\\TP-2\\gl-tp3\\TestTpGL\\Labyrinth\\Arrowright.png"));
                    break;
                default:
                    break;

            }
            g.drawImage(image, pathX * 30, pathY * 30, null);

        } catch (IOException ex) {
            g.setColor(Color.GREEN);
            g.drawOval(pathX * 30, pathY * 30, 28, 28);
            Logger.getLogger(Maze.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void processKeyEvent(KeyEvent ke) {

        if (ke.getID() != KeyEvent.KEY_PRESSED) {
            return;
        }
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            Lookup.getLookup().get(RebotService.class).buttonRightPressed();
        } else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
            Lookup.getLookup().get(RebotService.class).buttonLeftPressed();
        } else if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
            Lookup.getLookup().get(RebotService.class).buttonDownPressed();
        } else if (ke.getKeyCode() == KeyEvent.VK_UP) {
            Lookup.getLookup().get(RebotService.class).buttonUpPressed();
        }
        repaint();
    }

    @Override
    public void move() {
        repaint();
    }

    @Override
    public boolean isObstacle(int i, int j) {
        if (labyrinth[j][i] == 0) {
            return false;
        } else {
            return true;
        }
    }

}
