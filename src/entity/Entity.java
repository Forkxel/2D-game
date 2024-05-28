package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {

    protected int x, y;
    protected int speed;
    protected BufferedImage up1, up2, down1, down2, left1, left2, right1, right2, neutralDown;
    protected String direction;
    protected int counter;
    protected int number;
    protected Rectangle bounds;
    protected boolean collision;
    protected int maxLife;
    protected int life;

    protected void move(){
        switch (direction) {
            case "up":
                y -= speed;
                break;
            case "down":
                y += speed;
                break;
            case "left":
                x -= speed;
                break;
            case "right":
                x += speed;
                break;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public String getDirection() {
        return direction;
    }

    public int getSpeed() {
        return speed;
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
