package entity;

import window.Screen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Monster extends Entity{

    private int change = 0;
    private final Screen screen;
    private int numberUp = 0;
    private int numberDown = 0;
    private int numberLeft = 0;
    private int numberRight = 0;
    private int minY;
    private int maxY;
    private int minX;
    private int maxX;
    private String lastDirection;

    public Monster(Screen screen) {
        this.screen = screen;
        speed = 1;
        maxLife = 4;
        life = maxLife;
        bounds = new Rectangle();
        bounds.x = 3;
        bounds.y = 10;
        bounds.width = 42;
        bounds.height = 40;
        direction = "down";

        try {
            up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("monster/slime_1.png"));
            up2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("monster/slime_2.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(){
        action();
        collision = false;
        screen.getCollision().collision(this);
        boolean hit = screen.getCollision().collisionPlayer(this);
        screen.getCollision().collisionItem(this,false);
        if (!collision) {
            move();
        }
    }

    @Override
    protected void move() {
        switch (direction) {
            case "up":
                if (y - speed >= minY) {
                    y -= speed;
                }
                break;
            case "down":
                if (y + speed <= maxY) {
                    y += speed;
                }
                break;
            case "left":
                if (x - speed >= minX) {
                    x -= speed;
                }
                break;
            case "right":
                if (x + speed <= maxX) {
                    x += speed;
                }
                break;
        }
    }

    public void action() {
        change++;
        if (change == 200) {
            Random random = new Random();
            int number = random.nextInt(100);

            if (number <= 25) {
                if (numberUp < 2) {
                    direction = "up";
                    lastDirection = direction;
                    numberUp++;
                    numberDown = 0;
                    numberLeft = 0;
                    numberRight = 0;
                } else {
                    direction = lastDirection;
                }
            } else if (number <= 50) {
                if (numberDown < 2) {
                    direction = "down";
                    lastDirection = direction;
                    numberDown++;
                    numberUp = 0;
                    numberLeft = 0;
                    numberRight = 0;
                } else {
                    direction = lastDirection;
                }
            } else if (number <= 75) {
                if (numberLeft < 2) {
                    direction = "left";
                    lastDirection = direction;
                    numberLeft++;
                    numberUp = 0;
                    numberDown = 0;
                    numberRight = 0;
                } else {
                    direction = lastDirection;
                }
            } else {
                if (numberRight < 2) {
                    direction = "right";
                    lastDirection = direction;
                    numberRight++;
                    numberUp = 0;
                    numberDown = 0;
                    numberLeft = 0;
                } else {
                    direction = lastDirection;
                }
            }
            change = 0;
        }
    }

    public void draw(Graphics2D g2D, Screen screen) {
        Player player = screen.getPlayer();
        int tileSize = screen.getScaledTile();

        int relativeX = x - player.getX() + player.getCurrentX();
        int relativeY = y - player.getY() + player.getCurrentY();

        int playerScreenX = player.getX() + player.getCurrentX();
        int playerScreenY = player.getY() + player.getCurrentY();

        boolean isInViewHorizontally = false;
        boolean isInViewVertically = false;

        if (x + tileSize > player.getX() - player.getCurrentX() && x - tileSize < playerScreenX){
            isInViewHorizontally = true;
        }

        if (y + tileSize > player.getY() - player.getCurrentY() && y - tileSize < playerScreenY){
            isInViewVertically = true;
        }

        if (isInViewHorizontally && isInViewVertically) {
            flipAnimation();

            BufferedImage imageToDraw = null;
            switch (direction) {
                case "up":
                case "down":
                case "left":
                case "right":
                    if (number == 1){
                        imageToDraw = up1;
                    } else {
                        imageToDraw = up2;
                    }
                    break;
            }

            if (imageToDraw != null) {
                g2D.drawImage(imageToDraw, relativeX, relativeY, tileSize, tileSize, null);
            }
        }
    }

    /**
     * Method for changing walking image
     */
    @Override
    protected void flipAnimation() {
        counter++;
        if (counter > 30){
            if (number == 1){
                number = 2;
            } else {
                number = 1;
            }
            counter = 0;
        }
    }

    public void damage(boolean damage, Player player) {
        if (damage){
            if (!player.isInvincible()){
                player.setLife(player.getLife()-1);
                player.setInvincible(true);
                player.setHit(player.getHit()+1);
            }
            if (player.getLife() == 0){
                player.setLost(true);
            }
        }
    }

    public void setMinY(int minY) {
        this.minY = minY;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    public void setMinX(int minX) {
        this.minX = minX;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }
}
