package map;

import object.Chest;
import object.Doors;
import object.Key;
import object.MyObject;
import window.GamePanel;

import java.util.ArrayList;

public class ObjectPlacement {

    GamePanel gamePanel;
    ArrayList<MyObject> myObjects;

    public ObjectPlacement(GamePanel panel) {
        this.gamePanel = panel;
    }

    public ArrayList<MyObject> addObjects(){
        myObjects = new ArrayList<>();
        myObjects.add(new Key());
        myObjects.getFirst().setX(36 * gamePanel.getScaledTile());
        myObjects.getFirst().setY(11 * gamePanel.getScaledTile());

        myObjects.add(new Key());
        myObjects.get(1).setX(9 * gamePanel.getScaledTile());
        myObjects.get(1).setY(40 * gamePanel.getScaledTile());

        myObjects.add(new Doors());
        myObjects.get(2).setX(24 * gamePanel.getScaledTile());
        myObjects.get(2).setY(8 * gamePanel.getScaledTile());

        myObjects.add(new Doors());
        myObjects.get(3).setX(38 * gamePanel.getScaledTile());
        myObjects.get(3).setY(21 * gamePanel.getScaledTile());

        myObjects.add(new Doors());
        myObjects.get(4).setX(38 * gamePanel.getScaledTile());
        myObjects.get(4).setY(13 * gamePanel.getScaledTile());

        myObjects.add(new Doors());
        myObjects.get(5).setX(43 * gamePanel.getScaledTile());
        myObjects.get(5).setY(7 * gamePanel.getScaledTile());

        myObjects.add(new Doors());
        myObjects.get(6).setX(43 * gamePanel.getScaledTile());
        myObjects.get(6).setY(23 * gamePanel.getScaledTile());

        myObjects.add(new Chest());
        myObjects.get(7).setX(24 * gamePanel.getScaledTile());
        myObjects.get(7).setY(5 * gamePanel.getScaledTile());

        return myObjects;
    }
}
