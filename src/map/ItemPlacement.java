package map;

import object.*;
import window.Screen;

/**
 * Class for placing the items on map
 */
public class ItemPlacement {

    private final Screen screen;

    public ItemPlacement(Screen panel) {
        this.screen = panel;
    }

    /**
     * Method that is used for adding items to array
     * @return array of items
     */
    public Item[] addItems() {
        Item[] items = new Item[9];

        Key key = new Key();
        key.setX(36 * screen.getScaledTile());
        key.setY(21 * screen.getScaledTile());
        key.setColor("yellow");
        key.setColorPicture();
        items[0] = key;

        Key redKey = new Key();
        redKey.setX(9 * screen.getScaledTile());
        redKey.setY(40 * screen.getScaledTile());
        redKey.setColor("red");
        redKey.setColorPicture();
        items[1] = redKey;

        Doors greenDoors = new Doors();
        greenDoors.setX(24 * screen.getScaledTile());
        greenDoors.setY(8 * screen.getScaledTile());
        greenDoors.setColor("green");
        greenDoors.setColorPicture();
        items[2] = greenDoors;

        Doors redDoors = new Doors();
        redDoors.setX(38 * screen.getScaledTile());
        redDoors.setY(13 * screen.getScaledTile());
        redDoors.setColor("red");
        redDoors.setColorPicture();
        items[3] = redDoors;

        Doors blueDoors = new Doors();
        blueDoors.setX(43 * screen.getScaledTile());
        blueDoors.setY(23 * screen.getScaledTile());
        blueDoors.setColor("blue");
        blueDoors.setColorPicture();
        items[4] = blueDoors;

        Chest chest = new Chest();;
        chest.setX(24 * screen.getScaledTile());
        chest.setY(5 * screen.getScaledTile());
        items[5] = chest;

        Key blueKey = new Key();
        blueKey.setX(37 * screen.getScaledTile());
        blueKey.setY(46 * screen.getScaledTile());
        blueKey.setColor("blue");
        blueKey.setColorPicture();
        items[6] = blueKey;

        Key greenKey = new Key();
        greenKey.setX(45 * screen.getScaledTile());
        greenKey.setY(5 * screen.getScaledTile());
        greenKey.setColor("green");
        greenKey.setColorPicture();
        items[7] = greenKey;

        Potion potion = new Potion();
        potion.setX(4 * screen.getScaledTile());
        potion.setY(3 * screen.getScaledTile());
        items[8] = potion;

        return items;
    }
}
