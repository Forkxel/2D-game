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

        Monster monster2 = new Monster(screen);
        monster2.setX(screen.getScaledTile()*42);
        monster2.setY(screen.getScaledTile()*19);
        monster2.setMaxX(screen.getScaledTile()*44);
        monster2.setMaxY(screen.getScaledTile()*17);
        monster2.setMinX(screen.getScaledTile()*39);
        monster2.setMinY(screen.getScaledTile()*11);
        monsters.add(monster2);

        Monster monster3 = new Monster(screen);
        monster3.setX(screen.getScaledTile()*41);
        monster3.setY(screen.getScaledTile()*20);
        monster3.setMaxX(screen.getScaledTile()*44);
        monster3.setMaxY(screen.getScaledTile()*22);
        monster3.setMinX(screen.getScaledTile()*39);
        monster3.setMinY(screen.getScaledTile()*17);
        monsters.add(monster3);

        Monster monster4 = new Monster(screen);
        monster4.setX(screen.getScaledTile()*36);
        monster4.setY(screen.getScaledTile()*19);
        monster4.setMaxX(screen.getScaledTile()*37);
        monster4.setMaxY(screen.getScaledTile()*22);
        monster4.setMinX(screen.getScaledTile()*35);
        monster4.setMinY(screen.getScaledTile()*17);
        monsters.add(monster4);

        Monster monster5 = new Monster(screen);
        monster5.setX(screen.getScaledTile()*20);
        monster5.setY(screen.getScaledTile()*16);
        monster5.setMaxX(screen.getScaledTile()*24);
        monster5.setMaxY(screen.getScaledTile()*19);
        monster5.setMinX(screen.getScaledTile()*16);
        monster5.setMinY(screen.getScaledTile()*9);
        monsters.add(monster5);

        Monster monster6 = new Monster(screen);
        monster6.setX(screen.getScaledTile()*28);
        monster6.setY(screen.getScaledTile()*11);
        monster6.setMaxX(screen.getScaledTile()*30);
        monster6.setMaxY(screen.getScaledTile()*19);
        monster6.setMinX(screen.getScaledTile()*25);
        monster6.setMinY(screen.getScaledTile()*9);
        monsters.add(monster6);

        Monster monster7 = new Monster(screen);
        monster7.setX(screen.getScaledTile()*18);
        monster7.setY(screen.getScaledTile()*16);
        monster7.setMaxX(screen.getScaledTile()*24);
        monster7.setMaxY(screen.getScaledTile()*19);
        monster7.setMinX(screen.getScaledTile()*16);
        monster7.setMinY(screen.getScaledTile()*9);
        monsters.add(monster7);

        Monster monster8 = new Monster(screen);
        monster8.setX(screen.getScaledTile()*26);
        monster8.setY(screen.getScaledTile()*11);
        monster8.setMaxX(screen.getScaledTile()*30);
        monster8.setMaxY(screen.getScaledTile()*19);
        monster8.setMinX(screen.getScaledTile()*25);
        monster8.setMinY(screen.getScaledTile()*9);
        monsters.add(monster8);

        Monster monster9 = new Monster(screen);
        monster9.setX(screen.getScaledTile()*15);
        monster9.setY(screen.getScaledTile()*3);
        monster9.setMaxX(screen.getScaledTile()*21);
        monster9.setMaxY(screen.getScaledTile()*6);
        monster9.setMinX(screen.getScaledTile()*11);
        monster9.setMinY(screen.getScaledTile()*2);
        monsters.add(monster9);

        Monster monster10 = new Monster(screen);
        monster10.setX(screen.getScaledTile()*4);
        monster10.setY(screen.getScaledTile()*7);
        monster10.setMaxX(screen.getScaledTile()*5);
        monster10.setMaxY(screen.getScaledTile()*12);
        monster10.setMinX(screen.getScaledTile()*3);
        monster10.setMinY(screen.getScaledTile()*3);
        monsters.add(monster10);

        Monster monster11 = new Monster(screen);
        monster11.setX(screen.getScaledTile()*9);
        monster11.setY(screen.getScaledTile()*38);
        monster11.setMaxX(screen.getScaledTile()*7);
        monster11.setMaxY(screen.getScaledTile()*42);
        monster11.setMinX(screen.getScaledTile()*3);
        monster11.setMinY(screen.getScaledTile()*36);
        monsters.add(monster11);

        return monsters;
    }
}
