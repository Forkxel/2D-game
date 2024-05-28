package entity;

import window.Screen;

import java.util.ArrayList;

public class MonsterPlacement {

    private Screen screen;

    public MonsterPlacement(Screen screen) {
        this.screen = screen;
    }

    public ArrayList<Monster> addMonsters(){
        ArrayList<Monster> monsters = new ArrayList<>();

        Monster monster1 = new Monster(screen);
        monster1.setX(screen.getScaledTile()*37);
        monster1.setY(screen.getScaledTile()*43);
        monster1.setMaxX(screen.getScaledTile()*39);
        monster1.setMaxY(screen.getScaledTile()*47);
        monster1.setMinX(screen.getScaledTile()*32);
        monster1.setMinY(screen.getScaledTile()*41);
        monsters.add(monster1);

        return monsters;
    }
}
