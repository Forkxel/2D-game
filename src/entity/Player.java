package entity;

import window.GamePanel;
import window.Keyboard;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Player extends Entity{

    private GamePanel gamePanel;
    private Keyboard keyboard;

    public Player(GamePanel gamePanel, Keyboard keyboard) {
        this.gamePanel = gamePanel;
        this.keyboard = keyboard;
        this.x = 384;
        this.y = 288;
        this.speed = 1;
        this.number = 1;
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
            neutral = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/neutral_down.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(){
        if (keyboard.pressedA || keyboard.pressedD || keyboard.pressedS || keyboard.pressedW){
            if (keyboard.pressedW){
                direction = "up";
                y -= speed;
            } else if (keyboard.pressedS){
                direction = "down";
                y += speed;
            } else if (keyboard.pressedA){
                direction = "left";
                x -= speed;
            } else {
                direction = "right";
                x += speed;
            }
        } else {
            direction = "neutral";
        }

        if (keyboard.pressedShift){
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
                    g2D.drawImage(up1, x, y, gamePanel.scaledTile, gamePanel.scaledTile, null);
                } else if (number == 2) {
                    g2D.drawImage(up2, x, y, gamePanel.scaledTile, gamePanel.scaledTile, null);
                }
                break;
            case "down":
                if (number == 1){
                    g2D.drawImage(down1, x, y, gamePanel.scaledTile, gamePanel.scaledTile, null);
                } else if (number == 2) {
                    g2D.drawImage(down2, x, y, gamePanel.scaledTile, gamePanel.scaledTile, null);
                }
                break;
            case "left":
                if (number == 1){
                    g2D.drawImage(left1, x, y, gamePanel.scaledTile, gamePanel.scaledTile, null);
                } else if (number == 2) {
                    g2D.drawImage(left2, x, y, gamePanel.scaledTile, gamePanel.scaledTile, null);
                }
                break;
            case "right":
                if (number == 1){
                    g2D.drawImage(right1, x, y, gamePanel.scaledTile, gamePanel.scaledTile, null);
                } else if (number == 2) {
                    g2D.drawImage(right2, x, y, gamePanel.scaledTile, gamePanel.scaledTile, null);
                }
                break;
            case "neutral":
                g2D.drawImage(neutral, x,y,gamePanel.scaledTile,gamePanel.scaledTile,null);
                break;
        }
    }
}
