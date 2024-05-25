package object;

import window.Screen;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class Item {

    protected BufferedImage image;
    protected String name;
    protected boolean collision;
    protected int x,y;
    protected Rectangle bounds = new Rectangle(0,0,48,48);
    protected String color;

    public void draw(Graphics2D g2D, Screen screen) {
        int currentX = x - screen.getPlayer().getX() + screen.getPlayer().getCurrentX();
        int currentY = y - screen.getPlayer().getY() + screen.getPlayer().getCurrentY();
        if (x - screen.getScaledTile() < screen.getPlayer().getX() + screen.getPlayer().getCurrentX() &&
                y - screen.getScaledTile() < screen.getPlayer().getY() + screen.getPlayer().getCurrentY() &&
                y + screen.getScaledTile() > screen.getPlayer().getY() - screen.getPlayer().getCurrentY() &&
                x + screen.getScaledTile() > screen.getPlayer().getX() - screen.getPlayer().getCurrentX()) {
            g2D.drawImage(image, currentX, currentY, screen.getScaledTile(), screen.getScaledTile(), null);
        }
    }

    public void setColorPicture() {
        try {
            setImageBasedOnColor();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract void setImageBasedOnColor() throws IOException;

    public boolean isCollision() {
        return collision;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setColor(String color) {
        this.color = color;
    }
}