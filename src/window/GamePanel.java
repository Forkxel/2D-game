package window;

import Map.Map;
import entity.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    private final int tileSize = 16;
    public final int scaledTile = tileSize * 3;
    private final Keyboard keyboard = new Keyboard();
    public final int columns = 16;
    public final int rows = 12;
    public final int screenWidth = scaledTile * columns;
    public final int screenHeight = scaledTile * rows;

    private Thread thread;
    Player player = new Player(this, keyboard);
    Map map = new Map(this);

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyboard);
        this.setFocusable(true);
    }

    public void startThread(){
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        int fps = 60;
        double drawInterval = 1000000000.0/ fps;
        double delta = 0.0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (thread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime)/drawInterval;
            lastTime = currentTime;

            if (delta >= 1){
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update(){
        player.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        map.draw(g2D);
        player.draw(g2D);
        g2D.dispose();
    }
}
