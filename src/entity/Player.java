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
        this.bounds = new Rectangle(8,25,28,16);
        this.x = screen.getMapWidth() / 2;
        this.y = screen.getMapHeight() / 2;
        this.currentX = screen.getScreenWidth() / 2 - screen.getScaledTile() / 2;
        this.currentY = screen.getScreenHeight() / 2 - screen.getScaledTile() / 2;
        this.direction = "down";
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method used for updating player position, collision and interacting with items
     */
    public void update() {
        findDirection();
        changeSpeed();

        setCollision(false);
        screen.getCollision().collision(this);
        int index = screen.getCollision().collisionItem(this, true);
        interact(index);

        if (!collision) {
            move();
        }
        flipAnimation();
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
     * Method for moving with player
     */
    private void move() {
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

    /**
     * Method for changing walking image
     */
    private void flipAnimation() {
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
    public void draw(Graphics2D g2D){
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
    private void interact(int index) {
        String name;
        if (index >= 0 && index < screen.getItems().size()) {
            name = screen.getItems().get(index).getName();
            Item currentItem = screen.getItems().get(index);

            switch (name) {
                case "key":
                    keys.add(currentItem);
                    screen.getItems().remove(index);
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
                        screen.getItems().remove(index);
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
            }
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
}
