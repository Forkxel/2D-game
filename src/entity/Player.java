package entity;

import object.Item;
import window.Screen;
import window.Keyboard;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is used for player creation and interactions
 */
public class Player extends Entity{

    private final Screen screen;
    private final Keyboard keyboard;
    private final int currentX;
    private final int currentY;
    private final ArrayList<Item> keys;
    private boolean win;
    private boolean lost = false;
    private boolean invincible = false;
    private int changeInvincibility = 0;
    private int hit;

    /**
     * Constructor for Player class that is also loading images
     * @param screen used for interacting with main game panel
     * @param keyboard for Keyboard inputs
     */
    public Player(Screen screen, Keyboard keyboard) {
        this.screen = screen;
        this.keyboard = keyboard;
        this.speed = 2;
        this.number = 1;
        this.bounds = new Rectangle(8,30,28,16);
        this.x = screen.getScaledTile() * 50 / 2;
        this.y = screen.getScaledTile() * 50 / 2;
        this.currentX = screen.getScreenWidth() / 2 - screen.getScaledTile() / 2;
        this.currentY = screen.getScreenHeight() / 2 - screen.getScaledTile() / 2;
        this.direction = "down";
        this.maxLife = 3;
        this.life = maxLife;
        this.keys = new ArrayList<>();
        try {
            up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/up_1.png"));
            up2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/up_2.png"));
            down1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/down_1.png"));
            down2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/down_2.png"));
            left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/left_1.png"));
            left2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/left_2.png"));
            right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/right_1.png"));
            right2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/right_2.png"));
            neutralDown = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/neutral_down.png"));
            emptyHeart = ImageIO.read(getClass().getClassLoader().getResourceAsStream("heart/empty_heart.png"));
            heart = ImageIO.read(getClass().getClassLoader().getResourceAsStream("heart/heart.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method used for updating player position, collision and interacting with items
     */
    @Override
    public void update() {
        findDirection();
        changeSpeed();

        setCollision(false);
        screen.getCollision().collision(this);
        boolean damage = screen.getCollision().collisionMonster(this, screen.getMonsters());
        int index = screen.getCollision().collisionItem(this, true);
        interact(index);
        damage(damage);

        if (!collision) {
            move();
        }
        flipAnimation();
        setInvincible();
    }

    /**
     * Method for finding in which direction is player going
     */
    private void findDirection() {
        if (keyboard.isPressedW()) {
            direction = "up";
        } else if (keyboard.isPressedS()) {
            direction = "down";
        } else if (keyboard.isPressedA()) {
            direction = "left";
        } else if (keyboard.isPressedD()) {
            direction = "right";
        } else {
            direction = "neutral";
        }
    }

    /**
     * Method for changing player speed
     */
    private void changeSpeed() {
        if (keyboard.isPressedShift()) {
            speed = 3;
        } else {
            speed = 2;
        }
    }

    /**
     * Method for changing walking image
     */
    @Override
    protected void flipAnimation() {
        counter++;
        if (counter > 15){
            if (number == 1){
                number = 2;
            } else {
                number = 1;
            }
            counter = 0;
        }
    }

    /**
     * Method for drawing player
     * @param g2D Graphics2D for drawing
     */
    public void draw(Graphics2D g2D) {
        switch (direction){
            case "up":
                if (number == 1){
                    g2D.drawImage(up1, currentX, currentY, screen.getScaledTile(), screen.getScaledTile(), null);
                } else if (number == 2) {
                    g2D.drawImage(up2, currentX, currentY, screen.getScaledTile(), screen.getScaledTile(), null);
                }
                break;
            case "down":
                if (number == 1){
                    g2D.drawImage(down1, currentX, currentY, screen.getScaledTile(), screen.getScaledTile(), null);
                } else if (number == 2) {
                    g2D.drawImage(down2, currentX, currentY, screen.getScaledTile(), screen.getScaledTile(), null);
                }
                break;
            case "left":
                if (number == 1){
                    g2D.drawImage(left1, currentX, currentY, screen.getScaledTile(), screen.getScaledTile(), null);
                } else if (number == 2) {
                    g2D.drawImage(left2, currentX, currentY, screen.getScaledTile(), screen.getScaledTile(), null);
                }
                break;
            case "right":
                if (number == 1){
                    g2D.drawImage(right1, currentX, currentY, screen.getScaledTile(), screen.getScaledTile(), null);
                } else if (number == 2) {
                    g2D.drawImage(right2, currentX, currentY, screen.getScaledTile(), screen.getScaledTile(), null);
                }
                break;
            case "neutral":
                g2D.drawImage(neutralDown, currentX,currentY, screen.getScaledTile(), screen.getScaledTile(),null);
                break;
        }
    }


    /**
     * Method for interacting with items
     * @param index is index from arraylist of items to find with which item player is interacting
     */
    public void interact(int index) {
        String name;
        if (index >= 0 && index < screen.getItems().length) {
            name = screen.getItems()[index].getName();
            Item currentItem = screen.getItems()[index];

            switch (name) {
                case "key":
                    keys.add(currentItem);
                    screen.getItems()[index] = null;
                    break;
                case "doors":
                    boolean doorOpened = false;
                    for (Item key : keys) {
                        if (key.getColor().equals(currentItem.getColor())) {
                            doorOpened = true;
                            break;
                        }
                    }
                    if (doorOpened) {
                        screen.getItems()[index] = null;
                    }
                    break;
                case "chest":
                    for (Item key : keys) {
                        if (key.getColor().equals("yellow")) {
                            win = true;
                            break;
                        }
                    }
                    break;
                case "potion":
                    life = maxLife;
                    hit = 0;
                    screen.getItems()[index] = null;
                    break;
            }
        }
    }

    /**
     * Method for player to receive damage from monster
     * @param damage if player touched monster
     */
    public void damage(boolean damage) {
        for (int i = 0; i < screen.getMonsters().size(); i++) {
            Monster monster = screen.getMonsters().get(i);
            monster.damage(screen.getCollision().collisionPlayer(monster),this);
        }
        if (damage){
            if (!invincible){
                life--;
                hit++;
                invincible = true;
            }
            if (life == 0){
                lost = true;
            }
        }
    }

    /**
     * Set player to not receive damage
     */
    public void setInvincible() {
        if (invincible){
            changeInvincibility++;
            if (changeInvincibility > 100){
                invincible = false;
                changeInvincibility = 0;
            }
        }
    }

    /**
     * Method to move player
     */
    @Override
    protected void move() {
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

    public int getCurrentY() {
        return currentY;
    }

    public int getCurrentX() {
        return currentX;
    }

    public boolean isWin() {
        return win;
    }

    public boolean isLost() {
        return lost;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public int getHit() {
        return hit;
    }

    public void setInvincible(boolean invincible) {
        this.invincible = invincible;
    }

    public boolean isInvincible() {
        return invincible;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }

    public ArrayList<Item> getKeys() {
        return keys;
    }
}
