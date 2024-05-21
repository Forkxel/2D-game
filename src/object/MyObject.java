package object;

import window.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class MyObject {

    protected BufferedImage image;
    protected String name;
    protected boolean collision;
    protected int x,y;

    public void draw(Graphics2D g2D, GamePanel gamePanel) {
        int currentX = x - gamePanel.getPlayer().getX() + gamePanel.getPlayer().getCurrentX();
        int currentY = y - gamePanel.getPlayer().getY() + gamePanel.getPlayer().getCurrentY();
        if (x - gamePanel.getScaledTile() < gamePanel.getPlayer().getX() + gamePanel.getPlayer().getCurrentX() && y - gamePanel.getScaledTile() < gamePanel.getPlayer().getY() + gamePanel.getPlayer().getCurrentY() &&
                y + gamePanel.getScaledTile() > gamePanel.getPlayer().getY() - gamePanel.getPlayer().getCurrentY() && x + gamePanel.getScaledTile() > gamePanel.getPlayer().getX() - gamePanel.getPlayer().getCurrentX()) {
            g2D.drawImage(image, currentX, currentY, gamePanel.getScaledTile(), gamePanel.getScaledTile(), null);
        }
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}