package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Mother class for all entities
 */
public abstract class Entity {

    protected int x, y;
    protected int speed;
    protected BufferedImage up1, up2, down1, down2, left1, left2, right1, right2, neutralDown, emptyHeart, heart;
    protected String direction;
    protected int counter;
    protected int number;
    protected Rectangle bounds;
    protected boolean collision;
    protected int maxLife;
    protected int life;

    protected abstract void move();
    protected abstract void flipAnimation();
    protected abstract void update();

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

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public boolean isCollision() {
        return collision;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
