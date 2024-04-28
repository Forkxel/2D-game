package entity;

import window.GamePanel;
import window.Keyboard;

import java.awt.*;

public class Player extends Entity{

    private GamePanel gamePanel;
    private Keyboard keyboard;

    public Player(GamePanel gamePanel, Keyboard keyboard) {
        this.gamePanel = gamePanel;
        this.keyboard = keyboard;
        x = 100;
        y = 100;
        speed = 2;
    }

    public void update(){
        if (keyboard.pressedW){
            y -= speed;
        } else if (keyboard.pressedS){
            y += speed;
        } else if (keyboard.pressedA){
            x -= speed;
        } else if (keyboard.pressedD){
            x += speed;
        }
        if (keyboard.pressedShift){
            speed = 4;
        } else {
            speed = 2;
        }
    }

    public void draw(Graphics2D g2D){
        g2D.setColor(Color.white);
        g2D.fillRect(x,y,gamePanel.scaledTile, gamePanel.scaledTile);
    }
}
