package entity;

import java.awt.image.BufferedImage;

public abstract class Entity {

    protected int x, y;
    protected int speed;
    protected BufferedImage up1, up2, down1, down2, left1, left2, right1, right2, neutralDown;
    protected String direction;
    protected int counter;
    protected int number;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
