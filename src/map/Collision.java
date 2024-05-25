package map;

import entity.Entity;
import object.Item;
import window.Screen;

import java.awt.*;

public class Collision {

    private final Screen screen;

    public Collision(Screen screen) {
        this.screen = screen;
    }

    public void collision(Entity entity) {
        int leftX = entity.getX() + entity.getBounds().x;
        int rightX = entity.getX() + entity.getBounds().x + entity.getBounds().width;
        int leftY = entity.getY() + entity.getBounds().y;
        int leftDownY = entity.getY() + entity.getBounds().y + entity.getBounds().height;
        int leftColumn = leftX / screen.getScaledTile();
        int rightColumn = rightX / screen.getScaledTile();
        int topRow = leftY / screen.getScaledTile();
        int bottomRow = leftDownY / screen.getScaledTile();
        int mapWidth = screen.getMap().getMap()[0].length;
        int mapHeight = screen.getMap().getMap().length;
        int number1, number2;

        switch (entity.getDirection()) {
            case "up":
                topRow = (leftY - entity.getSpeed()) / screen.getScaledTile();
                if (topRow >= 0) {
                    if (leftColumn >= 0 && leftColumn < mapWidth && topRow < mapHeight) {
                        number1 = screen.getMap().getMap()[leftColumn][topRow];
                    } else {
                        number1 = -1;
                    }
                    if (rightColumn >= 0 && rightColumn < mapWidth && topRow < mapHeight) {
                        number2 = screen.getMap().getMap()[rightColumn][topRow];
                    } else {
                        number2 = -1;
                    }
                    if ((number1 != -1 && screen.getMap().getTiles().get(number1).isCollision()) ||
                            (number2 != -1 && screen.getMap().getTiles().get(number2).isCollision())) {
                        entity.setCollision(true);
                    }
                }
                break;
            case "down":
                bottomRow = (leftDownY + entity.getSpeed()) / screen.getScaledTile();
                if (bottomRow < mapHeight) {
                    if (leftColumn >= 0 && leftColumn < mapWidth && bottomRow >= 0) {
                        number1 = screen.getMap().getMap()[leftColumn][bottomRow];
                    } else {
                        number1 = -1;
                    }
                    if (rightColumn >= 0 && rightColumn < mapWidth && bottomRow >= 0) {
                        number2 = screen.getMap().getMap()[rightColumn][bottomRow];
                    } else {
                        number2 = -1;
                    }
                    if ((number1 != -1 && screen.getMap().getTiles().get(number1).isCollision()) ||
                            (number2 != -1 && screen.getMap().getTiles().get(number2).isCollision())) {
                        entity.setCollision(true);
                    }
                }
                break;
            case "left":
                leftColumn = (leftX - entity.getSpeed()) / screen.getScaledTile();
                if (leftColumn >= 0) {
                    if (leftColumn < mapWidth && topRow >= 0 && topRow < mapHeight) {
                        number1 = screen.getMap().getMap()[leftColumn][topRow];
                    } else {
                        number1 = -1;
                    }
                    if (leftColumn < mapWidth && bottomRow >= 0 && bottomRow < mapHeight) {
                        number2 = screen.getMap().getMap()[leftColumn][bottomRow];
                    } else {
                        number2 = -1;
                    }
                    if ((number1 != -1 && screen.getMap().getTiles().get(number1).isCollision()) ||
                            (number2 != -1 && screen.getMap().getTiles().get(number2).isCollision())) {
                        entity.setCollision(true);
                    }
                }
                break;
            case "right":
                rightColumn = (rightX + entity.getSpeed()) / screen.getScaledTile();
                if (rightColumn < mapWidth) {
                    if (rightColumn >= 0 && topRow >= 0 && topRow < mapHeight) {
                        number1 = screen.getMap().getMap()[rightColumn][topRow];
                    } else {
                        number1 = -1;
                    }
                    if (rightColumn >= 0 && bottomRow >= 0 && bottomRow < mapHeight) {
                        number2 = screen.getMap().getMap()[rightColumn][bottomRow];
                    } else {
                        number2 = -1;
                    }
                    if ((number1 != -1 && screen.getMap().getTiles().get(number1).isCollision()) ||
                            (number2 != -1 && screen.getMap().getTiles().get(number2).isCollision())) {
                        entity.setCollision(true);
                    }
                }
                break;
        }
    }

    public int collisionItem(Entity entity, boolean player) {
        int index = -1;

        Rectangle entityBounds = new Rectangle(
                entity.getX() + entity.getBounds().x,
                entity.getY() + entity.getBounds().y,
                entity.getBounds().width,
                entity.getBounds().height
        );

        for (int i = 0; i < screen.getItems().size(); i++) {
            Item item = screen.getItems().get(i);
            if (item != null) {
                Rectangle objBounds = new Rectangle(
                        item.getX() + item.getBounds().x,
                        item.getY() + item.getBounds().y,
                        item.getBounds().width,
                        item.getBounds().height
                );

                switch (entity.getDirection()) {
                    case "up":
                        entityBounds.y -= entity.getSpeed();
                        break;
                    case "down":
                        entityBounds.y += entity.getSpeed();
                        break;
                    case "left":
                        entityBounds.x -= entity.getSpeed();
                        break;
                    case "right":
                        entityBounds.x += entity.getSpeed();
                        break;
                }

                if (entityBounds.intersects(objBounds)) {
                    if (item.isCollision()) {
                        entity.setCollision(true);
                    }
                    if (player) {
                        index = i;
                    }
                }
                
                entityBounds.x = entity.getX() + entity.getBounds().x;
                entityBounds.y = entity.getY() + entity.getBounds().y;
            }
        }
        return index;
    }
}