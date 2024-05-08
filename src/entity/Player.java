package entity;

import window.GamePanel;
import window.Keyboard;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity{

    private GamePanel gamePanel;
    private Keyboard keyboard;

    public Player(GamePanel gamePanel, Keyboard keyboard) {
        this.gamePanel = gamePanel;
        this.keyboard = keyboard;
        x = 100;
        y = 100;
        speed = 2;
        direction = "down";
        image();
    }

    public void update(){
        if (keyboard.pressedW){
            direction = "up";
            y -= speed;
        } else if (keyboard.pressedS){
            direction = "down";
            y += speed;
        } else if (keyboard.pressedA){
            direction = "left";
            x -= speed;
        } else if (keyboard.pressedD){
            direction = "right";
            x += speed;
        }
        if (keyboard.pressedShift){
            speed = 4;
        } else {
            speed = 2;
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
    public void image(){
        try {
            up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("up_1.png"));
            System.out.println(getClass().getClassLoader().getResource("up_1.png"));
            up2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("up_2.png"));
            System.out.println(getClass().getClassLoader().getResource("up_2.png"));
            down1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("down_1.png"));
            System.out.println(getClass().getClassLoader().getResource("down_1.png"));
            down2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("down_2.png"));
            System.out.println(getClass().getClassLoader().getResource("down_2.png"));
            left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("left_1.png"));
            System.out.println(getClass().getClassLoader().getResource("left_1.png"));
            left2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("left_2.png"));
            System.out.println(getClass().getClassLoader().getResource("left_2.png"));
            right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("right_1.png"));
            System.out.println(getClass().getClassLoader().getResource("right_1.png"));
            right2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("right_2.png"));
            System.out.println(getClass().getClassLoader().getResource("right_2.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void draw(Graphics2D g2D){
        BufferedImage image = null;
        switch (direction){
            case "up":
                if (number == 1){
                    image = up1;
                } else if (number == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (number == 1){
                    image = down1;
                } else if (number == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (number == 1){
                    image = left1;
                } else if (number == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (number == 1){
                    image = right1;
                } else if (number == 2) {
                    image = right2;
                }
                break;
        }
        g2D.drawImage(image, x, y, gamePanel.scaledTile, gamePanel.scaledTile, null);

/*
        g2D.setColor(Color.BLUE);
        g2D.fillRect(x, y, gamePanel.scaledTile, gamePanel.scaledTile);
 */


    }
}
