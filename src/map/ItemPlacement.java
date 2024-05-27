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
        items.getFirst().setY(21 * screen.getScaledTile());
        items.getFirst().setColor("yellow");
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
        items.get(3).setY(13 * screen.getScaledTile());
        items.get(3).setColor("red");
        items.get(3).setColorPicture();

        items.add(new Doors());
        items.get(4).setX(43 * screen.getScaledTile());
        items.get(4).setY(23 * screen.getScaledTile());
        items.get(4).setColor("blue");
        items.get(4).setColorPicture();

        items.add(new Chest());
        items.get(5).setX(24 * screen.getScaledTile());
        items.get(5).setY(5 * screen.getScaledTile());

        items.add(new Key());
        items.get(6).setX(37 * screen.getScaledTile());
        items.get(6).setY(46 * screen.getScaledTile());
        items.get(6).setColor("blue");
        items.get(6).setColorPicture();

        items.add(new Key());
        items.get(7).setX(45 * screen.getScaledTile());
        items.get(7).setY(5 * screen.getScaledTile());
        items.get(7).setColor("green");
        items.get(7).setColorPicture();

        items.add(new Key());
        items.get(8).setX(45 * screen.getScaledTile());
        items.get(8).setY(5 * screen.getScaledTile());
        items.get(8).setColor("green");
        items.get(8).setColorPicture();

        items.add(new Doors());
        items.get(9).setX(24 * screen.getScaledTile());
        items.get(9).setY(8 * screen.getScaledTile());
        items.get(9).setColor("green");
        items.get(9).setColorPicture();

        items.add(new Chest());
        items.get(10).setX(24 * screen.getScaledTile());
        items.get(10).setY(5 * screen.getScaledTile());

        items.add(new Key());
        items.get(11).setX(9 * screen.getScaledTile());
        items.get(11).setY(40 * screen.getScaledTile());
        items.get(11).setColor("red");
        items.get(11).setColorPicture();

        items.add(new Doors());
        items.get(12).setX(38 * screen.getScaledTile());
        items.get(12).setY(13 * screen.getScaledTile());
        items.get(12).setColor("red");
        items.get(12).setColorPicture();

        items.add(new Key());
        items.get(13).setX(36 * screen.getScaledTile());
        items.get(13).setY(21 * screen.getScaledTile());
        items.get(13).setColor("yellow");
        items.get(13).setColorPicture();

        items.add(new Key());
        items.get(14).setX(37 * screen.getScaledTile());
        items.get(14).setY(46 * screen.getScaledTile());
        items.get(14).setColor("blue");
        items.get(14).setColorPicture();

        items.add(new Doors());
        items.get(15).setX(43 * screen.getScaledTile());
        items.get(15).setY(23 * screen.getScaledTile());
        items.get(15).setColor("blue");
        items.get(15).setColorPicture();

        return items;
    }
}
