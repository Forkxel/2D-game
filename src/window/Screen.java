package window;

import entity.Player;
import map.Collision;
import map.Map;
import map.ItemPlacement;
import object.Item;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Screen extends JPanel implements Runnable{

    private final int tileSize = 16;
    private final int scaledTile = tileSize * 3;
    private final Keyboard keyboard = new Keyboard();
    private final int columns = 18;
    private final int rows = 14;
    private final int screenWidth = scaledTile * columns;
    private final int screenHeight = scaledTile * rows;
    private final int mapColumns = 50;
    private final int mapRows = 50;
    private final int mapWidth = scaledTile * mapColumns;
    private final int mapHeight = scaledTile * mapRows;
    private final Thread thread;
    private final Player player = new Player(this, keyboard);
    private final Collision collision = new Collision(this);
    private final Map map = new Map(this);
    private ArrayList<Item> items = new ArrayList<>();

    public Screen() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyboard);
        this.setBackground(Color.black);
        this.setFocusable(true);
        ItemPlacement itemPlacement = new ItemPlacement(this);
        setItems(itemPlacement.addObjects());
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
                player.update();
                repaint();
                delta--;
            }

            try {
                Thread.sleep((long) ((lastTime - System.nanoTime() + drawInterval) / 1000000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        map.draw(g2D);
        for (Item object : items) {
            object.draw(g2D, this);
        }
        player.draw(g2D);
        g2D.dispose();
    }

    public int getMapColumns() {
        return mapColumns;
    }

    public int getMapRows() {
        return mapRows;
    }

    public int getScaledTile() {
        return scaledTile;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public Player getPlayer() {
        return player;
    }

    public Collision getCollision() {
        return collision;
    }

    public Map getMap() {
        return map;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
