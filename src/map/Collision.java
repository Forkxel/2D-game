package map;

import entity.Entity;
import window.GamePanel;

public class Collision {

    private final GamePanel gamePanel;

    public Collision(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void collision(Entity entity) {
        int leftX = entity.getX() + entity.getBounds().x;
        int rightX = entity.getX() + entity.getBounds().x + entity.getBounds().width;
        int leftY = entity.getY() + entity.getBounds().y;
        int leftDownY = entity.getY() + entity.getBounds().y + entity.getBounds().height;

        int leftColumn = leftX/gamePanel.getScaledTile();
        int rightColumn = rightX/gamePanel.getScaledTile();
        int topRow = leftY/gamePanel.getScaledTile();
        int bottomRow = leftDownY/gamePanel.getScaledTile();

        int number1, number2;

        switch (entity.getDirection()){
            case "up":
                topRow = (leftY - entity.getSpeed())/gamePanel.getScaledTile();
                number1 = gamePanel.getMap().getMap()[leftColumn][topRow];
                number2 = gamePanel.getMap().getMap()[rightColumn][topRow];
                if (gamePanel.getMap().getTiles().get(number1).isCollision() || gamePanel.getMap().getTiles().get(number2).isCollision()) {
                    entity.setCollision(true);
                }
                break;
            case "down":
                bottomRow = (leftDownY + entity.getSpeed())/gamePanel.getScaledTile();
                number1 = gamePanel.getMap().getMap()[leftColumn][bottomRow];
                number2 = gamePanel.getMap().getMap()[rightColumn][bottomRow];
                if (gamePanel.getMap().getTiles().get(number1).isCollision() || gamePanel.getMap().getTiles().get(number2).isCollision()) {
                    entity.setCollision(true);
                }
                break;
            case "left":
                leftColumn = (leftX - entity.getSpeed())/gamePanel.getScaledTile();
                number1 = gamePanel.getMap().getMap()[leftColumn][topRow];
                number2 = gamePanel.getMap().getMap()[leftColumn][bottomRow];
                if (gamePanel.getMap().getTiles().get(number1).isCollision() || gamePanel.getMap().getTiles().get(number2).isCollision()) {
                    entity.setCollision(true);
                }
                break;
            case "right":
                rightColumn = (rightX + entity.getSpeed())/gamePanel.getScaledTile();
                number1 = gamePanel.getMap().getMap()[rightColumn][topRow];
                number2 = gamePanel.getMap().getMap()[rightColumn][bottomRow];
                if (gamePanel.getMap().getTiles().get(number1).isCollision() || gamePanel.getMap().getTiles().get(number2).isCollision()) {
                    entity.setCollision(true);
                }
                break;
        }
    }
}
