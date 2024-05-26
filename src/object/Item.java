package object;

import entity.Player;
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
        Player player = screen.getPlayer();
        int tileSize = screen.getScaledTile();

        int relativeX = x - player.getX() + player.getCurrentX();
        int relativeY = y - player.getY() + player.getCurrentY();

        int playerScreenX = player.getX() + player.getCurrentX();
        int playerScreenY = player.getY() + player.getCurrentY();

        boolean isInViewHorizontally = false;
        if (x + tileSize > player.getX() - player.getCurrentX() && x - tileSize < playerScreenX){
            isInViewHorizontally = true;
        }

        boolean isInViewVertically = false;
        if (y + tileSize > player.getY() - player.getCurrentY() && y - tileSize < playerScreenY){
            isInViewVertically = true;
        }

        if (isInViewHorizontally && isInViewVertically) {
            g2D.drawImage(image, relativeX, relativeY, tileSize, tileSize, null);
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

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }
}