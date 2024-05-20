package entity;

import window.GamePanel;
import window.Keyboard;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Player extends Entity{

    private final GamePanel gamePanel;
    private final Keyboard keyboard;
    private final int currentX;
    private final int currentY;

    public Player(GamePanel gamePanel, Keyboard keyboard) {
        this.gamePanel = gamePanel;
        this.keyboard = keyboard;
        this.speed = 1;
        this.number = 1;
        /*
        this.x = gamePanel.getScaledTile() / 29;
        this.y = gamePanel.getScaledTile() / 23;
        this.currentX = gamePanel.screenWidth/2 - gamePanel.getScaledTile();
        this.currentY = gamePanel.screenHeight/2 - gamePanel.getScaledTile();
         */
        this.x = gamePanel.getMapWidth() / 2;
        this.y = gamePanel.getMapHeight() / 2;
        this.currentX = gamePanel.getScreenWidth() / 2 - gamePanel.getScaledTile() / 2;
        this.currentY = gamePanel.getScreenHeight() / 2 - gamePanel.getScaledTile() / 2;
        this.direction = "down";
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

    public void update(){
        if (keyboard.isPressedA() || keyboard.isPressedD() || keyboard.isPressedS() || keyboard.isPressedW()){
            if (keyboard.isPressedW()){
                direction = "up";
                y -= speed;
            } else if (keyboard.isPressedS()){
                direction = "down";
                y += speed;
            } else if (keyboard.isPressedA()){
                direction = "left";
                x -= speed;
            } else {
                direction = "right";
                x += speed;
            }
        } else {
            direction = "neutral";
        }

        if (keyboard.isPressedShift()){
            speed = 2;
        } else {
            speed = 1;
        }
        counter++;
        if (counter > 15){
            if (number == 1){
                number = 2;
            } else if (number == 2) {
                number = 1;
            }
            counter = 0;
        }
    }

    public void draw(Graphics2D g2D){
        switch (direction){
            case "up":
                if (number == 1){
                    g2D.drawImage(up1, currentX, currentY, gamePanel.getScaledTile(), gamePanel.getScaledTile(), null);
                } else if (number == 2) {
                    g2D.drawImage(up2, currentX, currentY, gamePanel.getScaledTile(), gamePanel.getScaledTile(), null);
                }
                break;
            case "down":
                if (number == 1){
                    g2D.drawImage(down1, currentX, currentY, gamePanel.getScaledTile(), gamePanel.getScaledTile(), null);
                } else if (number == 2) {
                    g2D.drawImage(down2, currentX, currentY, gamePanel.getScaledTile(), gamePanel.getScaledTile(), null);
                }
                break;
            case "left":
                if (number == 1){
                    g2D.drawImage(left1, currentX, currentY, gamePanel.getScaledTile(), gamePanel.getScaledTile(), null);
                } else if (number == 2) {
                    g2D.drawImage(left2, currentX, currentY, gamePanel.getScaledTile(), gamePanel.getScaledTile(), null);
                }
                break;
            case "right":
                if (number == 1){
                    g2D.drawImage(right1, currentX, currentY, gamePanel.getScaledTile(), gamePanel.getScaledTile(), null);
                } else if (number == 2) {
                    g2D.drawImage(right2, currentX, currentY, gamePanel.getScaledTile(), gamePanel.getScaledTile(), null);
                }
                break;
            case "neutral":
                g2D.drawImage(neutralDown, currentX,currentY,gamePanel.getScaledTile(),gamePanel.getScaledTile(),null);
                break;
        }
    }

    public int getCurrentY() {
        return currentY;
    }

    public int getCurrentX() {
        return currentX;
    }
}
