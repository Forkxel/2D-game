package map;

import object.Chest;
import object.Doors;
import object.Key;
import object.Item;
import window.Screen;

import java.util.ArrayList;

public class ItemPlacement {

    Screen screen;
    ArrayList<Item> items;

    public ItemPlacement(Screen panel) {
        this.screen = panel;
    }

    public ArrayList<Item> addObjects(){
        items = new ArrayList<>();
        items.add(new Key());
        items.getFirst().setX(36 * screen.getScaledTile());
        items.getFirst().setY(11 * screen.getScaledTile());
        items.getFirst().setColor("blue");
        items.getFirst().setColorPicture();

        items.add(new Key());
        items.get(1).setX(9 * screen.getScaledTile());
        items.get(1).setY(40 * screen.getScaledTile());
        items.get(1).setColor("red");
        items.get(1).setColorPicture();

        items.add(new Doors());
        items.get(2).setX(24 * screen.getScaledTile());
        items.get(2).setY(8 * screen.getScaledTile());
        items.get(2).setColor("green");
        items.get(2).setColorPicture();

        items.add(new Doors());
        items.get(3).setX(38 * screen.getScaledTile());
        items.get(3).setY(21 * screen.getScaledTile());
        items.get(3).setColor("yellow");
        items.get(3).setColorPicture();

        items.add(new Doors());
        items.get(4).setX(38 * screen.getScaledTile());
        items.get(4).setY(13 * screen.getScaledTile());
        items.get(4).setColor("red");
        items.get(4).setColorPicture();

        items.add(new Doors());
        items.get(5).setX(43 * screen.getScaledTile());
        items.get(5).setY(23 * screen.getScaledTile());
        items.get(5).setColor("blue");
        items.get(5).setColorPicture();

        items.add(new Chest());
        items.get(6).setX(24 * screen.getScaledTile());
        items.get(6).setY(5 * screen.getScaledTile());

        items.add(new Key());
        items.get(7).setX(37 * screen.getScaledTile());
        items.get(7).setY(46 * screen.getScaledTile());
        items.get(7).setColor("green");
        items.get(7).setColorPicture();

        return items;
    }
}
