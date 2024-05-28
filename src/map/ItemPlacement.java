package map;

import object.Chest;
import object.Doors;
import object.Key;
import object.Item;
import window.Screen;

import java.util.ArrayList;

/**
 * Class for placing the items on map
 */
public class ItemPlacement {

    private final Screen screen;

    public ItemPlacement(Screen panel) {
        this.screen = panel;
    }

    /**
     * Method that is used to create ArrayList of items
     * @return ArrayList of items
     */
    public ArrayList<Item> addItems(){
        ArrayList<Item> items = new ArrayList<>();
        
        Key key = new Key();
        key.setX(36 * screen.getScaledTile());
        key.setY(21 * screen.getScaledTile());
        key.setColor("yellow");
        key.setColorPicture();
        items.add(key);

        Key redKey = new Key();
        redKey.setX(9 * screen.getScaledTile());
        redKey.setY(40 * screen.getScaledTile());
        redKey.setColor("red");
        redKey.setColorPicture();
        items.add(redKey);

        Doors greenDoors = new Doors();
        greenDoors.setX(24 * screen.getScaledTile());
        greenDoors.setY(8 * screen.getScaledTile());
        greenDoors.setColor("green");
        greenDoors.setColorPicture();
        items.add(greenDoors);

        Doors redDoors = new Doors();
        redDoors.setX(38 * screen.getScaledTile());
        redDoors.setY(13 * screen.getScaledTile());
        redDoors.setColor("red");
        redDoors.setColorPicture();
        items.add(redDoors);

        Doors blueDoors = new Doors();
        blueDoors.setX(43 * screen.getScaledTile());
        blueDoors.setY(23 * screen.getScaledTile());
        blueDoors.setColor("blue");
        blueDoors.setColorPicture();
        items.add(blueDoors);

        Chest chest = new Chest();;
        chest.setX(24 * screen.getScaledTile());
        chest.setY(5 * screen.getScaledTile());
        items.add(chest);

        Key blueKey = new Key();
        blueKey.setX(37 * screen.getScaledTile());
        blueKey.setY(46 * screen.getScaledTile());
        blueKey.setColor("blue");
        blueKey.setColorPicture();
        items.add(blueKey);

        Key greenKey = new Key();
        greenKey.setX(45 * screen.getScaledTile());
        greenKey.setY(5 * screen.getScaledTile());
        greenKey.setColor("green");
        greenKey.setColorPicture();
        items.add(greenKey);

        return items;
    }
}
