package window;

import entity.Monster;
import entity.MonsterPlacement;
import entity.Player;
import map.Collision;
import map.Map;
import map.ItemPlacement;
import object.Item;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Screen extends JPanel implements Runnable{

    private final int scaledTile = 48;
    private final Keyboard keyboard = new Keyboard();
    private final int screenWidth = scaledTile * 18;
    private final int screenHeight = scaledTile * 14;
    private Thread thread;
    private final Player player = new Player(this, keyboard);
    private final Collision collision = new Collision(this);
    private final Map map = new Map(this);
    private Item[] items = new Item[9];
    private final Message message = new Message(this);
    private ArrayList<Monster> monsters = new ArrayList<>();

    public Screen() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyboard);
        this.setBackground(Color.black);
        this.setFocusable(true);
        ItemPlacement itemPlacement = new ItemPlacement(this);
        MonsterPlacement monsterPlacement = new MonsterPlacement(this);
        setItems(itemPlacement.addItems());
        setMonsters(monsterPlacement.addMonsters());
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
                for (Monster monster : monsters) {
                    monster.update();
                }
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
        for (Item item : items) {
            if (item != null) {
                item.draw(g2D, this);
            }
        }
        for (Monster monster : monsters) {
            monster.draw(g2D, this);
        }
        player.draw(g2D);
        player.drawHearts(g2D);
        if (player.isWin()){
            message.drawWin(g2D);
        }
        if (player.isLost()){
            message.drawLose(g2D);
        }
        g2D.dispose();
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

    public Player getPlayer() {
        return player;
    }

    public Collision getCollision() {
        return collision;
    }

    public Map getMap() {
        return map;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public void setMonsters(ArrayList<Monster> monsters) {
        this.monsters = monsters;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public Item[] getItems() {
        return items;
    }
}
