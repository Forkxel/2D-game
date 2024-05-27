package entity;

import object.Item;
import window.Screen;
import window.Keyboard;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Player extends Entity{

    private final Screen screen;
    private final Keyboard keyboard;
    private final int currentX;
    private final int currentY;
    private final ArrayList<Item> keys;

    public Player(Screen screen, Keyboard keyboard) {
        this.screen = screen;
        this.keyboard = keyboard;
        this.speed = 2;
        this.number = 1;
        this.bounds = new Rectangle(8,16,28,16);
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

    private void changeSpeed() {
        if (keyboard.isPressedShift()) {
            speed = 3;
        } else {
            speed = 2;
        }
    }

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

    private void interact(int index) {
        String name;
        if (index >= 0 && index < screen.getItems().size()) {
            name = screen.getItems().get(index).getName();

            switch (name){
                case "key":
                    keys.add(screen.getItems().get(index));
                    screen.getItems().remove(index);
                    break;
                case "doors":
                    for (Item key : keys) {
                        if (key.getColor().equals(screen.getItems().get(index).getColor())) {
                            screen.getItems().remove(index);
                        }
                    }
                    break;
                case "chest":
                    for (Item key : keys) {
                        if (key.getColor().equals("yellow")) {
                            screen.getItems().remove(index);
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
}
