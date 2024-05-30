package map;

import entity.Entity;
import entity.Monster;
import entity.Player;
import object.Item;
import window.Screen;

import java.awt.*;
import java.util.ArrayList;

/**
 * Class for finding collision
 */
public class Collision {

    private final Screen screen;

    public Collision(Screen screen) {
        this.screen = screen;
    }

    /**
     * Method for finding if player or monster is colliding with non-walkable tiles
     * @param entity player or monster
     */
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

    /**
     * Method for finding if player or monster is colliding with item
     * @param entity player or monster
     * @param player true if entity colliding with item is player
     * @return index of item that is interacting with player
     */
    public int collisionItem(Entity entity, boolean player) {
        int index = -1;

        Rectangle entityBounds = new Rectangle(entity.getX() + entity.getBounds().x, entity.getY() + entity.getBounds().y, entity.getBounds().width, entity.getBounds().height);

        for (int i = 0; i < screen.getItems().length; i++) {
            Item item = screen.getItems()[i];
            if (item != null) {
                Rectangle objBounds = new Rectangle(item.getX() + item.getBounds().x, item.getY() + item.getBounds().y, item.getBounds().width, item.getBounds().height);

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

    /**
     * Finds if player is colliding with monster
     * @param entity player
     * @param monsters ArrayList of monsters
     * @return true if monster hit player
     */
    public boolean collisionMonster(Entity entity, ArrayList<Monster> monsters) {
        Rectangle entityBounds = new Rectangle(entity.getX() + entity.getBounds().x, entity.getY() + entity.getBounds().y, entity.getBounds().width, entity.getBounds().height);
        boolean hit = false;

        for (Monster monster : monsters) {
            Rectangle monsterBounds = new Rectangle(monster.getX() + monster.getBounds().x, monster.getY() + monster.getBounds().y, monster.getBounds().width, monster.getBounds().height);

            Rectangle nextEntityBounds = new Rectangle(entityBounds);

            moveBounds(entity.getDirection(), entity, nextEntityBounds);

            if (nextEntityBounds.intersects(monsterBounds)) {
                if (entity != monster) {
                    entity.setCollision(true);
                    hit = true;
                }
                break;
            }
        }
        return hit;
    }

    /**
     * Finds if monster collided with player
     * @param entity
     * @return true if monster collided with player
     */
    public boolean collisionPlayer(Entity entity) {
        Rectangle entityBounds = new Rectangle(entity.getX() + entity.getBounds().x, entity.getY() + entity.getBounds().y, entity.getBounds().width, entity.getBounds().height);
        Player player = screen.getPlayer();
        int playerX = player.getX() + player.getBounds().x;
        int playerY = player.getY() + player.getBounds().y;
        int playerWidth = player.getBounds().width;
        int playerHeight = player.getBounds().height;
        Rectangle playerBounds = new Rectangle(playerX, playerY, playerWidth, playerHeight);
        Rectangle nextEntityBounds = new Rectangle(entityBounds);
        boolean hit = false;

        moveBounds(entity.getDirection(), entity, nextEntityBounds);

        if (nextEntityBounds.intersects(playerBounds)) {
            entity.setCollision(true);
            hit = true;
        }
        return hit;
    }

    /**
     * Method to move bounds of the entity
     * @param direction in which entity is moving
     * @param entity that is moving
     * @param bounds of the entity
     */
    private void moveBounds(String direction, Entity entity, Rectangle bounds) {
        switch (direction) {
            case "up":
                bounds.translate(0, -entity.getSpeed());
                break;
            case "down":
                bounds.translate(0, entity.getSpeed());
                break;
            case "left":
                bounds.translate(-entity.getSpeed(), 0);
                break;
            case "right":
                bounds.translate(entity.getSpeed(), 0);
                break;
        }
    }
}