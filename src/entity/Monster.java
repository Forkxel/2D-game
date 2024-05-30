package entity;

import window.Screen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Class for entity Monster
 */
public class Monster extends Entity {

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

    /**
     * Constructor for Monster class that is also loading images
     * @param screen used for interacting with main game panel
     */
    public Monster(Screen screen) {
        this.screen = screen;
        speed = 2;
        bounds = new Rectangle();
        bounds.x = 3;
        bounds.y = 10;
        bounds.width = 42;
        bounds.height = 40;
        direction = "down";

        try {
            up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("monster/monster_1.png"));
            up2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("monster/monster_2.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method used for updating monsters positions and collisions
     */
    @Override
    public void update() {
        action();
        collision = false;
        screen.getCollision().collision(this);
        screen.getCollision().collisionPlayer(this);
        screen.getCollision().collisionItem(this,false);
        if (!collision) {
            move();
        }
    }

    /**
     * Method for moving with monsters
     */
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

    /**
     * Method to randomly determine in which direction monsters will go
     */
    public void action() {
        change++;
        if (change == 60) {
            Random random = new Random();
            int number = random.nextInt(100);
            boolean directionChanged = false;

            while (!directionChanged) {
                switch (number / 25) {
                    case 0:
                        if (numberUp < 2) {
                            direction = "up";
                            numberUp++;
                            resetOtherCounters("up");
                            directionChanged = true;
                        } else {
                            number = random.nextInt(100);
                        }
                        break;
                    case 1:
                        if (numberDown < 2) {
                            direction = "down";
                            numberDown++;
                            resetOtherCounters("down");
                            directionChanged = true;
                        } else {
                            number = random.nextInt(100);
                        }
                        break;
                    case 2:
                        if (numberLeft < 2) {
                            direction = "left";
                            numberLeft++;
                            resetOtherCounters("left");
                            directionChanged = true;
                        } else {
                            number = random.nextInt(100);
                        }
                        break;
                    case 3:
                        if (numberRight < 2) {
                            direction = "right";
                            numberRight++;
                            resetOtherCounters("right");
                            directionChanged = true;
                        } else {
                            number = random.nextInt(100);
                        }
                        break;
                }
            }
            change = 0;
        }
    }

    /**
     * Method to reset counters of directions
     * @param currentDirection name of the current direction
     */
    private void resetOtherCounters(String currentDirection) {
        if (!currentDirection.equals("up")) numberUp = 0;
        if (!currentDirection.equals("down")) numberDown = 0;
        if (!currentDirection.equals("left")) numberLeft = 0;
        if (!currentDirection.equals("right")) numberRight = 0;
    }

    /**
     * Method to draw monsters on the map
     * @param g2D Graphics2D for drawing
     */
    public void draw(Graphics2D g2D) {
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

    /**
     * Method used to find if monster has touched player
     * @param damage if true monster has touched player
     * @param player player character
     */
    public void damage(boolean damage, Player player) {
        if (damage){
            if (!player.isInvincible()){
                player.setLife(player.getLife()-1);
                player.setHit(player.getHit()+1);
                player.setInvincible(true);
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
